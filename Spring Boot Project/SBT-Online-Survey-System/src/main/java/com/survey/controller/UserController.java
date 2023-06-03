package com.survey.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.survey.entity.SurveySubmission;
import com.survey.entity.UserDtls;
import com.survey.helper.Messages;
import com.survey.repository.SurveyQuestionRepository;
import com.survey.repository.SurveyRepository;
import com.survey.repository.SurveySubmissionRepo;
import com.survey.repository.UserRepository;
import com.survey.service.UserServiceImpl;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserRepository urepo;
	@Autowired
	private SurveyRepository surRepo;

	@Autowired
	private SurveyQuestionRepository surQuesRepo;

	@Autowired
	private SurveySubmissionRepo surSubRepo;

	@ModelAttribute
	public void addCommonData(Principal p, Model m) {
		String email = p.getName();
		UserDtls user = urepo.findByEmail(email);
		m.addAttribute("user", user);
	}

	@GetMapping("/home")
	public String home(Model m, Principal p) {

		List<Survey> list = surRepo.findByStatus("Active");
		
		List<Survey> notTakeList = new ArrayList<Survey>();
		String email = p.getName();
		UserDtls user = urepo.findByEmail(email);

		for (Survey s : list) {

			boolean res = surSubRepo.existsByUserIdAndSurveyId(user.getId(), s.getId());
			
			if(!res)
			{
				notTakeList.add(s);
			}

		}

		// notTakeList.forEach(e -> System.out.println(e));

		m.addAttribute("slist", notTakeList);
		return "user/home";
	}

	@GetMapping("/survey")
	public String mysurvey(Principal p,Model m) {
		
		List<Survey> list=new ArrayList<Survey>();
		
		String email = p.getName();
		UserDtls user = urepo.findByEmail(email);
		
		List<SurveySubmission> sslist=surSubRepo.findByUserId(user.getId());
		
		for(SurveySubmission s:sslist)
		{
			Optional<Survey> surveyList=surRepo.findById(s.getSurveyId());
			
			if(surveyList.isPresent())
			{
				list.add(surveyList.get());
			}

		}
		
		m.addAttribute("mylist",list);
		
		
		return "user/my_survey";
	}

	@GetMapping("/viewSurvey/{sid}")
	public String viewsurvey(@PathVariable int sid, Model m) {

		List<SurveyQuestion> list = surQuesRepo.findBySurveyId(sid);
		m.addAttribute("sqlist", list);
		m.addAttribute("l", list.size());

		Optional<Survey> slist = surRepo.findById(sid);

		m.addAttribute("survey", slist.get());

		return "user/view_survey";
	}

	@GetMapping("/search")
	public String searchSurvey(@RequestParam String keyword, Model m,Principal p) {
		List<Survey> list = surRepo.findByTitleContains(keyword);

		
		List<Survey> notTakeList = new ArrayList<Survey>();
		String email = p.getName();
		UserDtls user = urepo.findByEmail(email);

		for (Survey s : list) {

			boolean res = surSubRepo.existsByUserIdAndSurveyId(user.getId(), s.getId());
			
			if(!res)
			{
				notTakeList.add(s);
			}

		}
		
		
		m.addAttribute("searchList", notTakeList);

		return "user/home";
	}

	@PostMapping("/submitSurvey")
	public String submitSurvey(@ModelAttribute SurveySubmission ss, Model m,HttpSession session) {

		SurveySubmission s = surSubRepo.save(ss);

		m.addAttribute("sid", s);
		session.setAttribute("message", new Messages("Survey Submit Sucessfully", "text-success"));
		return "redirect:/user/home";
	}

	@GetMapping("/viewProfile")
	public String viewProfile() {
		return "user/view_profile";
	}

	@GetMapping("/editProfiles")
	public String editProfile() {
		return "user/edit_profile";
	}

	@PostMapping("/update_user")
	public String updateProfile(@ModelAttribute UserDtls user, Model m, HttpSession session) {
		Optional<UserDtls> ou = urepo.findById(user.getId());
		UserDtls oldUser = ou.get();

		user.setPassword(oldUser.getPassword());
		user.setRole(oldUser.getRole());

		UserDtls newUser = urepo.save(user);
		session.setAttribute("message", new Messages("Profile Update Sucessfully", "text-success"));
		return "redirect:/user/editProfiles";

	}

	@GetMapping("/view_one/{sid}")
	public String viewOneSurvey(@PathVariable int sid,Model m,Principal p)
	{
		String email = p.getName();
		UserDtls user = urepo.findByEmail(email);
		List<SurveyQuestion> list=surQuesRepo.findBySurveyId(sid);
		m.addAttribute("sslist",list);
		
		SurveySubmission sslit=surSubRepo.findBySurveyIdAndUserId(sid, user.getId());
		
		m.addAttribute("sans",sslit);
		
		return "user/view_one_survey";
	}
	
	

}
