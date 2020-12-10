package tw.group4._03_.front.calender;

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
import tw.group4._03_.cms.util.GetDate;
import tw.group4.util.IdentityFilter;

@Controller
public class CreateCalendarFront {

	@Autowired
	private ShopCalendarService scs;

	@RequestMapping(path = "/03/front/calendar/createCalendarConfirm.ctrl", method = RequestMethod.POST)
	public String createCalendarConfirm( 
			@RequestParam(name = "shopId") String shopId,
			@RequestParam(name = "shopName") String shopName, 
			@RequestParam(name = "memberId") String memberId,
			@RequestParam(name = "year") String year, 
			@RequestParam(name = "month") String month, Model m) {
		try {
			int intYear = Integer.parseInt(year);
			int intMonth = Integer.parseInt(month);

			// # 獲得當月的日期 #
			GetDate getDate = new GetDate();
			List<Integer> dayList = new ArrayList<Integer>();
			for (int i = 1; i <= getDate.getDaysByYearMonth(intYear, intMonth); i++) {
				dayList.add(i);
			}

			m.addAttribute("dayList", dayList);
			m.addAttribute("shopId", shopId);
			m.addAttribute("shopName", shopName);
			m.addAttribute("memberId", memberId);
			m.addAttribute("year", year);
			m.addAttribute("month", month);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return IdentityFilter.loginID+"03/front_calendar/create_confirm";
	}

	@RequestMapping(path = "/03/front/calendar/createCalendar.ctrl", method = RequestMethod.POST)
	public String createCalendar( 
			@RequestParam(name = "shopId") String shopId,
			@RequestParam(name = "shopName") String shopName, 
			@RequestParam(name = "memberId") String memberId,
			@RequestParam(name = "year") String year,

			@RequestParam(name = "month") String month,
			HttpServletRequest request,
			Model m) {
		// 處理傳過來的陣列資料
		String[] day = request.getParameterValues("day");
		String[] permission = request.getParameterValues("permission");
		String[] maximum = request.getParameterValues("maximum");
		String[] dateTime = request.getParameterValues("dateTime");
		String[] startTime = request.getParameterValues("startTime");
		
		String[] endTime = request.getParameterValues("endTime");
		String[] note = request.getParameterValues("note");
		
		int intYear =  Integer.parseInt(year);
		int intMonth =  Integer.parseInt(month);
		// # 獲得該月的日期天數 #
		GetDate getDate = new GetDate();

		try {
			for(int i = 0; i < getDate.getDaysByYearMonth(intYear, intMonth); i++){
				
			ShopCalendarBean calendar = new ShopCalendarBean();

			calendar.setShopId(Integer.parseInt(shopId));
			calendar.setShopName(shopName);
			calendar.setMemberId(Integer.parseInt(memberId));
			calendar.setYear(Integer.parseInt(year));

			calendar.setMonth(Integer.parseInt(month));
			calendar.setDay(Integer.parseInt(day[i]));
			calendar.setPermission(Integer.parseInt(permission[i]));
			calendar.setMaximum(Integer.parseInt(maximum[i]));
			calendar.setDateTime(dateTime[i]);

			calendar.setStartTime(startTime[i]);
			calendar.setEndTime(endTime[i]);
			calendar.setNote(note[i]);
			
			scs.insert(calendar);
		}
			
			String calendarCreateMsg = "預約行事曆新增成功";
			m.addAttribute("calendarCreateMsg", calendarCreateMsg);

		} catch (Exception e) {
			e.printStackTrace();

			String calendarCreateMsg = "預約行事曆新增失敗，請重新輸入";
			m.addAttribute("calendarCreateMsg", calendarCreateMsg); // 回傳錯誤訊息
		}
		return IdentityFilter.loginID+"03/front_calendar/create_return";
	}

}
