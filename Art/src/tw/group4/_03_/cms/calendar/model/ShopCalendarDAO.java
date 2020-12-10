package tw.group4._03_.cms.calendar.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository("shopCalendarDAO")
public class ShopCalendarDAO {

	// @Autowired @Qualifier("sessionFactory")
	private SessionFactory sessionFacory;

	@Autowired
	public ShopCalendarDAO(@Qualifier("sessionFactory") SessionFactory sessionFacory) {
		this.sessionFacory = sessionFacory;
	}

	public ShopCalendarBean insert(ShopCalendarBean bean) {
		Session session = sessionFacory.getCurrentSession();
		session.save(bean);
		return bean;
	}

	public ShopCalendarBean selectByNo(int calendarNo) {
		Session session = sessionFacory.getCurrentSession();
		return session.get(ShopCalendarBean.class, calendarNo);
	}

	public List<ShopCalendarBean> selectByShopName(String shopName) {
		Session session = sessionFacory.getCurrentSession();
		Query<ShopCalendarBean> query = session.createQuery("From ShopCalendarBean where shopName '%" + shopName + "%'",
				ShopCalendarBean.class);
		List<ShopCalendarBean> list = query.list();
		return list;
	}

	public List<ShopCalendarBean> selectByDateTime(int shopId, String dateTime) {
		Session session = sessionFacory.getCurrentSession();
		Query<ShopCalendarBean> query = session.createQuery(
				"From ShopCalendarBean where shopId = " + shopId + " and dateTime = '" + dateTime + "' ",
				ShopCalendarBean.class);
		List<ShopCalendarBean> list = query.list();
		return list;
	}

	public List<ShopCalendarBean> selectByYearMonth(int shopId, int year, int month) {
		Session session = sessionFacory.getCurrentSession();
		Query<ShopCalendarBean> query = session.createQuery("From ShopCalendarBean where shopId ="+shopId+" and year ="+year+"  and month ="+month+"", ShopCalendarBean.class);
		List<ShopCalendarBean> list = query.list();
		return list;
	}

	public List<ShopCalendarBean> selectByYearMonthDay(int shopId, int year, int month, int day) {
		Session session = sessionFacory.getCurrentSession();
		Query<ShopCalendarBean> query = session.createQuery("From ShopCalendarBean where shopId = " + shopId
				+ " and year = " + year + "  and month = " + month + " and day = " + day + " ", ShopCalendarBean.class);
		List<ShopCalendarBean> list = query.list();
		return list;
	}

	public List<ShopCalendarBean> selectByMemberId(int memberId) {
		Session session = sessionFacory.getCurrentSession();
		Query<ShopCalendarBean> query = session.createQuery("From ShopCalendarBean where memberId = " + memberId + " ",
				ShopCalendarBean.class);
		List<ShopCalendarBean> list = query.list();
		return list;
	}

	public ShopCalendarBean update(int calendarNo, int shopId, String shopName, int memberId, int year, int month,
			int day, int permission, int maximum, String dateTime, String startTime, String endTime, String note) {

		Session session = sessionFacory.getCurrentSession();
		ShopCalendarBean result = session.get(ShopCalendarBean.class, calendarNo);
		if (result != null) {
			result.setShopId(shopId);
			result.setShopName(shopName);
			result.setMemberId(memberId);
			result.setYear(year);

			result.setMonth(month);
			result.setDay(day);
			result.setPermission(permission);
			result.setMaximum(maximum);
			result.setDateTime(dateTime);

			result.setStartTime(startTime);
			result.setEndTime(endTime);
			result.setNote(note);
		}
		return result;
	}

	public boolean delete(int calendarNo) {
		Session session = sessionFacory.getCurrentSession();
		ShopCalendarBean result = session.get(ShopCalendarBean.class, calendarNo);

		if (result != null) {
			session.delete(result);
			return true;
		}
		return false;
	}

}
