package tw.group4._35_.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import tw.group4.util.IdentityFilter;

@Controller
public class SessionTimeout {
	
	@GetMapping("/35/sessionTimeout")
	public String sessionTimeout(){
		
		return IdentityFilter.loginID+"35/login/sessionTimeout";
	}
}
