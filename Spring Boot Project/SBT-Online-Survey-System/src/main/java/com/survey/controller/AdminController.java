package com.survey.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.survey.entity.Survey;
import com.survey.entity.SurveyQuestion;
import com.survey.entity.UserDtls;
import com.survey.helper.Messages;
import com.survey.helper.UserDtlsResponse;
import com.survey.repository.SurveyQuestionRepository;
import com.survey.repository.SurveyRepository;
import com.survey.repository.SurveySubmissionRepo;
import com.survey.repository.UserRepository;
import com.survey.service.SurveyServiceImpl;
import com.survey.service.UserServiceImpl;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private UserServiceImpl userService;

	@Autowired
	private SurveyServiceImpl surveyService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private SurveyQuestionRepository surRepo;

	@Autowired
	private UserRepository urepo;
	
	@Autowired
	private SurveySubmissionRepo surSubRepo;
	
	@Autowired
	private SurveyRepository surveyRepo;
	


	@ModelAttribute
	public void addCommonData(Principal p, Model m) {
		String email = p.getName();
		UserDtls user = urepo.findByEmail(email);
		m.addAttribute("user", user);
	}

	@GetMapping("/")
	public String home2(Model m) {

		m.addAttribute("suno", surveyService.getSurveyNo());
		m.addAttribute("usno", userService.getUserNo());
		return "admin/home";
	}

	@GetMapping("/home")
	public String home(Model m) {
		m.addAttribute("suno", surveyService.getSurveyNo());
		m.addAttribute("usno", userService.getUserNo());
		return "admin/home";
	}

	@GetMapping("/add_user")
	public String addUser() {
		return "admin/add_new_user";
	}

	@GetMapping("/view_user/{page}")
	public String viewUser(@PathVariable int page, Model m) {

		UserDtlsResponse userdtls = userService.getAllUser(page);
		m.addAttribute("list", userdtls);

		return "admin/view_user";
	}

	@GetMapping("/add_survey")
	public String addSurvey() {
		return "admin/add_survey";
	}

	@GetMapping("/view_survey")
	public String viewSurvey(Model m) {
		List<Survey> list = surveyService.getAllSurvey();
		m.addAttribute("list", list);

		return "admin/view_survey";
	}

	@GetMapping("/view_one_survey/{uid}")
	public String viewOneSurvey(@PathVariable int uid, Model m) {

		Survey s = surveyService.getSurveyById(uid);

		List<SurveyQuestion> list = surRepo.findBySurveyId(uid);
		m.addAttribute("qlist", list);

		m.addAttribute("survey", s);
		return "admin/view_one_survey";
	}

	@GetMapping("/survey_report")
	public String surveyReport(Model m) {

		List<Survey> list = surveyService.getAllSurvey();
		m.addAttribute("slist", list);
		return "admin/survey_report";
	}

	@PostMapping("/create_user")
	public String createUser(@ModelAttribute("userDtls") UserDtls userDtls, HttpSession session, Model m) {
		userDtls.setPassword(passwordEncoder.encode(userDtls.getPassword()));

		if (userService.checkEmail(userDtls.getEmail())) {
			UserDtls user = userService.createUser(userDtls);
			if (user != null) {
				session.setAttribute("message", new Messages("Register Successfully", "text-success"));
				return "redirect:/admin/add_user";
			} else {
				m.addAttribute("user", userDtls);
				session.setAttribute("message", new Messages("Something wrong on server", "text-danger"));
				return "admin/add_user";
			}
		} else {
			m.addAttribute("user", userDtls);
			session.setAttribute("message", new Messages("User email id already exist", "text-danger"));
			return "admin/add_user";
		}
	}

	@PostMapping("/save_survey")
	public String saveSurvey(@ModelAttribute("survey") Survey survey, HttpSession session, Model m) {

		Survey sur = surveyService.saveSurvey(survey);
		if (sur != null) {
			session.setAttribute("message", new Messages("Survey Added Successfully", "text-success"));
			return "redirect:/admin/add_survey";
		} else {
			session.setAttribute("message", new Messages("Something wrong on server", "text-danger"));
			return "redirect:/admin/add_survey";
		}

	}

	@GetMapping("/viewUser/{uid}")
	public String viewOneUserDetails(@PathVariable long uid, Model m) {

		Optional<UserDtls> u = urepo.findById(uid);
		UserDtls user = u.get();
		m.addAttribute("userdtls", user);

		return "admin/view_one_user";
	}

	@GetMapping("/editUser/{uid}")
	public String viewEditDetails(@PathVariable long uid, Model m) {

		Optional<UserDtls> u = urepo.findById(uid);
		UserDtls user = u.get();
		m.addAttribute("userdtls", user);

		return "admin/edit_user";
	}

	@PostMapping("/updateProfile")
	public String updateUserProfile(@ModelAttribute UserDtls user, HttpSession session, Model m) {
		System.out.println(user);

		Optional<UserDtls> oldUser = urepo.findById(user.getId());
		UserDtls ou = oldUser.get();

		if (ou != null) {
			user.setPassword(ou.getPassword());
			UserDtls u = urepo.save(user);
			if (u != null) {
				session.setAttribute("message", new Messages("Profile Update Successfully", "text-success"));
				return "redirect:/admin/view_user/0";
			} else {
				m.addAttribute("user", u);
				session.setAttribute("message", new Messages("Something wrong on server", "text-danger"));
				return "admin/view_user/0";
			}

		} else {
			return "admin/view_user/0";
		}

	}

	@GetMapping("/deleteuser/{uid}")
	public String deleteUser(@PathVariable long uid, HttpSession session, Principal p) {

		String email = p.getName();
		UserDtls u = urepo.findByEmail(email);

		if ("ROLE_ADMIN".equals(u.getRole())) {
			urepo.deleteById(uid);
			session.setAttribute("message", new Messages("User Delete Successfully", "text-success"));
			return "redirect:/admin/view_user/0";
		} else {
			return "redirect:/admin/view_user/0";
		}

	}

	@PostMapping("/addQuestion")
	public String addQuestionAndAnswer(@ModelAttribute SurveyQuestion s, Model m, HttpSession session) {

		SurveyQuestion survey = surRepo.save(s);

		if (survey != null) {
			session.setAttribute("message", new Messages("Question Add Successfully", "text-success"));
			return "redirect:/admin/view_one_survey/" + s.getSurveyId();
		} else {
			session.setAttribute("message", new Messages("Something wrong on server", "text-danger"));
			return "redirect:/admin/view_one_survey/" + s.getSurveyId();
		}

	}

	@GetMapping("/view_one_report/{sid}")
	public String viewReportBySurvey(@PathVariable int sid,Model m) {
		Survey s = surveyService.getSurveyById(sid);

		List<SurveyQuestion> list = surRepo.findBySurveyId(sid);
		m.addAttribute("qlist", list);

		
//		/*
//		 * List<SurveySubmission> sblist=surSubRepo.findBySurveyId(sid);
//		 * 
//		 * for(SurveySubmission ss:sblist) {
//		 * 
//		 * }
//		 */
		
		m.addAttribute("survey", s);
		
		return "admin/view_report";
	}

	
	
	@GetMapping("/search_user")
	public String searchSurvey(@RequestParam String keyword, Model m) {
		
		List<UserDtls> userSearch = urepo.findByFirstNameOrLastNameContains(keyword, keyword);
		//userSearch.forEach(e->System.out.println(e));

		m.addAttribute("userSearch", userSearch);

		return "admin/view_search_user";
	}
	
	@GetMapping("/search_survey")
	public String searchSurveyUser(@RequestParam String keyword,Model m)
	{
		List<Survey> sslist=surveyRepo.findByTitleContains(keyword);
		m.addAttribute("survey_search",sslist);
		return "admin/view_survey";
	}
	
	
	@GetMapping("/search_report")
	public String searchSurveyReport(@RequestParam String keyword,Model m)
	{
		List<Survey> sslist=surveyRepo.findByTitleContains(keyword);
		m.addAttribute("survey_search",sslist);
		return "admin/survey_report";
	}
	
	@GetMapping("/aviewProfile")
	public String viewProfile()
	{
		return "admin/admin_view_profile";
	}
	
	

}
