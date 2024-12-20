package idv.david.dao;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;

import entity.Emp;

public class TestJDBCDAO {

	public static void main(String[] args) throws Exception {
		EmpDAO dao = new EmpDAOJDBCImpl();

		// 新增
		Emp emp1 = new Emp();
		emp1.setEmpno(7016);
		emp1.setEname("David");
		emp1.setJob("MANAGER");
		emp1.setHiredate(new SimpleDateFormat("yyyy-MM-dd").parse("2016-08-07"));
		emp1.setSal(new BigDecimal(50000));
		emp1.setComm(new BigDecimal(500));
		emp1.setEmpdeptno(10);
		dao.add(emp1);

//		// 修改
//		Emp emp2 = new Emp();
//		emp2.setEmpno(7087);
//		emp2.setEname("David Jr.");
//		emp2.setJob("MANAGER2");
//		emp2.setHiredate(new SimpleDateFormat("yyyy-MM-dd").parse("2016-08-07"));
//		emp2.setSal(new BigDecimal(20000));
//		emp2.setComm(new BigDecimal(200));
//		emp2.setEmpdeptno(20);
//		dao.update(emp2);
//
//		// 刪除
//		dao.delete(7087);
//
//		// 查詢單筆
//		Emp emp3 = dao.findByPK(7001);
//		System.out.print(emp3.getEmpno() + ",");
//		System.out.print(emp3.getEname() + ",");
//		System.out.print(emp3.getJob() + ",");
//		System.out.print(emp3.getHiredate() + ",");
//		System.out.print(emp3.getSal() + ",");
//		System.out.print(emp3.getComm() + ",");
//		System.out.println(emp3.getEmpdeptno());
//		System.out.println("---------------------");
//
//		// 查詢多筆
//		List<Emp> list = dao.getAll();
//		for (Emp emp : list) {
//			System.out.print(emp.getEmpno() + ",");
//			System.out.print(emp.getEname() + ",");
//			System.out.print(emp.getJob() + ",");
//			System.out.print(emp.getHiredate() + ",");
//			System.out.print(emp.getSal() + ",");
//			System.out.print(emp.getComm() + ",");
//			System.out.print(emp.getEmpdeptno());
//			System.out.println();
//		}
	}

}
