package com.pinokio.pino.api.wood;

import com.pinokio.pino.api.model.Wood;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WoodDTO {
    private Long woodNum;
    private String woodName;
    private String woodName2;

    public static WoodDTO toDTO(Wood wood) {
        WoodDTO woodDTO = new WoodDTO();
        woodDTO.setWoodNum(wood.getWoodNum());
        woodDTO.setWoodName(wood.getWoodName());
        woodDTO.setWoodName2(wood.getWoodName2());
        return woodDTO;
    }

}
