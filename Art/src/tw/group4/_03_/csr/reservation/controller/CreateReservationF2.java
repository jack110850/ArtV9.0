package tw.group4._03_.csr.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import tw.group4._03_.cms.calendar.model.ShopCalendarBean;
import tw.group4._03_.cms.calendar.model.ShopCalendarService;
import tw.group4._03_.cms.reservation.model.ShopReservationBean;
import tw.group4._03_.cms.reservation.model.ShopReservationService;
import tw.group4._03_.cms.util.CustomizedTimeChange;
import tw.group4.util.IdentityFilter;

@Controller
public class CreateReservationF2 {

	@Autowired
	private ShopReservationService srs;

	@Autowired
	private ShopCalendarService scs;
	
	@RequestMapping(path = "/03/csr/reservation/createReservationDate.ctrl", method = RequestMethod.POST)
	public String createReservationDate(
			@RequestParam(name="memberId") String memberId,
			@RequestParam(name="memberName") String memberName,
			@RequestParam(name="shopId") String shopId,
			@RequestParam(name="shopName") String shopName,
			@RequestParam(name="intro") String intro,
			Model m) {
		try {
			m.addAttribute("memberId", memberId);
			m.addAttribute("memberName", memberName);
			m.addAttribute("shopId", shopId);
			m.addAttribute("shopName", shopName);
			m.addAttribute("intro", intro);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return IdentityFilter.loginID+"03/csr_reservation/create_choose_date";
	}
	
	@RequestMapping(path = "/03/csr/reservation/createReservationConfirm.ctrl", method = RequestMethod.POST)
	public String createReservationConfirm(
			@RequestParam(name="memberId") String memberId,
			@RequestParam(name="memberName") String memberName,
			@RequestParam(name="shopId") String shopId,
			@RequestParam(name="shopName") String shopName,
			@RequestParam(name="dateTime") String dateTime,
			Model m) {
		
		try {
//			#取得當天預約行事曆的備註、最大人數資料、開始時間、結束時間
			List<ShopCalendarBean> calendarList = scs.selectByDateTime(Integer.parseInt(shopId), dateTime);
			ShopCalendarBean calendar = calendarList.get(0);
			m.addAttribute("note", calendar.getNote());
			m.addAttribute("maximum", calendar.getMaximum());
			m.addAttribute("startTime", calendar.getStartTime());
			m.addAttribute("endTime", calendar.getEndTime());
			
//			#再生成 結束時間-1小時 [endTime-1]
			String endtime = calendar.getEndTime();
			CustomizedTimeChange customizedTimeChange = new CustomizedTimeChange();
			m.addAttribute("endTime-1", customizedTimeChange.timeChange(endtime, -1));
			
//			#取得當天已預約的時段
			List<ShopReservationBean> reservationList = srs.selectByDateTime(Integer.parseInt(shopId), dateTime);

			if (reservationList.size() != 0) {
				m.addAttribute("reservationList", reservationList);
			} 
			
			m.addAttribute("memberId", memberId);
			m.addAttribute("memberName", memberName);
			m.addAttribute("shopId", shopId);
			m.addAttribute("shopName", shopName);
			m.addAttribute("dateTime", dateTime);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return IdentityFilter.loginID+"03/csr_reservation/create_confirm";
	}
	
	@RequestMapping(path = "/03/csr/reservation/createReservation.ctrl", method = RequestMethod.POST)
	public String createReservation(
			@RequestParam(name="memberId") String memberId,
			@RequestParam(name="memberName") String memberName,
			@RequestParam(name="shopId") String shopId,
			@RequestParam(name="shopName") String shopName,
			
			@RequestParam(name="customerName") String customerName,
			@RequestParam(name="customerPhone") String customerPhone,
//			@RequestParam(name="adultsNum") String adultsNum,
//			@RequestParam(name="childrenNum") String childrenNum,
			@RequestParam(name="amount") String amount,
			
			@RequestParam(name="dateTime") String dateTime,	
			@RequestParam(name="startTime") String startTime,	
			@RequestParam(name="endTime") String endTime,
			@RequestParam(name="note") String note,
			Model m) {
		try {
			
			ShopReservationBean reservation = new ShopReservationBean();
//			測試
//			System.out.println("reservationNo = " + reservation.getReservationNo());
			
			reservation.setMemberId(Integer.parseInt(memberId));
			reservation.setMemberName(memberName);
			reservation.setShopId(Integer.parseInt(shopId));
			reservation.setShopName(shopName);
			
			reservation.setCustomerName(customerName);
			reservation.setCustomerPhone(customerPhone);
			reservation.setAdultsNum(0);
			reservation.setChildrenNum(0);
			reservation.setAmount(Integer.parseInt(amount));
			
			reservation.setDateTime(dateTime);
			reservation.setStartTime(startTime);
			reservation.setEndTime(endTime);
			reservation.setNote(note);
			
			srs.insert(reservation);
			
			String reservationCreateMsg = "商店預約新增成功";
			m.addAttribute("reservationCreateMsg", reservationCreateMsg);
			
		} catch (Exception e) {
			e.printStackTrace();
			
			String reservationCreateMsg = "商店預約新增失敗，請重新輸入";
			m.addAttribute("reservationCreateMsg", reservationCreateMsg); // 回傳錯誤訊息
		}
		return IdentityFilter.loginID+"03/csr_reservation/create_return";
	}

}
