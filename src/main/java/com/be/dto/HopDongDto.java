package com.be.dto;

import com.be.common_api.Phong;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;
import java.sql.Timestamp;

@ApiModel()
@Getter
@Setter
public class HopDongDto extends BaseDto {
    private Long idPhong;
    private Phong phong;
    private Timestamp dateStart;
    private Timestamp dateEnd;
    @Size(max = 255)
    private String file;
    private Short numberPeople;
    private Short status;

    public HopDongDto() {
    }
}