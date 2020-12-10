package tw.group4._18_.buyer.model;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "COURSEORDERS")
public class CourseOrders {
	
	@Id @Column(name = "COORDERNOCO") 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int coOrderNoCo;
	
	@Column(name = "USERID")
	private String userId;
	
	@Column(name = "CUSTOMERADDRESS")
	private String customerAddress;
	
	@Column(name = "COCOMMENT")
	private String coComment;
	
	@Column(name = "TOTALAMOUNT")
	private int totalAmount;
	
	@Column(name = "ORDERDATE")
	private Date date;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "courseOrders",cascade = CascadeType.ALL)
	//	CascadeType.ALL:無論儲存、合併、 更新或移除，一併對被參考物件作出對應動作。
	private Set<CourseOrderItems> courseOrderItems = new LinkedHashSet<>();
	

	
	
	public CourseOrders(){
		
	}

	public CourseOrders(String userId, String customerAddress, String coComment, int totalAmount,
			Date date) {
		super();
		this.userId = userId;
		this.customerAddress = customerAddress;
		this.coComment = coComment;
		this.totalAmount = totalAmount;
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "CourseOrders [coOrderNoCo=" + coOrderNoCo + ", userId=" + userId + ", customerAddress=" + customerAddress
				+ ",coComment=" + coComment + ",totalAmount=" + totalAmount + ", date=" + date + ", courseOrderItems=" + courseOrderItems + "]";
	}
	
	
	public CourseOrders(Integer coOrderNoCo, String userId, String customerAddress, String coComment, int totalAmount,
			Date date,Set<CourseOrderItems> courseOrderItems) {
		super();
		this.coOrderNoCo = coOrderNoCo;
		this.userId = userId;
		this.customerAddress = customerAddress;
		this.coComment = coComment;
		this.totalAmount = totalAmount;
		this.date = date;
		this.courseOrderItems = courseOrderItems;
	}
	
	
	
	

	public int getCoOrderNoCo() {
		return coOrderNoCo;
	}

	public void setCoOrderNoCo(int coOrderNoCo) {
		this.coOrderNoCo = coOrderNoCo;
	}
	
	
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	
	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	
	public String getCoComment() {
		return coComment;
	}

	public void setCoComment(String coComment) {
		this.coComment = coComment;
	}
	

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Set<CourseOrderItems> getCourseOrderItems() {
		return courseOrderItems;
	}

	public void setCourseOrderItems(Set<CourseOrderItems> courseOrderItems) {
		this.courseOrderItems = courseOrderItems;
	}


	
	
	
	
	

}
