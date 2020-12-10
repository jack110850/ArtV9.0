package tw.group4._03_.csr.reservation.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tw.group4._03_.cms.reservation.model.ShopReservationBean;
import tw.group4._03_.cms.reservation.model.ShopReservationService;
import tw.group4._35_.login.model.WebsiteMember;
import tw.group4.util.IdentityFilter;

@Controller
public class RedirectReservationControllerF2 {

	@Autowired
	private ShopReservationService srs;

	@RequestMapping(path = "/03/csr/reservation/myReservation.ctrl", method = RequestMethod.GET)
	public String redirectToMyReservation(HttpSession session, Model m) {

		try {
			// 從HttpSession中，獲得memberId
			WebsiteMember member = (WebsiteMember) session.getAttribute("member");
			int memberId = member.getId();

			// 取得該用戶的預約
			List<ShopReservationBean> reservationList = srs.selectByMemberId(memberId);

			if (reservationList.size() != 0) {
				m.addAttribute("reservationList", reservationList);
			} else {
				String reservationSerachMsg = "沒有預約商店資料!";
				m.addAttribute("reservationSerachMsg", reservationSerachMsg);
			}

		} catch (Exception e) {
			e.printStackTrace();

			String reservationSerachMsg = "查詢出錯，請嘗試重新載入";
			m.addAttribute("reservationSerachMsg", reservationSerachMsg); // 回傳錯誤訊息
		}
		return IdentityFilter.loginID+"03/csr_reservation/my_reservation";
	}

}
