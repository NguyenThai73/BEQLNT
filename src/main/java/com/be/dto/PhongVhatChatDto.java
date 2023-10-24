package com.be.dto;

import com.be.common_api.Phong;
import com.be.common_api.VatChat;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@ApiModel()
@Getter
@Setter
public class PhongVhatChatDto extends BaseDto {
    private Long idPhong;
    private Phong phong;
    private Long idVatChat;
    private VatChat vatChat;
    private Short status;

    public PhongVhatChatDto() {
    }
}