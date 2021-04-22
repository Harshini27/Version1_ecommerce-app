package com.ecommerce.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="user")
@Data

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

	
	

}
