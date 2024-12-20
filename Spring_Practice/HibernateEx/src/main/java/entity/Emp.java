package entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "employee")
// 配合 TestHQLWithParameter.java
@NamedQuery(name = "getAllEmps", query = "from Emp where empno > :empno order by empno desc")
public class Emp {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "empno", updatable = false)
	private Integer empno;
	
	@Column(name = "ename")
	private String ename;
	
	@Column(name = "job")
	private String job;
	
//	@Temporal 
//	1.用來指定型態為java.util.Date, java.util.Calendar的mapping.
//	2.TemporalType, 有DATE(mapping到java.sql.Date)、TIME(mapping到java.sql.Time)、TIMESTAMP(mapping到java.sql.Timestamp)(預設值)
//	3.如果型態本來就是java.sql.Date, java.sql.Time, java.sql.Timestamp, 就不用@Temporal 
//	4.這範例有 import java.util.Date; --> 是故意用 java.util.Date 做展示，所以一定要加 @Temporal
	@Temporal(TemporalType.DATE)
	@Column(name = "hiredate")
	private Date hiredate;
	
	@Column(name = "sal")
	private BigDecimal sal;
	
	@Column(name = "comm")
	private BigDecimal comm;
	
	@Column(name = "empdeptno")
	private Integer empdeptno;

	public Emp() {
		super();
	}
	
	// 搭配TestHQLQueryProperty.java
	public Emp(Integer empno, String ename) {
		super();
		this.empno = empno;
		this.ename = ename;
	}

	public Integer getEmpno() {
		return empno;
	}

	public void setEmpno(Integer empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public BigDecimal getSal() {
		return sal;
	}

	public void setSal(BigDecimal sal) {
		this.sal = sal;
	}

	public BigDecimal getComm() {
		return comm;
	}

	public void setComm(BigDecimal comm) {
		this.comm = comm;
	}

	public Integer getEmpdeptno() {
		return empdeptno;
	}

	public void setEmpdeptno(Integer empdeptno) {
		this.empdeptno = empdeptno;
	}

	@Override
	public String toString() {
		return "Emp [empno=" + empno + ", ename=" + ename + ", job=" + job + ", hiredate=" + hiredate + ", sal=" + sal
				+ ", comm=" + comm + ", empdeptno=" + empdeptno + "]";
	}
	
}
