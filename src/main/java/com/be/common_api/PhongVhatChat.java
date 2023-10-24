package com.be.common_api;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name = "phong_vat_chat")
@Getter
@Setter
@DynamicUpdate
@Where(clause = "deleted=false")
public class PhongVhatChat extends BaseEntity{
    @Column(name = "id_phong")
    private Long idPhong;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_phong",referencedColumnName="id", nullable = false, insertable = false, updatable = false)
    private Phong phong;
    @Column(name = "id_vat_chat")
    private Long idVatChat;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_vat_chat",referencedColumnName="id", nullable = false, insertable = false, updatable = false)
    private VatChat vatChat;
    @Column(name = "status")
    private Short status;
}
