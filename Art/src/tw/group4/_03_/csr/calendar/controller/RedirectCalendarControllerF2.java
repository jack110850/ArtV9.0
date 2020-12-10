package tw.group4._03_.csr.calendar.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.group4._03_.cms.calendar.model.ShopCalendarBean;
import tw.group4._03_.cms.calendar.model.ShopCalendarService;
import tw.group4._03_.cms.shop.model.CreativeShopBean;
import tw.group4._03_.cms.shop.model.CreativeShopService;
import tw.group4._35_.login.model.WebsiteMember;
import tw.group4.util.IdentityFilter;

@Controller
public class RedirectCalendarControllerF2 {

	@Autowired
	private CreativeShopService css;

	@Autowired
	private ShopCalendarService scs;

	@RequestMapping(path = "/03/csr/calendar/myCalendar.ctrl", method = RequestMethod.POST)
	public String redirectToMyCalendar(HttpSession session, Model m) {

		// 從HttpSession中，獲得memberId
		WebsiteMember member = (WebsiteMember) session.getAttribute("member");
		int memberId = member.getId();
		
		try {
			List<CreativeShopBean> shopsList = css.selectByMemberIdAndReservation(memberId);
			m.addAttribute("acShopsList", shopsList);

		} catch (Exception e) {
			e.printStackTrace();

			String acShopsSerachMsg = "搜尋出錯，請嘗試重新載入";
			m.addAttribute("acShopsSerachMsg", acShopsSerachMsg); // 回傳錯誤訊息
		}
		return IdentityFilter.loginID+"03/csr_calendar/my_calendar";
	}

	@RequestMapping(path = "/03/csr/calendar/calendarManagement.ctrl", method = RequestMethod.POST)
	public String searchShopByShopId(@RequestParam(name = "shopId") String shopId, Model m) {

		try {
			int id = Integer.parseInt(shopId);
			CreativeShopBean shop = css.select(id);
			m.addAttribute("shop", shop);

		} catch (Exception e) {
			e.printStackTrace();

			String acShopsSerachMsg = "搜尋出錯，請嘗試重新載入";
			m.addAttribute("acShopsSerachMsg", acShopsSerachMsg); // 回傳錯誤訊息
		}
		return IdentityFilter.loginID+"03/csr_calendar/calendar_management";
	}

	@PostMapping(value = "/03/csr/calendar/searchByYearMonth.json", produces = { "application/json; charset=UTF-8" })
	public @ResponseBody List<ShopCalendarBean> searchByYearMonth(@RequestParam(name = "shopId") String shopId,
			@RequestParam(name = "year") String year, @RequestParam(name = "month") String month) {

		List<ShopCalendarBean> calendarList = scs.selectByYearMonth(Integer.parseInt(shopId), Integer.parseInt(year),
				Integer.parseInt(month));
		return calendarList;
	}

}
