package tw.group4._03_.cms.reservation.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("shopReservationService")
public class ShopReservationService implements IShopReservationBean {

	@Autowired
	private ShopReservationDAO shopReservationDAO;

	@Override
	public boolean checkReservationNo(int reservationNo) {
		return shopReservationDAO.checkReservationNo(reservationNo);
	}

	@Override
	public ShopReservationBean insert(ShopReservationBean bean) {
		return shopReservationDAO.insert(bean);
	}

	@Override
	public ShopReservationBean select(int reservationNo) {
		return shopReservationDAO.select(reservationNo);
	}

	@Override
	public List<ShopReservationBean> selectByNo(int reservationNo) {
		return shopReservationDAO.selectByNo(reservationNo);
	}

	@Override
	public List<ShopReservationBean> selectByMemberId(int memberId) {
		return shopReservationDAO.selectByMemberId(memberId);
	}

	// =====================
	
	@Override
	public List<ShopReservationBean> selectByMemberName(String memberName) {
		return shopReservationDAO.selectByMemberName(memberName);
	}

	@Override
	public List<ShopReservationBean> selectByShopId(int shopId) {
		return shopReservationDAO.selectByShopId(shopId);
	}

	@Override
	public List<ShopReservationBean> selectByShopName(String shopName) {
		return shopReservationDAO.selectByShopName(shopName);
	}
	
	@Override
	public List<ShopReservationBean> selectByDateTime(int shopId, String dateTime){
		return shopReservationDAO.selectByDateTime(shopId, dateTime);
	}
	
	@Override
	public List<ShopReservationBean> selectAll() {
		return shopReservationDAO.selectAll();
	}

	// =====================

	@Override
	public ShopReservationBean update( 
			int reservationNo, int memberId, String memberName, int shopId, String shopName,
			String customerName, String customerPhone, int adultsNum, int childrenNum, int amount, 
			String dateTime, String startTime, String endTime, String note) {
		return shopReservationDAO.update( 
				reservationNo, memberId, memberName, shopId, shopName, 
				customerName, customerPhone, adultsNum, childrenNum, amount, 
				dateTime, startTime, endTime, note);
	}

	
	@Override
	public boolean delete(int reservationNo) {
		return shopReservationDAO.delete(reservationNo);
	}

}
