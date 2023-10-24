package com.be.dto;

import com.be.common_api.HopDong;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;

@ApiModel()
@Getter
@Setter
public class NguoiDungDto extends BaseDto {
    private Long idHopDong;
    private HopDong hopDong;
    @Size(max = 255)
    private String username;
    @Size(max = 255)
    private String password;
    private Short role;
    @Size(max = 255)
    private String fullName;
    @Size(max = 255)
    private String namSinh;
    @Size(max = 255)
    private String sdt;
    @Size(max = 255)
    private String avatar;
    @Size(max = 255)
    private String fileCccd;
    private Short status;

    public NguoiDungDto() {
    }
}