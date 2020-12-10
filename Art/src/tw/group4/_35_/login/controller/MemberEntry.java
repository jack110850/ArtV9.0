package tw.group4._35_.login.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import tw.group4._35_.login.model.WebsiteMember;
import tw.group4._35_.login.model.WebsiteMemberService;
import tw.group4.util.IdentityFilter;

@Controller
public class MemberEntry {
	
	@Autowired
	private WebsiteMemberService service;
	
	@GetMapping("/35/memberEntry.ctrl")
	public String memberEntry(Model m){
		
		List<WebsiteMember> list = service.selectAllMembersBase64Str();
		m.addAttribute("membersList", list);
		
		return IdentityFilter.loginID+"35/login/memberManagement";
	}
	
	@GetMapping("/35/personelInfoEntry.ctrl")
	public String personelInfoEntry(Model m, HttpServletRequest request){
		
		HttpSession session = request.getSession();
		WebsiteMember member = (WebsiteMember)session.getAttribute("member");
		
		List<WebsiteMember> list = service.selectSingleMemberBase64Str(member.getName());
		m.addAttribute("membersList", list);
		
		return IdentityFilter.loginID+"35/login/personelInfoManagement";
	}

}
