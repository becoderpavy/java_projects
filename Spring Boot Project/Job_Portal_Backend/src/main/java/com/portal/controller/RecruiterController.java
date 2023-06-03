package com.portal.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.portal.entity.Jobs;
import com.portal.entity.UserDtls;
import com.portal.service.RecruiterService;

@RestController
@RequestMapping("/api/recruiter")
public class RecruiterController {

	@Autowired
	private RecruiterService recruiterService;

	@PostMapping("/saveJobs")
	public ResponseEntity<?> saveJobs(@RequestBody Jobs job, HttpServletRequest request) {

		return new ResponseEntity<>(recruiterService.saveJobs(job, request), HttpStatus.CREATED);
	}

	@GetMapping("/getAllJobs")
	public ResponseEntity<?> getAllJobs(HttpServletRequest request) {
		return new ResponseEntity<>(recruiterService.getAllJobs(request), HttpStatus.OK);
	}
	
	@GetMapping("/getAllJobsForAdmin")
	public ResponseEntity<?> getAllJobsForAdmin(HttpServletRequest request) {
		return new ResponseEntity<>(recruiterService.getAllJob(), HttpStatus.OK);
	}

	@GetMapping("/getJobById/{id}")
	public ResponseEntity<?> getJobById(@PathVariable int id) {
		return new ResponseEntity<>(recruiterService.getJobById(id), HttpStatus.OK);
	}

	@DeleteMapping("/deleteJob/{id}")
	public ResponseEntity<?> deleteJob(@PathVariable int id) {
		return new ResponseEntity<>(recruiterService.deleteJobs(id), HttpStatus.OK);
	}

	@PutMapping("/updateJob/{id}")
	public ResponseEntity<?> updateJobs(@PathVariable int id, @RequestBody Jobs job) {
		return new ResponseEntity<>(recruiterService.updateJobs(id, job), HttpStatus.OK);
	}

	@GetMapping("/getAllCandidates")
	public ResponseEntity<?> getAllCandidates(HttpServletRequest request) {
		return new ResponseEntity<>(recruiterService.getAllCandidates(request), HttpStatus.OK);
	}

	@GetMapping("/getCandidateByJobId/{jobId}")
	public ResponseEntity<?> getCandidateByJobId(HttpServletRequest request, @PathVariable int jobId) {
		return new ResponseEntity<>(recruiterService.getCandidatesByJobId(request, jobId), HttpStatus.OK);
	}

	@GetMapping("/getCandidateById/{id}")
	public ResponseEntity<?> getCandidateById(@PathVariable int id) {
		return new ResponseEntity<>(recruiterService.getCandidatesById(id), HttpStatus.OK);
	}

	@GetMapping("/updateInStatus")
	public ResponseEntity<?> updateInterviewStatus(@RequestParam("id") int id, @RequestParam("date") String date) {
		return new ResponseEntity<>(recruiterService.updateCanStatus(id, date), HttpStatus.OK);
	}

	@PostMapping("/updateProfile")
	public ResponseEntity<?> updateProfile(@RequestBody UserDtls user) {

		return new ResponseEntity<>(recruiterService.updateProfile(user), HttpStatus.CREATED);
	}
}
