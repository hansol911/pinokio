package com.pinokio.pino.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Wood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long woodNum;
    private String woodName;
    private String woodName2;

    @OneToMany(mappedBy = "wood", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Category> categoryList;

}
