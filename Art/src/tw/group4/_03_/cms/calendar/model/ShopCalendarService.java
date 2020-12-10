package tw.group4._03_.cms.calendar.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("shopCalendarService")
public class ShopCalendarService implements IShopCalendarBean {

	@Autowired
	private ShopCalendarDAO shopCalendarDAO;

	@Override
	public ShopCalendarBean insert(ShopCalendarBean bean) {
		return shopCalendarDAO.insert(bean);
	}

	@Override
	public ShopCalendarBean selectByNo(int calendarNo) {
		return shopCalendarDAO.selectByNo(calendarNo);
	}
	
	@Override
	public List<ShopCalendarBean> selectByShopName(String shopName) {
		return shopCalendarDAO.selectByShopName(shopName);
	}

	@Override
	public List<ShopCalendarBean> selectByDateTime(int shopId, String dateTime) {
		return shopCalendarDAO.selectByDateTime(shopId, dateTime);
	}

	@Override
	public List<ShopCalendarBean> selectByYearMonth(int shopId, int year, int month){
		return shopCalendarDAO.selectByYearMonth(shopId, year, month);
	}
	
	@Override
	public List<ShopCalendarBean> selectByYearMonthDay(int shopId, int year, int month, int day) {
		return shopCalendarDAO.selectByYearMonthDay(shopId, year, month, day);
	}
	
	//5 #======================================

	@Override
	public List<ShopCalendarBean> selectByMemberId(int memberId){
		return shopCalendarDAO.selectByMemberId(memberId);
	}
	
	@Override
	public ShopCalendarBean update( 
			int calendarNo, int shopId, String shopName, int memberId, int year,
			int month, int day, int permission, int maximum, String dateTime,
			String startTime, String endTime, String note) {
		return shopCalendarDAO.update( 
				calendarNo, shopId, shopName, memberId, year, 
				month, day, permission, maximum, dateTime, 
				startTime, endTime, note);
	}

	@Override
	public boolean delete(int calendarNo) {
		return shopCalendarDAO.delete(calendarNo);
	}

}
