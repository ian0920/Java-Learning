package evt_coup.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "evt_coup")
public class EvtCoup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Integer id;

    @Column(name = "evt_id")
    private Integer evtId;

    @Column(name = "evt_coup_name")
    private String evtCoupName;

    @Column(name = "status")
    private Byte status;

    @Column(name = "type")
    private Byte type;

    @Column(name = "deduction")
    private Integer deduction;

    @Column(name = "ratio")
    private Double ratio;

    @Column(name = "start_date")
    private java.sql.Timestamp startDate;

    @Column(name = "end_date")
    private java.sql.Timestamp endDate;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "threshold")
    private Integer threshold;




}
