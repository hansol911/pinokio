package com.pinokio.pino.api.category;

import com.pinokio.pino.api.model.Category;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CategoryDTO {
    private Long cateNum;
    private String cateName;
    private String cateName2;
    private Long woodNum;

    public static CategoryDTO toDTO(Category category, Long woodNum) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setCateNum(category.getCateNum());
        categoryDTO.setCateName(category.getCateName());
        categoryDTO.setCateName2(category.getCateName2());
        categoryDTO.setWoodNum(woodNum);
        return categoryDTO;
    }

}
