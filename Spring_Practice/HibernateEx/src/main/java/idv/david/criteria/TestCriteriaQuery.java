package idv.david.criteria;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import entity.Emp;
import util.HibernateUtil;

public class TestCriteriaQuery {
	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			
			session.beginTransaction();
			
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Emp> criteria = builder.createQuery(Emp.class);
			Root<Emp> root = criteria.from(Emp.class);
			
			Predicate p1 = builder.like(root.get("ename"), "%K%");
			Predicate p2 = builder.greaterThanOrEqualTo(root.get("sal"), new BigDecimal(String.valueOf(2500.0)));
			Order o1 = builder.desc(root.get("empno"));
			
			criteria.where(p1, p2);
			criteria.orderBy(o1);
			
			TypedQuery<Emp> query = session.createQuery(criteria);
			List<Emp> list = query.getResultList();
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
