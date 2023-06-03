package com.prog.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.prog.entites.Birth;
import com.prog.entites.Death;
import com.prog.entites.Marrige;
import com.prog.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@GetMapping("/")
	public String home() {
		return "admin/index";
	}

	@GetMapping("/viewBirth/{id}")
	public String viewBirth(@PathVariable long id, Model m) {
		m.addAttribute("birth", adminService.getBirthById(id));
		return "admin/view_birth";
	}

	@GetMapping("/viewMarriage/{id}")
	public String viewMarrige(@PathVariable long id, Model m) {
		m.addAttribute("ma", adminService.getMarriageById(id));
		return "admin/view_marriage";
	}

	@GetMapping("/viewDeath/{id}")
	public String viewDeath(@PathVariable long id, Model m) {
		m.addAttribute("death", adminService.getDeathById(id));
		return "admin/view_death";
	}

	@GetMapping("/statusBirth")
	public String statusBirth(Model m, Principal p) {
		m.addAttribute("list", adminService.getAllBirth());
		return "admin/status_birth";
	}

	@GetMapping("/statusDeath")
	public String statusDeath(Model m, Principal p) {

		m.addAttribute("list", adminService.getAllDeath());
		return "admin/status_death";
	}

	@GetMapping("/statusMarriage")
	public String statusMarriage(Model m, Principal p) {
		m.addAttribute("list", adminService.getAllMarriage());
		return "admin/status_marriage";
	}

	@GetMapping("/downloadBirth/{id}")
	public void downloadBirth(@PathVariable long id, HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		Birth b = adminService.getBirthById(id);
		OutputStream outStream = null;
		FileInputStream inputStream = null;
		try {
			File saveFile = new ClassPathResource("static/upload_birth").getFile();

			Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + b.getDocumentProof());

			File file = new File(path + "");

			if (file.exists()) {

				/**** Setting The Content Attributes For The Response Object ****/

				String mimeType = "application/octet-stream";
				response.setContentType(mimeType);

				/**** Setting The Headers For The Response Object ****/

				String headerKey = "Content-Disposition";
				String headerValue = String.format("attachment; filename=\"%s\"", file.getName());
				response.setHeader(headerKey, headerValue);

				/**** Get The Output Stream Of The Response ****/

				outStream = response.getOutputStream();
				inputStream = new FileInputStream(file);
				byte[] buffer = new byte[1024 * 100000];
				int bytesRead = -1;

				/****
				 * Write Each Byte Of Data Read From The Input Stream Write Each Byte Of Data
				 * Read From The Input Stream Into The Output Stream
				 ***/
				while ((bytesRead = inputStream.read(buffer)) != -1) {
					outStream.write(buffer, 0, bytesRead);
				}
			}
		} catch (IOException ioExObj) {
			System.out.println("Exception While Performing The I/O Operation?= " + ioExObj.getMessage());
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
			outStream.flush();
			if (outStream != null) {
				outStream.close();
			}
		}

	}

	@GetMapping("/downloadDeath/{id}")
	public void downloadDeath(@PathVariable long id, HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		Death d = adminService.getDeathById(id);
		OutputStream outStream = null;
		FileInputStream inputStream = null;
		try {
			File saveFile = new ClassPathResource("static/upload_death").getFile();

			Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + d.getProofDocument());

			File file = new File(path + "");

			if (file.exists()) {

				/**** Setting The Content Attributes For The Response Object ****/

				String mimeType = "application/octet-stream";
				response.setContentType(mimeType);

				/**** Setting The Headers For The Response Object ****/

				String headerKey = "Content-Disposition";
				String headerValue = String.format("attachment; filename=\"%s\"", file.getName());
				response.setHeader(headerKey, headerValue);

				/**** Get The Output Stream Of The Response ****/

				outStream = response.getOutputStream();
				inputStream = new FileInputStream(file);
				byte[] buffer = new byte[1024 * 100000];
				int bytesRead = -1;

				/****
				 * Write Each Byte Of Data Read From The Input Stream Write Each Byte Of Data
				 * Read From The Input Stream Into The Output Stream
				 ***/
				while ((bytesRead = inputStream.read(buffer)) != -1) {
					outStream.write(buffer, 0, bytesRead);
				}
			}
		} catch (IOException ioExObj) {
			System.out.println("Exception While Performing The I/O Operation?= " + ioExObj.getMessage());
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
			outStream.flush();
			if (outStream != null) {
				outStream.close();
			}
		}

	}

	@GetMapping("/downloadMarriage/{id}")
	public void downloadMarriage(@PathVariable long id, HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		Marrige m = adminService.getMarriageById(id);
		OutputStream outStream = null;
		FileInputStream inputStream = null;
		try {
			File saveFile = new ClassPathResource("static/upload_marrige").getFile();

			Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + m.getProofDocument());

			File file = new File(path + "");

			if (file.exists()) {

				/**** Setting The Content Attributes For The Response Object ****/

				String mimeType = "application/octet-stream";
				response.setContentType(mimeType);

				/**** Setting The Headers For The Response Object ****/

				String headerKey = "Content-Disposition";
				String headerValue = String.format("attachment; filename=\"%s\"", file.getName());
				response.setHeader(headerKey, headerValue);

				/**** Get The Output Stream Of The Response ****/

				outStream = response.getOutputStream();
				inputStream = new FileInputStream(file);
				byte[] buffer = new byte[1024 * 100000];
				int bytesRead = -1;

				/****
				 * Write Each Byte Of Data Read From The Input Stream Write Each Byte Of Data
				 * Read From The Input Stream Into The Output Stream
				 ***/
				while ((bytesRead = inputStream.read(buffer)) != -1) {
					outStream.write(buffer, 0, bytesRead);
				}
			}
		} catch (IOException ioExObj) {
			System.out.println("Exception While Performing The I/O Operation?= " + ioExObj.getMessage());
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
			outStream.flush();
			if (outStream != null) {
				outStream.close();
			}
		}

	}

	@GetMapping("/updateBirth/{st}/{id}")
	public String updateBirth(@PathVariable String st, @PathVariable long id, HttpSession session) {

		Birth b = adminService.getBirthById(id);
		b.setStatus(st);
		if (adminService.saveBirth(b) != null) {
			session.setAttribute("succMsg", "Status Update Sucessfully");
		} else {
			session.setAttribute("errorMsg", "something wrong on server");
		}
		return "redirect:/admin/statusBirth";
	}

	@GetMapping("/updateDeath/{st}/{id}")
	public String updateDeath(@PathVariable String st, @PathVariable long id, HttpSession session) {

		Death d = adminService.getDeathById(id);
		d.setStatus(st);
		if (adminService.saveDeath(d) != null) {
			session.setAttribute("succMsg", "Status Update Sucessfully");
		} else {
			session.setAttribute("errorMsg", "something wrong on server");
		}
		return "redirect:/admin/statusDeath";
	}

	@GetMapping("/updateMarriage/{st}/{id}")
	public String updateMarriage(@PathVariable String st, @PathVariable long id, HttpSession session) {

		Marrige m = adminService.getMarriageById(id);
		m.setStatus(st);
		if (adminService.saveMarriage(m) != null) {
			session.setAttribute("succMsg", "Status Update Sucessfully");
		} else {
			session.setAttribute("errorMsg", "something wrong on server");
		}
		return "redirect:/admin/statusMarriage";
	}

}
