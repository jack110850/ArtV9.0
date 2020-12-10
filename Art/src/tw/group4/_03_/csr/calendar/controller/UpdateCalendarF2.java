package tw.group4._03_.csr.calendar.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import tw.group4._03_.cms.calendar.model.ShopCalendarBean;
import tw.group4._03_.cms.calendar.model.ShopCalendarService;
import tw.group4.util.IdentityFilter;

@Controller
public class UpdateCalendarF2 {

	@Autowired
	private ShopCalendarService scs;

	@RequestMapping(path = "/03/csr/calendar/updateCalendarConfirm.ctrl", method = RequestMethod.POST)
	public String updateCalendarConfirm(HttpServletRequest request, Model m) {
		try {
			List<ShopCalendarBean> calendarList = new ArrayList<ShopCalendarBean>();

			String[] calendarNo = request.getParameterValues("calendarNo");

			for (String no : calendarNo) {
				int intNo = Integer.parseInt(no);
				ShopCalendarBean calendarBean = scs.selectByNo(intNo);
				calendarList.add(calendarBean);
			}
			m.addAttribute("calendarList", calendarList);

		} catch (Exception e) {
			e.printStackTrace();
			String calendarUpdateMsg = "系統錯誤，請回到上一頁重試";
			m.addAttribute("calendarUpdateMsg", calendarUpdateMsg); // 回傳錯誤訊息
		}
		return IdentityFilter.loginID+"03/csr_calendar/update_confirm";
	}

	@RequestMapping(path = "/03/csr/calendar/updateCalendar.ctrl", method = RequestMethod.POST)
	public String updateCalendar(@RequestParam(name = "shopId") String shopId,
			@RequestParam(name = "shopName") String shopName, @RequestParam(name = "memberId") String memberId,
			@RequestParam(name = "year") String year,

			@RequestParam(name = "month") String month, HttpServletRequest request, Model m) {

		String[] calendarNo = request.getParameterValues("calendarNo");
		String[] day = request.getParameterValues("day");
		String[] permission = request.getParameterValues("permission");
		String[] maximum = request.getParameterValues("maximum");
		String[] dateTime = request.getParameterValues("dateTime");

		String[] startTime = request.getParameterValues("startTime");
		String[] endTime = request.getParameterValues("endTime");
		String[] note = request.getParameterValues("note");

		try {
			for (int i = 0; i < calendarNo.length; i++) {

				scs.update(Integer.parseInt(calendarNo[i]), Integer.parseInt(shopId), shopName,
						Integer.parseInt(memberId), Integer.parseInt(year), Integer.parseInt(month),
						Integer.parseInt(day[i]), Integer.parseInt(permission[i]), Integer.parseInt(maximum[i]),
						dateTime[i], startTime[i], endTime[i], note[i]);
			}
			String calendarUpdateMsg = "已更新" + shopName + " " + year + "年" + month + "月的預約行事曆";
			m.addAttribute("calendarUpdateMsg", calendarUpdateMsg);

		} catch (Exception e) {
			e.printStackTrace();

			String calendarUpdateMsg = "預約行事曆更新失敗，請重試";
			m.addAttribute("calendarUpdateMsg", calendarUpdateMsg); // 回傳錯誤訊息
		}
		return IdentityFilter.loginID+"03/csr_calendar/update_return";
	}

}
