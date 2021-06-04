package com.pinokio.pino.api.product;

import com.pinokio.pino.api.model.Category;
import com.pinokio.pino.api.model.Product;
import lombok.Getter;
import lombok.Setter;

public class ProductCommand {

    @Getter
    @Setter
    public static class CreateProduct {
        private String prodName;
        private String prodName2;
        private String prodLink;
        private Long categoryNum;

        public Product toProduct (Category category){
            Product product = new Product();
            product.setProdName(prodName);
            product.setProdName2(prodName2);
            product.setProdLink(prodLink);
            product.setCategory(category);
            return product;
        }
    }

    @Getter
    @Setter
    public static class UpdateProduct {
        private String prodName;
        private String prodName2;
        private String prodLink;
        private Long categoryNum;

        public Product toProduct (Product product){
            product.setProdName(prodName);
            product.setProdName2(prodName2);
            product.setProdLink(prodLink);
            return product;
        }
    }
}
