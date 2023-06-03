package com.rental.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rental.dto.BrandDto;
import com.rental.entites.Brands;
import com.rental.exception.ResourceNotFoundException;
import com.rental.mapper.BrandMapper;
import com.rental.repository.BrandRepository;

@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	private BrandRepository brandRepository;

	@Autowired
	private BrandMapper brandMapper;

	@Override
	public BrandDto createBrands(BrandDto brandDto) {
		Brands brand = brandMapper.dtoToBrands(brandDto);
		return brandMapper.brandToDto(brandRepository.save(brand));
	}

	@Override
	public BrandDto getBrandsById(Integer id) {
		return brandMapper.brandToDto(
				brandRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Brand", "Id", id)));
	}

	@Override
	public List<BrandDto> getAllBrands() {

		List<Brands> list = brandRepository.findAll();

		return list.stream().map((brand) -> brandMapper.brandToDto(brand)).collect(Collectors.toList());
	}

	@Override
	public void deleteBrands(Integer id) {

		Brands brand = brandRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Brand", "Id", id));
		if (brand != null) {
			brandRepository.delete(brand);
		}
	}

	@Override
	public BrandDto updateBrands(Integer id, BrandDto brandDto) {
		Brands oldBrand = brandRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Brand", "Id", id));
		brandDto.setId(oldBrand.getId());

		Brands brand = brandMapper.dtoToBrands(brandDto);

		return brandMapper.brandToDto(brandRepository.save(brand));
	}

}
