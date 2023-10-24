package com.be.common_api;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name = "dich_vu")
@Getter
@Setter
@DynamicUpdate
@Where(clause = "deleted=false")
public class DichVu extends BaseEntity{
    @Column(name = "id_nha")
    private Long idNha;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_nha",referencedColumnName="id", nullable = false, insertable = false, updatable = false)
    private Nha nha;
    @Column(name = "don_vi")
    private Integer donVi;

    @Column(name = "name")
    private String name;
    @Column(name = "don_gia")
    private Integer donGia;
}
