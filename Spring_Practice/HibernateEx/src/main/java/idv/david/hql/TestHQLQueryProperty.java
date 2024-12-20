package idv.david.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import entity.Emp;
import util.HibernateUtil;

public class TestHQLQueryProperty {
	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			
			session.beginTransaction();
			
			// 查詢單一欄位可以自行指定結果的資料型別，就無需再從Object做轉型
			Query<String> query1 = session.createQuery("select ename from Emp where empno = 7001", String.class);
			String ename = query1.uniqueResult();
			System.out.println(ename);
			
			// 查詢多筆欄位得到Object[]資料型別，需要再自行做轉型處理
//			Query<Object[]> query2 = session.createQuery("select empno, ename from Emp", Object[].class);
//			List<Object[]> list1 = query2.list();
//			for (Object[] objs : list1) {
//				System.out.println((Integer) objs[0] + " = " + (String) objs[1]);
//			}
			
			// 利用 Projection (投影) 簡化
//			Query<Emp> query3 = session.createQuery("select new Emp(empno, ename) from Emp", Emp.class);
//			List<Emp> list2 = query3.list();
//			System.out.println(list2);
			
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtil.shutdown();
		}
	}
}
