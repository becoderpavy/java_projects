package com.prog.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.prog.entites.Bag;
import com.prog.entites.Category;
import com.prog.entites.Orders;
import com.prog.service.BagService;
import com.prog.service.OrderService;
import com.prog.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private BagService bagService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String home() {
		return "admin/index";
	}

	@GetMapping("/category")
	public String category(Model m) {
		m.addAttribute("category", bagService.getAllCategory());
		return "admin/category";
	}

	@GetMapping("/editCategory/{id}")
	public String editCategory(@PathVariable int id, Model m) {
		m.addAttribute("category", bagService.getCategoryById(id));
		return "admin/edit_category";
	}

	@GetMapping("/book")
	public String addBook(Model m) {
		m.addAttribute("category", bagService.getAllCategory());
		m.addAttribute("books", bagService.getAllBook());
		m.addAttribute("bagService", bagService);
		return "admin/add_bag";
	}

	@GetMapping("/editBook/{id}")
	public String editBook(Model m, @PathVariable int id) {
		m.addAttribute("book", bagService.getBookById(id));
		m.addAttribute("category", bagService.getAllCategory());
		return "admin/edit_bag";
	}

	@GetMapping("/orders")
	public String bookOrders(Model m) {
		m.addAttribute("orders", orderService.getAllOrders());
		m.addAttribute("bagService", bagService);
		m.addAttribute("userService", userService);
		return "admin/orders";
	}

	@GetMapping("/viewBook")
	public String viewBook(Model m) {
		m.addAttribute("category", bagService.getAllCategory());
		m.addAttribute("books", bagService.getAllBook());
		m.addAttribute("bagService", bagService);
		return "admin/view_bag";
	}

	@PostMapping("/addCategory")
	public String addCategory(@ModelAttribute Category category, HttpSession session) {

		if (bagService.addCategory(category) != null) {
			session.setAttribute("succMsg", "Category Added Sucessfully");
		} else {
			session.setAttribute("errorMsg", "Something wrong on server");
		}
		return "redirect:/admin/category";
	}

	@PostMapping("/updateCategory")
	public String updateCategory(@ModelAttribute Category category, HttpSession session) {

		if (bagService.addCategory(category) != null) {
			session.setAttribute("succMsg", "Category update Sucessfully");
		} else {
			session.setAttribute("errorMsg", "Something wrong on server");
		}
		return "redirect:/admin/category";
	}

	@GetMapping("/deleteCategory/{id}")
	public String deleteCategory(@PathVariable int id, HttpSession session) {

		if (bagService.deleteCategory(id)) {
			session.setAttribute("succMsg", "Category Delete Sucessfully");
		} else {
			session.setAttribute("errorMsg", "Something wrong on server");
		}
		return "redirect:/admin/category";
	}

	@PostMapping("/addBooks")
	public String addBooks(@ModelAttribute Bag book, @RequestParam("img") MultipartFile file, HttpSession session) {

		book.setImgName(file.getOriginalFilename());

		if (bagService.addBook(book) != null) {

			try {
				File saveFile = new ClassPathResource("static/book_img").getFile();

				Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + file.getOriginalFilename());
				// System.out.println(path);
				Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

			} catch (IOException e) {
				e.printStackTrace();
			}
			session.setAttribute("succMsg", "Bag Added Sucessfully");
		}
		return "redirect:/admin/book";
	}

	@PostMapping("/updateBook")
	public String updateBook(@ModelAttribute Bag book, @RequestParam("img") MultipartFile file, HttpSession session) {
		// System.out.println(file.isEmpty());
		if (!file.isEmpty()) {
			book.setImgName(file.getOriginalFilename());
		} else {
			Bag oldBook = bagService.getBookById(book.getId());
			book.setImgName(oldBook.getImgName());
		}

		if (bagService.addBook(book) != null) {

			try {
				if (!file.isEmpty()) {
					File saveFile = new ClassPathResource("static/book_img").getFile();

					Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + file.getOriginalFilename());
					// System.out.println(path);
					Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			session.setAttribute("succMsg", "Bag update Sucessfully");
		}
		return "redirect:/admin/viewBook";
	}

	@GetMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable int id, HttpSession session) {

		if (bagService.deleteBook(id)) {
			session.setAttribute("succMsg", "Bag Delete Sucessfully");
		} else {
			session.setAttribute("errorMsg", "Something wrong on server");
		}
		return "redirect:/admin/viewBook";
	}

	@GetMapping("/ordStatus")
	public String orderStatusUpdate(@RequestParam("id") int id, @RequestParam("st") String st, HttpSession session,
			Model m) {
		
		Orders order = orderService.getOrderById(id);
		order.setId(id);
		order.setStatus(st);
		if (orderService.updateOrders(order) != null) {
			session.setAttribute("succMsg", "Order Status update success");
		} else {
			session.setAttribute("errorMsg", "Something wrong in servre");
		}
		return "redirect:/admin/orders";
	}

}
