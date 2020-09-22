package com.pinokio.pino.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cateNum;
    private String cateName;

    @ManyToOne
    @JoinColumn(name = "wood_num")
    private Wood wood;

    @OneToMany(mappedBy = "category")//(fetch = FetchType.EAGER)
    public List<Product> productList;
}
