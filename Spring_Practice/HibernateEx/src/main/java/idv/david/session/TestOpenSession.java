package idv.david.session;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Dept;
import util.HibernateUtil;

public class TestOpenSession {

	public static void main(String[] args) {
		Session s1 = HibernateUtil.getSessionFactory().openSession();
		Session s2 = HibernateUtil.getSessionFactory().openSession();
		Transaction tx1 = null, tx2 = null;
		try {
			System.out.println(s1 == s2);

			tx1 = s1.beginTransaction();

			Dept dept1 = s1.get(Dept.class, 10);
			System.out.println(dept1);

			tx1.commit();
			
			tx2 = s2.beginTransaction();
			
			Dept dept2 = s1.get(Dept.class, 10);
			System.out.println(dept2);
			
			tx2.commit();

		} catch (Exception e) {
			e.printStackTrace();
			if (tx1 != null)
				tx1.rollback();
			if (tx2 != null)
				tx2.rollback();
		} finally {
			s1.close();
			s2.close();
			HibernateUtil.shutdown();
		}

	}
}
