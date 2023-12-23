package com.jsp.ShoppingCart.DTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
//@Setter
//@Getter
@Entity    // create table with specified variables
@Data   /// implicitly generates getters and setters
public class Product {
	@Id // it will mark this variable as a primary key in a table
	@GeneratedValue(strategy = GenerationType.IDENTITY) // it will generate automatic integer number
	private int product_id;
	private String product_name;
	private  int  quantity;
	private String  description;
 
}
