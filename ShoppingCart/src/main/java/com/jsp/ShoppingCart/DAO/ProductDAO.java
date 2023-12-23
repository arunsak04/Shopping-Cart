package com.jsp.ShoppingCart.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.jsp.ShoppingCart.DTO.Product;
import com.jsp.ShoppingCart.Repository.ProductRepository;

@Repository ////  
public class ProductDAO {
	
	@Autowired
	ProductRepository repository;
	
	// adding products(Obj) into cart
	public  Product addProduct(Product product) {
		return repository.save(product);
	}

	
	public List<Product> findAllProducts( ){
		return repository.findAll();
	}
	
	public String deleteById(@PathVariable("product_id") int product_id) {
		repository.deleteById(product_id);
		return "product is deleted";
	}
	
	public Product findProductById(int id) {
	Optional<Product> opt=	repository.findById(id);
	 
	if(opt.isPresent()) {
		return opt.get();
	}
	return null;
	
	}
	
	
	public String deleteProductById(int id) {
		Product p=findProductById(id);
		if(p!=null) {
			//repository.deleteById(id);
			repository.delete(p);
			return "Product is deleted";
		}
		return "Product is not availiable in cart";
	}
	public boolean update(int id,String description)
	{
		Product p=findProductById(id);
		if(p!=null)
		{
			p.setDescription(description); 
			repository.save(p);
			return true;
		}
		else
		return false;
	}
}

 
