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
public class Wood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer woodNum;
    private String woodName;

    @OneToMany(mappedBy = "wood", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Category> categoryList;

    public Integer getWoodNum() {
        return woodNum;
    }

    public void setWoodNum(Integer woodNum) {
        this.woodNum = woodNum;
    }

    public String getWoodName() {
        return woodName;
    }

    public void setWoodName(String woodName) {
        this.woodName = woodName;
    }

}
