package idv.david.crud;

import org.hibernate.Session;

import entity.Dept;
import util.HibernateUtil;

public class TestSave {
	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			
			Dept dept = new Dept();
			dept.setDeptno(50);
			dept.setDname("業務部");
			dept.setLoc("台中");
			
			session.save(dept);
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.shutdown();
		}
		
		
	}
}
