package com.artogether.event.evt_order;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "evt_order")
public class EvtOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Integer id;

    @Column(name = "evt_id")
    private Integer evtId;

    @Column(name = "member_id")
    private Integer memberId;


    private Byte status;

    @Column(name = "order_Date")
    private Timestamp orderDate;
    private Integer qty;

    @Column(name = "evt_coup_id")
    private Integer evtCoupId;


    private Integer paid;

    @Column(name = "total_price")
    private Integer totalPrice;

    private Integer discount;
    private Integer refund;

    @Column(name = "refund_apply_date")
    private Timestamp refundApplyDate;

    @Column(name = "refund_date")
    private Timestamp refundDate;

    @Column(name = "payment_method")
    private Byte paymentMethod;


}
