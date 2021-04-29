package com.ecommerce.entity;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="user")
@Getter
@Setter

public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    private int userid;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    @Column(name = "fname")
    private String fname;
    

    @Column(name = "gender")
    private String gender;

    
    @Column(name = "lname")
    private String lname;
     
    @Column(name = "mobile")
    private String mobile;
    
    @Column(name = "password")
    private String password;

//    @OneToMany(mappedBy="user",cascade=CascadeType.ALL)
//    private Set<Order> orders;
	
//    public void add(Order order) {
//
//        if (order != null) {
//
//            if (orders == null) {
//                orders = new HashSet<>();
//            }
//
//            orders.add(order);
//             order.setUser(this);
//        }
//    }
//	

}
