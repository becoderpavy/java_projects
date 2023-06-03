package com.ebook.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;
import org.springframework.web.multipart.MultipartFile;

import com.ebook.dto.BookDto;
import com.ebook.entites.Books;
import com.ebook.entites.Category;
import com.ebook.entites.User;
import com.ebook.exception.ResourceNotFoundException;
import com.ebook.mapper.BookMapper;
import com.ebook.payloads.BookResponse;
import com.ebook.payloads.CountDetails;
import com.ebook.repository.BookOrderRepository;
import com.ebook.repository.BookRepository;
import com.ebook.repository.CategoryRepository;
import com.ebook.repository.UserRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepo;

	@Autowired
	private BookOrderRepository orderRepo;

	@Autowired
	private CategoryRepository cateRepo;

	@Autowired
	private BookMapper bookMapper;

	@Autowired
	private UserRepository userRepo;

	@Value("${project.image}")
	private String path;

	@Autowired
	private FileService fileService;

	@Override
	public BookDto createBook(BookDto bookDto, MultipartFile file) {

		Category cat = cateRepo.findById(bookDto.getCategorysId()).get();

		Books book = this.bookMapper.dtoToBook(bookDto);
		book.setCategory(cat);
		if (!file.isEmpty()) {
			book.setImg(file.getOriginalFilename());
		} else {
			book.setImg("default.jpg");
		}

		Books newBook = bookRepo.save(book);

		if (newBook != null) {
			try {
				fileService.uploadImage(path, file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return this.bookMapper.bookToDto(newBook);
	}

	@Override
	public BookDto updateBook(BookDto bookDto, MultipartFile file) {
		Books b = bookRepo.findById(bookDto.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Book", "Id", bookDto.getId()));

		Category cat = cateRepo.findById(bookDto.getCategorysId()).get();

		if (file != null) {
			b.setImg(file.getOriginalFilename());
			try {
				fileService.uploadImage(path, file);
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

		b.setBookName(bookDto.getBookName());
		b.setAuthor(bookDto.getAuthor());
		b.setCategory(cat);
		b.setIsbnNo(bookDto.getIsbnNo());
		b.setPrice(bookDto.getPrice());
		b.setLanguage(bookDto.getLanguage());
		b.setDescription(bookDto.getDescription());

		return bookMapper.bookToDto(bookRepo.save(b));
	}

	@Override
	public void deleteBook(Integer id) {
		Books b = bookRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book", "Id", id));
		bookRepo.delete(b);
	}

	@Override
	public BookResponse getAllBooks(int pageNo, int pageSize, String sortBy, String sortDir) {

		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
				: Sort.by(sortBy).descending();

		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

		Page<Books> pageList = bookRepo.findAll(pageable);

		List<Books> list = pageList.getContent();

		List<BookDto> bookDtoList = list.stream().map((book) -> bookMapper.bookToDto(book))
				.collect(Collectors.toList());

		BookResponse bookResponse = new BookResponse();
		bookResponse.setBook(bookDtoList);
		bookResponse.setPageNumber(pageList.getNumber());
		bookResponse.setPageSize(pageList.getSize());
		bookResponse.setTotalElements(pageList.getTotalElements());
		bookResponse.setTotalPages(pageList.getTotalPages());
		bookResponse.setLastPage(pageList.isLast());

		return bookResponse;
	}

	@Override
	public List<BookDto> getAllBook() {

		return bookRepo.findAll().stream().map((b) -> bookMapper.bookToDto(b)).collect(Collectors.toList());
	}

	@Override
	public BookDto getBookById(Integer id) {
		Books b = bookRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book", "Id", id));
		return bookMapper.bookToDto(b);
	}

	@Override
	public void getImage(String imgName, HttpServletResponse response) throws IOException {
		InputStream resource = fileService.getResource(path, imgName);
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		StreamUtils.copy(resource, response.getOutputStream());
	}

	@Override
	public CountDetails countData() {

		return new CountDetails(bookRepo.count(), cateRepo.count(), orderRepo.count());
	}

	@Override
	public User updateProfile(User user) {
		return userRepo.save(user);
	}

	@Override
	public List<BookDto> searchBook(String ch) {
		return bookRepo.search(ch).stream().map((e) -> bookMapper.bookToDto(e)).collect(Collectors.toList());
	}

}
