package tw.group4._03_.cms.reservation.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository("shopReservationDAO")
public class ShopReservationDAO {

	// @Autowired @Qualifier("sessionFactory")
	private SessionFactory sessionFacory;

	@Autowired
	public ShopReservationDAO(@Qualifier("sessionFactory") SessionFactory sessionFacory) {
		this.sessionFacory = sessionFacory;
	}

	public boolean checkReservationNo(int reservationNo) {
		Session session = sessionFacory.getCurrentSession();
		ShopReservationBean result = session.get(ShopReservationBean.class, reservationNo);

		if (result != null) {
			return true;
		}
		return false;
	}
	
	public ShopReservationBean insert(ShopReservationBean bean) {
		Session session = sessionFacory.getCurrentSession();
		session.save(bean);
		return bean;
	}

	public ShopReservationBean select(int reservationNo) {
		Session session = sessionFacory.getCurrentSession();
		return session.get(ShopReservationBean.class, reservationNo);

	}
	
	public List<ShopReservationBean> selectByNo(int reservationNo) {
		Session session = sessionFacory.getCurrentSession();
		Query<ShopReservationBean> query = session.createQuery("From ShopReservationBean where reservationNo = " + reservationNo + " ",
				ShopReservationBean.class);
		List<ShopReservationBean> list = query.list();
		return list;
	}
	
	public List<ShopReservationBean> selectByMemberId(int memberId) {
		Session session = sessionFacory.getCurrentSession();
		Query<ShopReservationBean> query = session.createQuery("From ShopReservationBean where memberId = "+memberId+"",
				ShopReservationBean.class);
		List<ShopReservationBean> list = query.list();
		return list;
	}
	
	public List<ShopReservationBean> selectByMemberName(String memberName) {
		Session session = sessionFacory.getCurrentSession();
		Query<ShopReservationBean> query = session.createQuery("From ShopReservationBean where memberName '%"+ memberName + "%'",
				ShopReservationBean.class);
		List<ShopReservationBean> list = query.list();
		return list;
	}

	public List<ShopReservationBean> selectByShopId(int shopId) {
		Session session = sessionFacory.getCurrentSession();
		Query<ShopReservationBean> query = session.createQuery("From ShopReservationBean where shopId = "+shopId+"",
				ShopReservationBean.class);
		List<ShopReservationBean> list = query.list();
		return list;
	}
	
	public List<ShopReservationBean> selectByShopName(String shopName) {
		Session session = sessionFacory.getCurrentSession();
		Query<ShopReservationBean> query = session.createQuery("From ShopReservationBean where shopName like '%" + shopName + "%'",
				ShopReservationBean.class);
		List<ShopReservationBean> list = query.list();
		return list;
	}
	public List<ShopReservationBean> selectByDateTime(int shopId, String dateTime) {
		Session session = sessionFacory.getCurrentSession();
		Query<ShopReservationBean> query = session.createQuery("From ShopReservationBean where shopId = " + shopId + " and dateTime = " + dateTime + " ",
				ShopReservationBean.class);
		List<ShopReservationBean> list = query.list();
		return list;
	}
	
	public List<ShopReservationBean> selectAll() {
		Session session = sessionFacory.getCurrentSession();
		Query<ShopReservationBean> query = session.createQuery("From ShopReservationBean", ShopReservationBean.class);
		List<ShopReservationBean> list = query.list();
		return list;
	}

	public ShopReservationBean update(
			int reservationNo, 
			int memberId, 
			String memberName, 
			int shopId, 
			String shopName, 
			String customerName,
			String customerPhone,
			int adultsNum, 
			int childrenNum, 
			int amount, 
			String dateTime, 
			String startTime, 
			String endTime,
			String note) {

		Session session = sessionFacory.getCurrentSession();
		ShopReservationBean result = session.get(ShopReservationBean.class, reservationNo);
		if (result != null) {
			result.setMemberId(memberId);
			result.setMemberName(memberName);
			result.setShopId(shopId);
			result.setShopName(shopName);

			result.setCustomerName(customerName);
			result.setCustomerPhone(customerPhone);
			result.setAdultsNum(adultsNum);
			result.setChildrenNum(childrenNum);
			result.setAmount(amount);
			
			result.setDateTime(dateTime);
			result.setStartTime(startTime);
			result.setEndTime(endTime);
			result.setNote(note);
		}
		return result;
	}

	public boolean delete(int reservationNo) {
		Session session = sessionFacory.getCurrentSession();
		ShopReservationBean result = session.get(ShopReservationBean.class, reservationNo);

		if (result != null) {
			session.delete(result);
			return true;
		}
		return false;
	}

}
