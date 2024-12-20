package idv.david.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import entity.Emp;
import util.HibernateUtil;

public class TestHQLQueryEntity {
	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			
			// 多筆資料查詢可用 hibernate 的 list() 或 JPA 的 getResultList()
			List<Emp> list1 = session.createQuery("from Emp", Emp.class).list();
			
			List<Emp> list2 = session.createQuery("from Emp").list();
			
			List<Emp> list3 = session.createQuery("from Emp order by empno", Emp.class).list();
			
			List<Emp> list4 = session.createQuery("from Emp order by empno desc", Emp.class).list();
			
			List<Emp> list5 = session.createQuery("from Emp as e order by e.empno", Emp.class).list();
			
			List<Emp> list6 = session.createQuery("from entity.Emp", Emp.class).list();
			
			// '%K%' 單引號一定要加，否則會得到語法錯誤的例外
			List<Emp> list7 = session.createQuery("from Emp where ename like '%K%'", Emp.class).list();
			System.out.println(list7);
			
			// 單筆資料查詢可用 hibernate 的 uniqueResult() 或是 JPA 的 getSingleResult()
			Emp emp = session.createQuery("from Emp where empno = 7001", Emp.class).uniqueResult();
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtil.shutdown();
		}
	}
}
