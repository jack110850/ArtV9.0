package tw.group4._03_.cms.calendar.model;

import java.util.List;

public interface IShopCalendarBean {

	public ShopCalendarBean insert(ShopCalendarBean bean);

	public ShopCalendarBean selectByNo(int calendarNo);
	
	public List<ShopCalendarBean> selectByShopName(String shopName);

	public List<ShopCalendarBean> selectByDateTime(int shopId, String dateTime);
	
	public List<ShopCalendarBean> selectByYearMonth(int shopId, int year, int month);
	
	//5 #======================================
	
	public List<ShopCalendarBean> selectByYearMonthDay(int shopId, int year, int month, int day);
	
	public List<ShopCalendarBean> selectByMemberId(int memberId);

	public ShopCalendarBean update( 
			int calendarNo, int shopId, String shopName, int memberId, int year,
			int month, int day, int permission, int maximum, String dateTime,
			String startTime, String endTime, String note);
	
	public boolean delete(int calendarNo);

}
