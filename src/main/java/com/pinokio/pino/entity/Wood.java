package com.pinokio.pino.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.annotations.One;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "wood")
public class Wood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer woodNum;
    private String woodName;

    @OneToMany(mappedBy = "wood")//(fetch = FetchType.EAGER)
    public List<Category> categoryList;
}
