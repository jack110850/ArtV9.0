package tw.group4._14_.front.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import tw.group4._14_.back.ARTProduct;
import tw.group4._14_.back.dao.ProductBeanDAOService;
import tw.group4._14_.front.model.MessageBoardAP;
import tw.group4._14_.front.model.dao.MessageBoardAPService;
import tw.group4._35_.login.model.WebsiteMemberService;

@Controller
public class MessageBoardController {
	
	@Autowired
	private MessageBoardAPService mbService;
	
	@Autowired
	private WebsiteMemberService wmService;
	
	@Autowired
	private ProductBeanDAOService pdService;
	
	@Autowired
	ServletContext ctx;
	
	
	@RequestMapping(path = "/14/showMessage/{apid}.ctrl")
	@ResponseBody
	public List<MessageBoardAP> showMessage(@PathVariable(name = "apid") int apid) {
		
		List<MessageBoardAP> list = mbService.selectPdBoardAPs(apid);
		
		return list;
		
	}
	
	
	@RequestMapping(path = "/14/saveMessage/{apid}.ctrl")
	@ResponseBody
	public String saveMessage(@PathVariable(name = "apid") int apid, HttpSession session, @RequestParam(name = "name") String name,
			@RequestParam(name = "subjectAP", required = false) String subjectAP, @RequestParam(name = "editor") String content,
			@RequestParam(name = "rate", required = false) int rate ) {
		
//		WebsiteMember mb = (WebsiteMember) session.getAttribute("member");
//		String memberID = mb.getName();
		Date today = new Date();
		MessageBoardAP mbAP = new MessageBoardAP();
		mbAP.setApId(apid);
		mbAP.setContent(content);
		mbAP.setMemberId(name);
		mbAP.setSubjectAP(subjectAP);
		mbAP.setTime(today);
		
		mbService.insert(mbAP);
		
		
		List<MessageBoardAP> list = mbService.selectPdBoardAPs(apid);
		
		ARTProduct ap = pdService.select(Integer.toString(apid));
		ap.setProductScore(ap.getProductScore() + rate);
		ap.setProductRater(ap.getProductRater() + 1);
		pdService.updateProduct(ap);

		
		Long count = mbService.countMessageNum(apid);
		
		Gson gson = new Gson();
		
		String json = gson.toJson(list);
		
		return json;
		
	}
	

	

}
