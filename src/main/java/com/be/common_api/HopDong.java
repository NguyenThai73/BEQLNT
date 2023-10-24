package com.be.common_api;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "hop_dong")
@Getter
@Setter
@DynamicUpdate
@Where(clause = "deleted=false")
public class HopDong extends BaseEntity{
    @Column(name = "id_phong")
    private Long idPhong;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_phong",referencedColumnName="id", nullable = false, insertable = false, updatable = false)
    private Phong phong;
    @Column(name = "date_start")
    private Timestamp dateStart;
    @Column(name = "date_end")
    private Timestamp dateEnd;
    @Column(name = "file")
    private String file;
    @Column(name = "number_people")
    private Short numberPeople;
    @Column(name = "status")
    private Short status;

}
