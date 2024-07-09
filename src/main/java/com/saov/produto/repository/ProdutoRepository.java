package com.saov.produto.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.saov.produto.modelo.ProductModel;

public interface ProdutoRepository extends CrudRepository<ProductModel, Integer>{
	
	List<ProductModel> findAll();
	
	ProductModel findById(int id);
	
	void delete(ProductModel p);
	
	<Product extends ProductModel> Product save(Product p);

}
