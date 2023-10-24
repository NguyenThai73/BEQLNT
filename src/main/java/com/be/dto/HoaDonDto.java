package com.be.dto;

import com.be.common_api.HopDong;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@ApiModel()
@Getter
@Setter
public class HoaDonDto extends BaseDto {
    private Long idHopDong;
    private HopDong hopDong;
    private Timestamp name;
    private String data;
    @Size(max = 255)
    private String file;
    @Size(max = 255)
    private String fileCk;
    private Timestamp dueDate;
    @Max(Integer.MAX_VALUE)
    private Integer total;
    @Max(Integer.MAX_VALUE)
    private Integer fine;
    private String description;
    private Short status;

    public HoaDonDto() {
    }
}