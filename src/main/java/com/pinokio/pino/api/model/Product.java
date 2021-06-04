package com.pinokio.pino.api.model;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prodNum;
    private String prodName;
    private String prodName2;
    private String prodLink;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "cate_num")
    private Category category;
}
