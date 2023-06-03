package com.rental.service;

import java.util.List;

import com.rental.dto.BrandDto;
import com.rental.entites.Brands;

public interface BrandService {

	BrandDto createBrands(BrandDto brand);

	BrandDto getBrandsById(Integer id);

	List<BrandDto> getAllBrands();

	void deleteBrands(Integer id);

	BrandDto updateBrands(Integer id, BrandDto brandDto);

}
