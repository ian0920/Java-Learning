package idv.david.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Dept;
import util.HibernateUtil;

public class TestUpdate {
	
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		try {
			Session session1 = factory.openSession();
			Dept dept = session1.get(Dept.class, 50);
			session1.close();
			
			// session 已關閉，所以 dept 已脫離管理，此時的 set 動作不會反應到資料庫
			dept.setLoc("XXX");
			
			Session session2 = factory.openSession();
			Transaction tx = session2.beginTransaction();
			// 藉由 update 方法讓 dept 物件重回到 session 管理
			session2.update(dept);
			
			tx.commit();
			session2.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.shutdown();
		}
	}
}
