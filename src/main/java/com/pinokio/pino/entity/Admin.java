package com.pinokio.pino.entity;

import lombok.*;
//import org.hibernate.annotations.Entity;
//import org.hibernate.annotations.Table;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//@Builder
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
//@Table(name = "admin")
public class Admin {
    @Id
    private String adminId;
    private String adminPass;
    private String adminName;
    private String phone;
}
