package com.portal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.portal.entites.Jobs;
import com.portal.repository.JobRepository;

@SpringBootApplication
public class SbtJobPortalApplication {

	@Autowired
	public JobRepository jobRepo;

	public static void main(String[] args) {
		SpringApplication.run(SbtJobPortalApplication.class, args);
	}

	

}
