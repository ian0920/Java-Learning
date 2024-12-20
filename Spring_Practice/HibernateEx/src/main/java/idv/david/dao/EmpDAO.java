package idv.david.dao;

import java.util.List;

import entity.Emp;


public interface EmpDAO {
	// 此介面定義對資料庫的相關存取抽象方法
	int add(Emp emp);
	int update(Emp emp);
	int delete(Integer empno);
	Emp findByPK(Integer empno);
	List<Emp> getAll();
}