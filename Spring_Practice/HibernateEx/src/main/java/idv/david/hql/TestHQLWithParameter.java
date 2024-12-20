package idv.david.hql;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.query.Query;

import entity.Emp;
import util.HibernateUtil;

public class TestHQLWithParameter {
	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			
			List<Emp> list = session.createQuery("from Emp where empno > ?0 and ename like :ename", Emp.class)
					.setParameter(0, 7001)
					.setParameter("ename", "%K%")
					.list();
			
			System.out.println(list);
			
//			Query<Emp> query1 = session.createQuery("from Emp where empno > :empno and ename like :ename", Emp.class);
//			
//			Emp emp = new Emp();
//			emp.setEmpno(7001);
//			emp.setEname("%K%");
//			query1.setProperties(emp);
//			
//			List<Emp> list2 = query1.list();
//			System.out.println(list2);
//			
//			Query<Emp> query2 = session.createQuery("from Emp", Emp.class);
//			query2.setFirstResult(0);
//			query2.setMaxResults(3);
//			List<Emp> list3 = query2.list();
//			System.out.println(list3);
//			
//			List<Emp> list4 = session.getNamedQuery("getAllEmps")
//					.setParameter("empno", 7010)
//					.list();
//			System.out.println(list4);
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtil.shutdown();
		}
	}
}
