package com.artogether.event.event;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Integer id;

    @Column(name = "business_id")
    private Integer businessId;
    private String name;

    @Column(name = "start_date")
    private Timestamp startDate;

    @Column(name = "end_date")
    private Timestamp endDate;

    @Column(name = "delay_date")
    private Timestamp delayDate;

    @Column(name="catalog_id")
    private Byte catalogId;
    private Integer price;
    private String description;
    private Byte status;
    private Integer maximum;
    private Integer minimum;
    private Integer enrolled;


}
