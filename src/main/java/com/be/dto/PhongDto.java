package com.be.dto;

import com.be.common_api.BaseEntity;
import com.be.common_api.Nha;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;

@ApiModel()
@Getter
@Setter
public class PhongDto extends BaseDto {
    private Long idNha;
    private Nha nha;
    @Size(max = 255)
    private String name;
    private Integer gia;
    private Short status;

    public PhongDto() {
    }
}