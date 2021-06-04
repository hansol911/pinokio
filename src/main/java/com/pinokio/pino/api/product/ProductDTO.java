package com.pinokio.pino.api.product;

import com.pinokio.pino.api.model.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
    private Long prodNum;
    private String prodName;
    private String prodName2;
    private String prodLink;

    public static ProductDTO toDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProdNum(product.getProdNum());
        productDTO.setProdName(product.getProdName());
        productDTO.setProdName2(product.getProdName2());
        productDTO.setProdLink(product.getProdLink());
        return productDTO;
    }
}
