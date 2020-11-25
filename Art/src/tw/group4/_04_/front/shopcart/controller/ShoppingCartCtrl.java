package tw.group4._04_.front.shopcart.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tw.group4._04_.front.seat.model.SeatBean;
import tw.group4._04_.front.seat.model.SeatBeanService;
import tw.group4._04_.front.shopcart.model.Shoppingcart;
import tw.group4.util.IdentityFilter;

@Controller
public class ShoppingCartCtrl {


		
		@Autowired
		private SeatBean seatBean;
		@Autowired
		private SeatBeanService seatBeanService;
		@Autowired
		private Shoppingcart shoppingcart;
		

		@RequestMapping(path = "/04/shoppingcart.ctrl", method = RequestMethod.GET)
		public String shoppingcart(Model model ,HttpSession session,HttpServletRequest Request) {
			String seats[]= Request.getParameterValues("seat");
			shoppingcart=(Shoppingcart) session.getAttribute("shoppingcart");
			shoppingcart.setSeats(seats);
			
			
			return IdentityFilter.loginID+"04/front_saleTicket/Booking2";
		}	
		
		@RequestMapping(path = "/04/shoppingcart2.ctrl", method = RequestMethod.GET)
		public String shoppingcart2(Model model ,HttpSession session,HttpServletRequest Request) {
			String seats[]= Request.getParameterValues("seat");
			shoppingcart=(Shoppingcart) session.getAttribute("shoppingcart");
			shoppingcart.setNAME(Request.getParameter("name"));
			shoppingcart.setEMAIL(Request.getParameter("email"));
			shoppingcart.setTEL(Request.getParameter("tel"));
			shoppingcart.setADDRESS(Request.getParameter("add"));		
			
			return IdentityFilter.loginID+"04/front_saleTicket/Booking3";
		}	
	
	
	
}
