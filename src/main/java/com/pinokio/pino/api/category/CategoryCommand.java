package com.pinokio.pino.api.category;

import com.pinokio.pino.api.model.Category;
import com.pinokio.pino.api.model.Wood;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryCommand {
    private String cateName;
    private String cateName2;
    private Long woodNum;

    public Category toCategory(Wood wood) {
        Category category = new Category();
        category.setCateName(cateName);
        category.setCateName2(cateName2);
        category.setWood(wood);
        return category;
    }
}
