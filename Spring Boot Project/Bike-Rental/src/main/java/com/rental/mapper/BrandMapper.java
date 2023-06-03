package com.rental.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rental.dto.BrandDto;
import com.rental.entites.Brands;

@Component
public class BrandMapper {
	@Autowired
	private ModelMapper modelMapper;

	public Brands dtoToBrands(BrandDto brandDto) {
		return modelMapper.map(brandDto, Brands.class);
	}

	public BrandDto brandToDto(Brands brands) {
		return modelMapper.map(brands, BrandDto.class);
	}

}
