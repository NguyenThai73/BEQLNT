package com.be.dto;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;

@ApiModel()
@Getter
@Setter
public class NhaDto extends BaseDto{
    @Size(max = 255)
    private String name;
    private String address;
    private String moTa;
    private Short status;
    public NhaDto() {
    }
}