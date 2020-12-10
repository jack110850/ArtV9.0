package tw.group4._03_.csr.calendar.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tw.group4._03_.cms.calendar.model.ShopCalendarService;
import tw.group4.util.IdentityFilter;

@Controller
public class DeleteCalendarF2 {

	@Autowired
	private ShopCalendarService scs;

	@RequestMapping(path = "/03/csr/calendar/deleteCalendar.ctrl", method = RequestMethod.POST)
	public String deleteShop(HttpServletRequest request, Model m) {

		try {
			String[] calendarNo = request.getParameterValues("calendarNo");
			
			for(String no : calendarNo) {
				int intNo = Integer.parseInt(no);
				scs.delete(intNo);
			}

			String calendarDeleteMsg = "當月行事曆已刪除成功";
			m.addAttribute("calendarDeleteMsg", calendarDeleteMsg);

		} catch (Exception e) {
			e.printStackTrace();
			String calendarDeleteMsg = "行事曆刪除失敗";
			m.addAttribute("calendarDeleteMsg", calendarDeleteMsg); // 回傳錯誤訊息
		}
		return IdentityFilter.loginID+"03/csr_calendar/delete_return";
	}

}
