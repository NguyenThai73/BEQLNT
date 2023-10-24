package com.be.common_api;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name = "vat_chat")
@Getter
@Setter
@DynamicUpdate
@Where(clause = "deleted=false")
public class VatChat extends BaseEntity{
    @Column(name = "name")
    private String name;
}
