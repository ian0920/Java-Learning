package idv.david.crud;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import entity.Dept;
import util.HibernateUtil;

public class TestGetAndLoad {
	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			
			Dept dept1 = session.get(Dept.class, 10);
			System.out.println(dept1);
			
			Dept dept2 = session.load(Dept.class, 20);
			System.out.println(dept2);
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtil.shutdown();
		}
		
	}
}
