package com.pinokio.pino.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;


import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cateNum;
    private String cateName;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "wood_num")
    private Wood wood;

    //(fetch = FetchType.EAGER) EAGER/LAZY 차이점 알아보기!
    @OneToMany(mappedBy = "category", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JsonBackReference
    public List<Product> productList;

    public Integer getCateNum() {
        return cateNum;
    }

    public void setCateNum(Integer cateNum) {
        this.cateNum = cateNum;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

}
