package com.be.common_api;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name = "nha")
@Getter
@Setter
@DynamicUpdate
@Where(clause = "deleted=false")
public class Nha extends BaseEntity{
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "moTa")
    private String moTa;
    @Column(name = "status")
    private Short status;
}
