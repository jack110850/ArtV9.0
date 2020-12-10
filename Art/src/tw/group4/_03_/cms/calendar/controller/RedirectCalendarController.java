package tw.group4._03_.cms.calendar.controller;

import java.util.List;

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
import tw.group4.util.IdentityFilter;

@Controller
public class RedirectCalendarController {

	@Autowired
	private CreativeShopService css;

	@Autowired
	private ShopCalendarService scs;

	@RequestMapping(path = "/03/cms/calendar/index.ctrl", method = RequestMethod.GET)
	public String calendarIndex(Model m) {

		try {
			List<CreativeShopBean> shopsList = css.selectByReservation();
			m.addAttribute("acShopsList", shopsList);

		} catch (Exception e) {
			e.printStackTrace();

			String acShopsSerachMsg = "搜尋出錯，請嘗試重新載入";
			m.addAttribute("acShopsSerachMsg", acShopsSerachMsg); // 回傳錯誤訊息
		}
		return IdentityFilter.loginID+"03/cms_calendar/index";
	}

	@RequestMapping(path = "/03/cms/calendar/calendarManagement.ctrl", method = RequestMethod.POST)
	public String calendarManagement(@RequestParam(name = "shopId") String shopId, Model m) {

		try {
			int id = Integer.parseInt(shopId);
			CreativeShopBean shop = css.select(id);
			m.addAttribute("shop", shop);

		} catch (Exception e) {
			e.printStackTrace();

			String acShopsSerachMsg = "搜尋出錯，請嘗試重新載入";
			m.addAttribute("acShopsSerachMsg", acShopsSerachMsg); // 回傳錯誤訊息
		}
		return IdentityFilter.loginID+"03/cms_calendar/calendar_management";
	}

	@PostMapping(value = "/03/cms/calendar/searchByYearMonth.ctrl", produces = { "application/json; charset=UTF-8" })
	public @ResponseBody List<ShopCalendarBean> searchByYearMonth(
			@RequestParam(name = "shopId") String shopId,
			@RequestParam(name = "year") String year, 
			@RequestParam(name = "month") String month) {

		List<ShopCalendarBean> calendarList = scs.selectByYearMonth(Integer.parseInt(shopId), Integer.parseInt(year),
				Integer.parseInt(month));
		return calendarList;
	}

}
