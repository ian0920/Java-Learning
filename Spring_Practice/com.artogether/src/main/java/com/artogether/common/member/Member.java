package com.artogether.common.member;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Integer id;
    private String name;
    private String email;

    @Column(name = "register_date")
    private Timestamp registerDate;
    private Date birthday;
    private String gender;
    private String prefer;
    private String phone;
    private String password;
    private Byte status;

    @Column(name = "oath_provider")
    private String oathProvider;

    @Column(name = "oath_user_id")
    private String oathUserId;

}
