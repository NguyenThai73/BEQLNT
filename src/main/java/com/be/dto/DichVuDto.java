package com.be.dto;

import com.be.common_api.Nha;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;

@ApiModel()
@Getter
@Setter
public class DichVuDto extends BaseDto {
    private Long idNha;
    private Nha nha;
    private String name;
    private Integer donVi;
    private Integer donGia;

    public DichVuDto() {
    }
}