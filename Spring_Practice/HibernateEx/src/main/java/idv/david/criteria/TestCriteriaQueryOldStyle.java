package idv.david.criteria;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import entity.Emp;
import util.HibernateUtil;

public class TestCriteriaQueryOldStyle {
	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			
			session.beginTransaction();
			
			Criteria criteria = session.createCriteria(Emp.class);
			criteria.addOrder(Order.desc("empno"));
			criteria.add(Restrictions.like("ename", "%K%"));
			criteria.add(Restrictions.ge("sal", new BigDecimal(String.valueOf(2500.0))));
			
			List<Emp> list = criteria.list();
			System.out.println(list);
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtil.shutdown();
		}
	}
	
	
}
