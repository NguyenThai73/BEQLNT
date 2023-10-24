package com.be.dto;

import io.swagger.annotations.ApiModel;

import javax.validation.constraints.Size;

@ApiModel()
public class VatChatDto extends BaseDto {
    @Size(max = 255)
    private String name;

    public VatChatDto() {
    }
}