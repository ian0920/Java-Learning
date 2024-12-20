package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@Entity
@Table(name = "department") //若Table name跟Class name一樣則不用設定此欄
public class Dept {

    @Id
    @Column(name = "deptno") //若Column name跟變數名稱一樣則不需設定
    private Integer deptno;

    @Column(name = "dname")
    private String dname;

    @Column(name = "loc")
    private String loc;
}
