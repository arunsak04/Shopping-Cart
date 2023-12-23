package com.jsp.ShoppingCart.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.ShoppingCart.DAO.ProductDAO;
import com.jsp.ShoppingCart.DTO.Product;

@RestController     ///// or @Controller
public class ProductController {
	@Autowired
	ProductDAO dao;
	
	
	@PostMapping("/product")   // end point
	 public Product addProduct(@RequestBody Product product) {// @RequestBody will convert JSON to JAVA object
		 
		return dao.addProduct(product);
	 }
	
	@GetMapping("/product")
	public List<Product> findAllProducts(){
		return dao.findAllProducts();
	}
	@DeleteMapping("product/{product_id}")
	public String deleteById(@PathVariable("product_id") int product_id) {
	return	dao.deleteById(product_id);
		
	}
	@GetMapping("product/searchproduct")
	public Product searchProduct(@RequestParam int id) {
		return dao.findProductById(id);
	}
	
	@DeleteMapping("/product")
	public String deleteProduct(@RequestParam int id) {
		return dao.deleteProductById(id);
	}
	
	@PutMapping("/product")
	public String setDescription(@RequestParam int id,@RequestParam String description)
	{
		boolean f=dao.update(id, description);
		if(f)
		{
		return "upDATED";
		}
		return "unsuccesful";
	}
}
