package idv.david.crud;

import org.hibernate.Session;

import entity.Dept;
import util.HibernateUtil;

public class TestMerge {
	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			// session裡已有一筆編號50的dept物件
			Dept dept1 = session.get(Dept.class, 50);
			Dept dept2 = new Dept();
			dept2.setDeptno(50);
			dept2.setDname("業務部");
			dept2.setLoc("XXX");
			Dept dept3 = (Dept) session.merge(dept2);
			
			System.out.println(dept1 == dept2);
			System.out.println(dept1 == dept3);
			
			// session裡沒有編號50的dept物件
//			Dept dept1 = new Dept();
//			dept1.setDeptno(50);
//			dept1.setDname("業務部");
//			dept1.setLoc("OOO");
//			Dept dept2 = (Dept) session.merge(dept1);
//			System.out.println(dept1 == dept2);
			
			// session裡沒有編號60的dept物件，資料庫裡也沒有編號60的資料
//			Dept dept1 = new Dept();
//			dept1.setDeptno(60);
//			dept1.setDname("總務部");
//			dept1.setLoc("台南");
//			
//			Dept dept2 = (Dept) session.merge(dept1);
//			
//			System.out.println(dept1 == dept2);
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtil.shutdown();
		}
	}
}
