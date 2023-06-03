package com.rental.entites;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Brands {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String brandName;

	private String description;

	private String imgName;

	@OneToMany(mappedBy = "brand",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Bikes> bike;

}
