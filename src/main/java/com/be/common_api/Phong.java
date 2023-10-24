package com.be.common_api;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name = "phong")
@Getter
@Setter
@DynamicUpdate
@Where(clause = "deleted=false")
public class Phong extends BaseEntity{
    @Column(name = "id_nha")
    private Long idNha;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_nha",referencedColumnName="id", nullable = false, insertable = false, updatable = false)
    private Nha nha;
    @Column(name = "name")
    private String name;
    @Column(name = "gia")
    private Integer gia;
    @Column(name = "status")
    private Short status;
}
