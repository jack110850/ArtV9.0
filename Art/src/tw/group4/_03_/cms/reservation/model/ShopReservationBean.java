package tw.group4._03_.cms.reservation.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "CS_RESERVATION_TABLE")
@Component("shopReservationBean")
public class ShopReservationBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "RESERVATIONNO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reservationNo;

	@Column(name = "MEMBERID")
	private int memberId;

	@Column(name = "MEMBERNAME")
	private String memberName;

	@Column(name = "SHOPID")
	private int shopId;

	@Column(name = "SHOPNAME")
	private String shopName;

	// 5 =====================

	@Column(name = "CUSTOMERNAME")
	private String customerName;

	@Column(name = "CUSTOMERPHONE")
	private String customerPhone;

	@Column(name = "ADULTSNUM")
	private int adultsNum;

	@Column(name = "CHILDRENNUM")
	private int childrenNum;

	@Column(name = "AMOUNT")
	private int amount;

	// 10 ==================

	@Column(name = "DATETIME")
	private String dateTime;
	
	@Column(name = "STARTTIME")
	private String startTime;

	@Column(name = "ENDTIME")
	private String endTime;
	
	@Column(name = "NOTE")
	private String note;

	// 14 ==================

	public int getReservationNo() {
		return reservationNo;
	}

	public void setReservationNo(int reservationNo) {
		this.reservationNo = reservationNo;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public int getAdultsNum() {
		return adultsNum;
	}

	public void setAdultsNum(int adultsNum) {
		this.adultsNum = adultsNum;
	}

	public int getChildrenNum() {
		return childrenNum;
	}

	public void setChildrenNum(int childrenNum) {
		this.childrenNum = childrenNum;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	// ==================

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "SHOPID")
//	private ReservationPolicyBean reservationPolicyBean;
//	
	// ==================

//	public ShopReservationBean(int reservationNo, String memberId, String name, int shopId, String shopName,
//			String customerName, String customerPhone, int adultsNum, int childrenNum, int amount, String startTime, String endTime, ReservationPolicyBean reservationPolicyBean) {
//
//		this.reservationNo = reservationNo;
//		this.memberId = memberId;
//		this.name = name;
//		this.shopId = shopId;
//		this.shopName = shopName;
//
//		this.customerName = customerName;
//		this.customerPhone = customerPhone;
//		this.adultsNum = adultsNum;
//		this.childrenNum = childrenNum;
//		this.amount = amount;
//		
//		this.startTime = startTime;
//		this.endTime = endTime;
//		this.reservationPolicyBean = reservationPolicyBean;
//	}

	// ==================
}
