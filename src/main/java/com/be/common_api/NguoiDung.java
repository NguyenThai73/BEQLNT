package com.be.common_api;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "nguoi_dung")
@Getter
@Setter
@DynamicUpdate
@Where(clause = "deleted=false")
public class NguoiDung extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;
    @Column(name = "id_hop_dong")
    private Long idHopDong;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_hop_dong",referencedColumnName="id", nullable = false, insertable = false, updatable = false)
    private HopDong hopDong;
    @Column(name = "user_name")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    private Short role;
    //1:Chu tro  2:Nguoi thue
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "nam_sinh")
    private String namSinh;
    @Column(name = "sdt")
    private String sdt;
    @Column(name = "avatar")
    private String avatar;
    @Column(name = "file_cccd")
    private String fileCccd;
    @Column(name = "status")
    private Short status;
}
