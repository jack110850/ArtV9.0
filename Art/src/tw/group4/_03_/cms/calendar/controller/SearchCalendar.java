package tw.group4._03_.cms.calendar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import tw.group4._03_.cms.shop.model.CreativeShopBean;
import tw.group4._03_.cms.shop.model.CreativeShopService;
import tw.group4.util.IdentityFilter;

@Controller
public class SearchCalendar {

	@Autowired
	private CreativeShopService css;

	@RequestMapping(path = "/03/cms/calendar/searchShopByShopNameAndReservation.ctrl", method = RequestMethod.POST)
	public String searchShopByShopNameAndReservation(@RequestParam(name = "shopName") String shopName, Model m) {

		try {
			List<CreativeShopBean> shopsList = css.selectByShopNameAndReservation(shopName);

			if (shopsList.size() != 0) {
				m.addAttribute("acShopsList", shopsList);
			} else {
				String acShopsSerachMsg = "查無商店資料，請重新查詢";
				m.addAttribute("acShopsSerachMsg", acShopsSerachMsg);
			}
		} catch (Exception e) {
			e.printStackTrace();

			String acShopsSerachMsg = "搜尋出錯，請重新查詢";
			m.addAttribute("acShopsSerachMsg", acShopsSerachMsg); // 回傳錯誤訊息
		}
		return IdentityFilter.loginID+"03/cms_calendar/search_shop";
	}

}
