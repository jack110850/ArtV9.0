package tw.group4._04_.back.cmsSeat.controller;

import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import oracle.net.aso.m;
import tw.group4._04_.back.cmsAct.model.ShowBean;
import tw.group4._04_.front.seat.model.SeatBean;
import tw.group4._04_.front.seat.model.SeatBeanDAO;
import tw.group4._04_.front.seat.model.SeatBeanService;
import tw.group4._04_.front.shopcart.model.Shoppingcart;
import tw.group4.util.IdentityFilter;

@Controller
public class CmsSeatCrud {
	
	@Autowired
	private SeatBean seatBean;
	@Autowired
	private SeatBeanService seatBeanService;
	@Autowired
	private Shoppingcart shoppingcart;
	
	//查詢座位
	@RequestMapping(path = "/04/CMS/seatSearch.ctrl", method = RequestMethod.GET)
	public String CMSseatSearch(int actno,Model model ,HttpSession session) {	
		
		Map<String, Integer>seatMap=seatBeanService.select(actno);
		System.out.println(seatMap);
		model.addAttribute("seat", seatMap);
		return IdentityFilter.loginID+"04/cms_Seat/Seat";
	}
	//存入訂單座位
	@RequestMapping(path = "/04/Cms/seatUpdate.ctrl", method = RequestMethod.GET)
	public String seatIInsert(
			 Integer actno,
			 Integer A1,
			 Integer A2,
			 Integer A3,
			 Integer A4,
			 Integer A5,
			 Integer A6,
			 Integer A7,
			 Integer A8,
			 Integer A9,
			 Integer A10,
			 Integer B1,
			 Integer B2,
			 Integer B3,
			 Integer B4,
			 Integer B5,
			 Integer B6,
			 Integer B7,
			 Integer B8,
			 Integer B9,
			 Integer B10,
			 Integer C1,
			 Integer C2,
			 Integer C3,
			 Integer C4,
			 Integer C5,
			 Integer C6,
			 Integer C7,
			 Integer C8,
			 Integer C9,
			 Integer C10,
			 Integer D1,
			 Integer D2,
			 Integer D3,
			 Integer D4,
			 Integer D5,
			 Integer D6,
			 Integer D7,
			 Integer D8,
			 Integer D9,
			 Integer D10,
			 Integer E1,
			 Integer E2,
			 Integer E3,
			 Integer E4,
			 Integer E5,
			 Integer E6,
			 Integer E7,
			 Integer E8,
			 Integer E9,
			 Integer E10,
			 Model model ,HttpSession session,HttpServletRequest request) {
		System.out.println("actno"+actno);
		System.out.println(A1);
		System.out.println(A2);
		System.out.println(A3);
		System.out.println(A4);
//		seatBean.setA1(A1);
//		seatBean.setA2(A2);
//		seatBean.setA3(A3);
//		seatBean.setA4(A4);
//		seatBean.setA5(A5);
//		seatBean.setA6(A6);
//		seatBean.setA7(A7);
//		seatBean.setA8(A8);
//		seatBean.setA9(A9);
//		seatBean.setA10(A10);
//		
//		seatBean.setB1(B1);
//		seatBean.setB2(B2);
//		seatBean.setB3(B3);
//		seatBean.setB4(B4);
//		seatBean.setB5(B5);
//		seatBean.setB6(B6);
//		seatBean.setB7(B7);
//		seatBean.setB8(B8);
//		seatBean.setB9(B9);
//		seatBean.setB10(B10);
//
//		seatBean.setC1(C1);
//		seatBean.setC2(C2);
//		seatBean.setC3(C3);
//		seatBean.setC4(C4);
//		seatBean.setC5(C5);
//		seatBean.setC6(C6);
//		seatBean.setC7(C7);
//		seatBean.setC8(C8);
//		seatBean.setC9(C9);
//		seatBean.setC10(C10);
//
//		seatBean.setD1(D1);
//		seatBean.setD2(D2);
//		seatBean.setD3(D3);
//		seatBean.setD4(D4);
//		seatBean.setD5(D5);
//		seatBean.setD6(D6);
//		seatBean.setD7(D7);
//		seatBean.setD8(D8);
//		seatBean.setD9(D9);
//		seatBean.setD10(D10);
//
//		seatBean.setE1(E1);
//		seatBean.setE2(E2);
//		seatBean.setE3(E3);
//		seatBean.setE4(E4);
//		seatBean.setE5(E5);
//		seatBean.setE6(E6);
//		seatBean.setE7(E7);
//		seatBean.setE8(E8);
//		seatBean.setE9(E9);
//		seatBean.setE10(E10);
		
		seatBeanService.update(
				actno,
				A1,	A2,	A3,	A4,	A5,	A6,	A7,	A8,	A9,	A10,
				B1,	B2,	B3,	B4,	B5,	B6,	B7,	B8,	B9,	B10,
				C1,	C2,	C3,	C4,	C5,	C6,	C7,	C8,	C9,	C10,
				D1,	D2,	D3,	D4,	D5,	D6,	D7,	D8,	D9,	D10,
				E1,	E2,	E3,	E4,	E5,	E6,	E7,	E8,	E9,	E10
				);

	
		return IdentityFilter.loginID+"04/cms_Act/categorySearch";
//		return IdentityFilter.loginID+"04/fromt_Seat/Seat";
	}
}
