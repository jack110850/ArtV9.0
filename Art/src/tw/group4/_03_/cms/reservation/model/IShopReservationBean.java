package tw.group4._03_.cms.reservation.model;

import java.util.List;

public interface IShopReservationBean {

	public boolean checkReservationNo(int reservationNo);

	public ShopReservationBean insert(ShopReservationBean bean);

	public ShopReservationBean select(int reservationNo);

	public List<ShopReservationBean> selectByNo(int reservationNo);

	public List<ShopReservationBean> selectByMemberId(int memberId);

	//5 #======================================
	
	public List<ShopReservationBean> selectByMemberName(String memberName);

	public List<ShopReservationBean> selectByShopId(int shopId);

	public List<ShopReservationBean> selectByShopName(String shopName);

	public List<ShopReservationBean> selectByDateTime(int shopId, String dateTime);
	
	public List<ShopReservationBean> selectAll();

	//10 #======================================

	public ShopReservationBean update( 
			int reservationNo, int memberId, String memberName, int shopId, String shopName,
			String customerName, String customerPhone, int adultsNum, int childrenNum, int amount, 
			String dateTime, String startTime, String endTime, String note);

	public boolean delete(int reservationNo);

}
