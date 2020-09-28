package com.pinokio.pino.entity;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer prodNum;
    private String prodName;
    private String prodLink;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "cate_num")
    private Category category;

    public Integer getProdNum() {
        return prodNum;
    }

    public void setProdNum(Integer prodNum) {
        this.prodNum = prodNum;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getProdLink() { return prodLink; }

    public void setProdLink(String prodLink) { this.prodLink = prodLink; }
}
