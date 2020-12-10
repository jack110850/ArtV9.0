package tw.group4._03_.cms.calendar.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "CS_CALENDAR_TABLE")
@Component("shopCalendarBean")
public class ShopCalendarBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CALENDARNO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int calendarNo;

	@Column(name = "SHOPID")
	private int shopId;

	@Column(name = "SHOPNAME")
	private String shopName;

	@Column(name = "MEMBERID")
	private int memberId;

	@Column(name = "YEAR")
	private int year;

	// =====================

	@Column(name = "MONTH")
	private int month;

	@Column(name = "DAY")
	private int day;

	@Column(name = "PERMISSION")
	private int permission;

	@Column(name = "MAXIMUM")
	private int maximum;

	@Column(name = "DATETIME")
	private String dateTime;

	// ==================

	@Column(name = "STARTTIME")
	private String startTime;

	@Column(name = "ENDTIME")
	private String endTime;
	
	@Column(name = "NOTE")
	private String note;

	// ==================

	public int getCalendarNo() {
		return calendarNo;
	}

	public void setCalendarNo(int calendarNo) {
		this.calendarNo = calendarNo;
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

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getPermission() {
		return permission;
	}

	public void setPermission(int permission) {
		this.permission = permission;
	}

	public int getMaximum() {
		return maximum;
	}

	public void setMaximum(int maximum) {
		this.maximum = maximum;
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
