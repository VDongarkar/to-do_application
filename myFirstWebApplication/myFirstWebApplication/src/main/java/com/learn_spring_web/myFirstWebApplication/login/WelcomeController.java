package com.learn_spring_web.myFirstWebApplication.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
//import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
//import org.springframework.web.bind.annotation.RequestParam;

@Controller
@SessionAttributes("name")
public class WelcomeController {
//	private AuthenticationService authenticationService;
	
	//private Logger logger = LoggerFactory.getLogger(getClass());

//	public LoginController(AuthenticationService authenticationService) {
//		super();
//		this.authenticationService = authenticationService;
//	}
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String gotowelcomePage(ModelMap model){
		model.put("name",getLoggedinUsername() );
		return "welcome";
	}
	
	private String getLoggedinUsername() {
		Authentication authentication = 
				SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
}
//	@RequestMapping(value = "login",method = RequestMethod.POST)
//	public String gotoWelcomePage(@RequestParam String name,@RequestParam String password,ModelMap model){
//		
//		if(authenticationService.authenticate(name, password)) {
//			model.put("name", name);
//			//model.put("password", password);
//			
//			
//			return "welcome";
//		}
//		
//		model.put("errorMessage", "Invalid Credentials! Please try again !");
//		return "login";
//	}

/*
 * 		@RequestParam String name,ModelMap model
 		model.put("name", name);
		logger.debug("Request param is {}",name);
		System.out.println("Request parameter is "+name);
 */

