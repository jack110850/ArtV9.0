package tw.group4._18_.buyer.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import tw.group4._18_.buyer.model.CourseOrders;
import tw.group4._18_.seller.model.Course;

@Repository("OrderDAO")
public class CourseOrderDAO {
	private SessionFactory sessionFactory;

	@Autowired
	public CourseOrderDAO(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public CourseOrders insertOrder(CourseOrders co) {
		Session session = sessionFactory.getCurrentSession();
		
		session.save(co);
		return co;
	}

	public CourseOrders selectcoOrder(int coOrderNoCo) {
		Session session = sessionFactory.getCurrentSession();
		CourseOrders co = session.get(CourseOrders.class, coOrderNoCo);
		return co;
	}
	
	public List<Course> customerSelectAll() {
		Session session = sessionFactory.getCurrentSession();
		Query<Course> query = session.createQuery("From Course", Course.class);
		List<Course> list = query.list();
		return list;
	}
	
	public List<CourseOrders> getcoOrderById(String userId) {
		System.out.println("userId:" +userId);
		Session session = sessionFactory.getCurrentSession();
		Query<CourseOrders> query = session.createQuery("From CourseOrders WHERE co.userId = " + userId + " ", CourseOrders.class);

		List<CourseOrders> list = query.list();
		return list;
	}
	
	public CourseOrders deleteOrder(CourseOrders co) {
		Session session = sessionFactory.getCurrentSession();
		
		session.delete(co);
		return co;
	}



}
