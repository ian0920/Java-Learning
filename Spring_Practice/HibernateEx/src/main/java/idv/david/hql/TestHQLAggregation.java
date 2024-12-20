package idv.david.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import util.HibernateUtil;

public class TestHQLAggregation {
	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			
			session.beginTransaction();
			
			Long count = session.createQuery("select count(*) from Emp", Long.class).uniqueResult();
			System.out.println(count);
			
			Double salAvg = session.createQuery("select avg(sal) from Emp", Double.class).uniqueResult();
			System.out.println(salAvg);
			
			List<Integer> list1 = session.createQuery("select distinct empdeptno from Emp order by empdeptno", Integer.class).list();
			System.out.println(list1);
			
			Query<Object[]> query = session.createQuery("select d.deptno, d.dname, count(*) from Emp e, Dept d "
					+ "where e.empdeptno = d.deptno group by d.deptno, d.dname order by d.deptno", Object[].class);
			
			List<Object[]> list2 = query.list();
			for (Object[] objs : list2) {
				System.out.println("部門編號 = " + objs[0]);
				System.out.println("部門名稱 = " + objs[1]);
				System.out.println("員工人數 = " + objs[2]);
				System.out.println();
			}
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtil.shutdown();
		}
	}
}
