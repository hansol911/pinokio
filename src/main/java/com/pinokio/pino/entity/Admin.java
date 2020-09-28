package com.pinokio.pino.entity;

import lombok.*;
//import org.hibernate.annotations.Entity;
//import org.hibernate.annotations.Table;

import javax.persistence.*;

//@Builder
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
//@Table(name = "admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminNum;
    private String adminId;
    private String adminPass;
    private String adminName;
    private String phone;

}
