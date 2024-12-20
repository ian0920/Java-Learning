package idv.david.crud;

import org.hibernate.Session;

import entity.Dept;
import util.HibernateUtil;

public class TestDelete {
	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			
			Dept dept = session.get(Dept.class, 50);
			if (dept != null)
				session.delete(dept);
			
			// 也可以
//			Dept dept2 = new Dept();
//			dept2.setDeptno(50);
//			session.delete(dept2);
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtil.shutdown();
		}
	}
}
