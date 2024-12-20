package com.artogether.common.business_member;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "business_member")
public class BusinessMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String addr;

    @Column(name = "tax_id", nullable = false)
    private String taxId;

    @Column(name = "start_date", updatable = false, insertable = false)
    @CreationTimestamp
    private Timestamp startDate;

    @Column(name = "approve_date")
    private Timestamp approveDate;


    private Byte status;

}
