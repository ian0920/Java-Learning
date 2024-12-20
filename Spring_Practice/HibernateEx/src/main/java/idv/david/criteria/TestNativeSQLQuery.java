package idv.david.criteria;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import entity.Emp;
import util.HibernateUtil;

public class TestNativeSQLQuery {
	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			
			session.beginTransaction();
			
			NativeQuery<Emp> query = session.createNativeQuery("SELECT * FROM employee", Emp.class);
			List<Emp> list = query.list();
			System.out.println(list);
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtil.shutdown();
		}
	}
}
