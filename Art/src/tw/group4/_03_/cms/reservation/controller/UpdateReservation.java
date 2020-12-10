package tw.group4._03_.cms.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import tw.group4._03_.cms.reservation.model.ShopReservationBean;
import tw.group4._03_.cms.reservation.model.ShopReservationService;
import tw.group4.util.IdentityFilter;

@Controller
public class UpdateReservation {

	@Autowired
	private ShopReservationService srs;

	@RequestMapping(path = "/03/cms/reservation/updateReservation.ctrl", method = RequestMethod.POST)
	private String updateReservation( 
			@RequestParam(name = "reservationNo") String reservationNo,
			@RequestParam(name = "memberId") String memberId, 
			@RequestParam(name = "memberName") String memberName,
			@RequestParam(name = "shopId") String shopId, 
			@RequestParam(name = "shopName") String shopName,

			@RequestParam(name = "customerName") String customerName,
			@RequestParam(name = "customerPhone") String customerPhone,
			@RequestParam(name = "adultsNum") String adultsNum, 
			@RequestParam(name = "childrenNum") String childrenNum,
			@RequestParam(name = "amount") String amount,

			
			@RequestParam(name = "dateTime") String dateTime, 
			@RequestParam(name = "startTime") String startTime, 
			@RequestParam(name = "endTime") String endTime,
			@RequestParam(name = "note") String note,
			Model m) {
		try {
			int intReservationNo = Integer.parseInt(reservationNo);
			int intMemberId = Integer.parseInt(memberId);
			int intShopId = Integer.parseInt(shopId);
			int intAdultsNum = Integer.parseInt(adultsNum);
			int intChildrenNum = Integer.parseInt(childrenNum);
			int intAmount = Integer.parseInt(amount);

			// 執行更新
			srs.update(intReservationNo, intMemberId, memberName, intShopId, shopName, 
					customerName, customerPhone, intAdultsNum, intChildrenNum, intAmount, 
					dateTime, startTime, endTime, note);

			String reservationUpdateMsg = "商店資料修改成功";
			m.addAttribute("reservationUpdateMsg", reservationUpdateMsg);

		} catch (Exception e) {
			e.printStackTrace();
			String reservationUpdateMsg = "商店預約修改失敗，請重新輸入";
			m.addAttribute("reservationUpdateMsg", reservationUpdateMsg); // 回傳錯誤訊息
		}
		return IdentityFilter.loginID+"03/cms_reservation/update_return";
	}

	@RequestMapping(path = "/03/cms/reservation/updateReservationByNo.ctrl", method = RequestMethod.POST)
	private String updateReservationByNo(@RequestParam(name = "reservationNo") String reservationNo, Model m) {

		try {
			int no = Integer.parseInt(reservationNo);
			List<ShopReservationBean> reservationList = srs.selectByNo(no);

			if (reservationList.size() != 0) {
				m.addAttribute("reservationList", reservationList);
			} else {
				String reservationSerachMsg = "查無此預約資料，請重新查詢";
				System.out.println(reservationSerachMsg);
				m.addAttribute("reservationSerachMsg", reservationSerachMsg);
			}
		} catch (Exception e) {
			e.printStackTrace();

			String reservationSerachMsg = "搜尋出錯，請重新查詢";
			m.addAttribute("reservationSerachMsg", reservationSerachMsg); // 回傳錯誤訊息
		}
		return IdentityFilter.loginID+"03/cms_reservation/update_confirm";

	}

	@RequestMapping(path = "/03/cms/reservation/updateReservationByMemberName.ctrl", method = RequestMethod.POST)
	private String updateReservationByMemberName(@RequestParam(name = "memberName") String memberName, Model m) {

		try {
			List<ShopReservationBean> reservationList = srs.selectByMemberName(memberName);
			/*
			 * 不可使用xxxList != null) xxxList 會含一個空陣列
			 */
			if (reservationList.size() != 0) {
				m.addAttribute("reservationList", reservationList);
			} else {
				String reservationSerachMsg = "查無此預約資料，請重新查詢";
//				System.out.println(reservationSerachMsg);
				m.addAttribute("reservationSerachMsg", reservationSerachMsg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			String reservationSerachMsg = "搜尋出錯，請重新查詢";
			m.addAttribute("reservationSerachMsg", reservationSerachMsg); // 回傳錯誤訊息
		}
		return IdentityFilter.loginID+"03/cms_reservation/update_by_name";

	}

	@RequestMapping(path = "/03/cms/reservation/updateReservationByShopName.ctrl", method = RequestMethod.POST)
	public String updateReservationByShopName(@RequestParam(name = "shopName") String shopName, Model m) {

		try {
			List<ShopReservationBean> reservationList = srs.selectByShopName(shopName);

			if (reservationList.size() != 0) {
				m.addAttribute("reservationList", reservationList);
			} else {
				String reservationSerachMsg = "查無此預約資料，請重新查詢";
				m.addAttribute("reservationSerachMsg", reservationSerachMsg);
			}
		} catch (Exception e) {
			e.printStackTrace();

			String reservationSerachMsg = "搜尋出錯，請重新查詢";
			m.addAttribute("reservationSerachMsg", reservationSerachMsg); // 回傳錯誤訊息
		}
		return IdentityFilter.loginID+"03/cms_reservation/update_by_name";
	}

}
