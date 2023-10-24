package com.be.common_api;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "hoa_don")
@Getter
@Setter
@DynamicUpdate
@Where(clause = "deleted=false")
public class HoaDon  extends BaseEntity{
    @Column(name = "id_hop_dong")
    private Long idHopDong;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_hop_dong",referencedColumnName="id", nullable = false, insertable = false, updatable = false)
    private HopDong hopDong;
    @Column(name = "name")
    private Timestamp name;
    @Column(name = "data")
    private String data;
    @Column(name = "file")
    private String file;
    @Column(name = "file_ck")
    private String fileCk;
    @Column(name = "due_date")
    private Timestamp dueDate;
    @Column(name = "total")
    private Integer total;
    @Column(name = "fine")
    private Integer fine;
    @Column(name = "description")
    private String description;
    @Column(name = "status")
    private Short status;
}
