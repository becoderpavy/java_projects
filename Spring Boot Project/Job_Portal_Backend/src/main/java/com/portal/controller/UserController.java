package com.portal.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.portal.entity.Candidates;
import com.portal.entity.UserDtls;
import com.portal.service.FileService;
import com.portal.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private FileService fileService;

	@Value("${project.resume}")
	private String path;

	@PostMapping("/applyJob")
	public ResponseEntity<?> applyJob(Candidates can, MultipartFile file, HttpServletRequest request) {

		/*
		 * System.out.println(file); System.out.println(can);
		 */

		return new ResponseEntity<>(userService.applyJob(can, file, request), HttpStatus.CREATED);
		// return new ResponseEntity<>("ok", HttpStatus.CREATED);
	}

	@GetMapping("/getAppliedJob")
	public ResponseEntity<?> getAppliedJob(HttpServletRequest request) {
		return new ResponseEntity<>(userService.getAppliedJob(request), HttpStatus.OK);
	}

	@GetMapping("/getAllJobs")
	public ResponseEntity<?> getAppliedJob() {
		return new ResponseEntity<>(userService.getAllJobs(), HttpStatus.OK);
	}

	@GetMapping("/checkAppliedJob/{uid}/{jid}")
	public ResponseEntity<?> checkAppliedJob(@PathVariable int uid, @PathVariable int jid) {
		return new ResponseEntity<>(userService.checkAppliedJob(uid, jid), HttpStatus.OK);
	}

	@GetMapping("/search")
	public ResponseEntity<?> checkAppliedJob(@RequestParam("ch") String ch) {
		return new ResponseEntity<>(userService.searchJob(ch), HttpStatus.OK);
	}

	@PostMapping("/updateProfile")
	public ResponseEntity<?> updateProfile(@RequestBody UserDtls user) {
		return new ResponseEntity<>(userService.updateProfile(user), HttpStatus.CREATED);
	}

	@GetMapping("/getAllUser")
	public ResponseEntity<?> getAllUser() {
		return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
	}

	@GetMapping("/getAllRecruiter")
	public ResponseEntity<?> getAllRecruiter() {
		return new ResponseEntity<>(userService.getAllRecruiter(), HttpStatus.OK);
	}

	@GetMapping("/downloadResume/{resume}")
	public ResponseEntity<?> excelStudentReport(@PathVariable String resume) throws IOException {

		InputStream in = fileService.getResource(path, resume);

		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Disposition", "attachment; filename=" + resume);
		headers.setContentType(MediaType.ALL);

		// return ResponseEntity.ok().headers(headers).body(new
		// InputStreamResource(in));
		return new ResponseEntity<>(in, headers, HttpStatus.OK);
	}
	
	 @GetMapping(path = "/download/{name}")
	    public ResponseEntity<Resource> download
	          (@PathVariable("name") String name) throws IOException {

	        File file = new File(path + name);
	        Path path = Paths.get(file.getAbsolutePath());
	        ByteArrayResource resource = 
	               new ByteArrayResource(Files.readAllBytes(path));

	        return ResponseEntity.ok().headers(this.headers(name))
	              .contentLength(file.length())
	                .contentType(MediaType
	                 .parseMediaType("application/octet-stream"))
	             .body(resource);
	    }

	/*
	 * @GetMapping("/files") public ResponseEntity<List<String>> getListOfFiles()
	 * throws Exception {
	 * 
	 * return new ResponseEntity<>(service.getListofFiles(), HttpStatus.OK);
	 * 
	 * }
	 */

	    private HttpHeaders headers(String name) {

	        HttpHeaders header = new HttpHeaders();
	        header.add(HttpHeaders.CONTENT_DISPOSITION, 
	                     "attachment; filename=" + name);
	        header.add("Cache-Control", 
	                     "no-cache, no-store, must-revalidate");
	        header.add("Pragma", "no-cache");
	        header.add("Expires", "0");
	        return header;

	    }

}
