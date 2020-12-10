package tw.group4._03_.csr.shop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import tw.group4._03_.cms.shop.model.CreativeShopBean;
import tw.group4._03_.cms.shop.model.CreativeShopService;
import tw.group4._35_.login.model.WebsiteMember;
import tw.group4.util.IdentityFilter;

@Controller
public class SearchShopF2 {

	@Autowired
	private CreativeShopService css;

	@RequestMapping(path = "/03/csr/shop/searchShopByShopNameAndMemberId.ctrl", method = RequestMethod.POST)
	public String searchShopByShopName(@RequestParam(name = "shopName") String shopName, HttpSession session, Model m) {

		try {
			// 從HttpSession中，獲得memberId
			WebsiteMember member = (WebsiteMember) session.getAttribute("member");
			int memberId = member.getId();

			List<CreativeShopBean> shopsList = css.selectByShopNameAndMemberId(shopName, memberId);
			if (shopsList.size() != 0) {
				m.addAttribute("acShopsList", shopsList);
			} else {
				String acShopsSerachMsg = "查無此商店資料，請重新查詢";
				m.addAttribute("acShopsSerachMsg", acShopsSerachMsg);
			}
		} catch (Exception e) {
			e.printStackTrace();

			String acShopsSerachMsg = "商店資料搜尋失敗";
			m.addAttribute("acShopsSerachMsg", acShopsSerachMsg); // 回傳錯誤訊息
		}
		return IdentityFilter.loginID+"03/csr_shop/search_return";
	}

//	@RequestMapping(path = "/03/cms/shop/searchShopByShopId.ctrl", method = RequestMethod.POST)
//	public String searchShopByShopId(@RequestParam(name = "shopId") String shopId, Model m) {
//
//		try {
//			int id = Integer.parseInt(shopId);
//			List<CreativeShopBean> shopsList = css.selectByShopId(id);
//			/*
//			 * 不可使用(shopsList != null) shopsList 會含一個空字串
//			 */
//			if (shopsList.size() != 0) {
//				m.addAttribute("acShopsList", shopsList);
//
//			} else {
//				String acShopsSerachMsg = "查無此商店資料，請重新查詢";
//				System.out.println(acShopsSerachMsg);
//				m.addAttribute("acShopsSerachMsg", acShopsSerachMsg);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//
//			String acShopsSerachMsg = "商店資料搜尋出錯，請重新查詢";
//			m.addAttribute("acShopsSerachMsg", acShopsSerachMsg); // 回傳錯誤訊息
//		}
//		return "03/cms_shop/search_return";
//
//	}

//	@RequestMapping(path = "/03/cms/shop/searchAllShops.ctrl", method = RequestMethod.POST)
//	public String searchAllShops(Model m) {
//		try {
//			List<CreativeShopBean> shopsList = css.selectAll();
//
//			if (shopsList.size() != 0) {
//				m.addAttribute("acShopsList", shopsList);
//			} else {
//				String acShopsSerachMsg = "查無此商店資料，請重新查詢";
//				m.addAttribute("acShopsSerachMsg", acShopsSerachMsg);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//
//			String acShopsSerachMsg = "商店資料搜尋出錯，請重新查詢";
//			m.addAttribute("acShopsSerachMsg", acShopsSerachMsg); // 回傳錯誤訊息
//		}
//		return "03/cms_shop/search_return";
//	}

}
