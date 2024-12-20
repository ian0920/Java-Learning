package idv.david.session;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Dept;
import util.HibernateUtil;

public class TestGetCurrentSession {
	
	public static void main(String[] args) {
		// 系統組態檔裡一定要有 <property name="hibernate.current_session_context_class">thread</property> 的設定才可以
		Session s1 = HibernateUtil.getSessionFactory().getCurrentSession();
		Session s2 = HibernateUtil.getSessionFactory().getCurrentSession();
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
			HibernateUtil.shutdown();
		}

	}
}
