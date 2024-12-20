package idv.david.session;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Dept;
import util.HibernateUtil;

public class TestTransaction {
	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx1 = null, tx2 = null;
		try {
			
			tx1 = session.beginTransaction();
			
			Dept dept1 = session.get(Dept.class, 10);
			System.out.println(dept1);
			
			// Exception happened
			tx2 = session.beginTransaction();
			
			tx1.commit();
			
			Dept dept2 = session.get(Dept.class, 10);
			System.out.println(dept2);
			
			tx2.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			if (tx1 != null)
				tx1.rollback();
		} finally {
			HibernateUtil.shutdown();
		}
	}
}
