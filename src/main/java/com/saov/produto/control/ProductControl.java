package com.saov.produto.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.saov.produto.modelo.ProductModel;
import com.saov.produto.repository.ProdutoRepository;

@RestController
@RequestMapping(name="/produtos")
public class ProductControl {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@RequestMapping(value="/produtos", method = RequestMethod.GET)
	public List<ProductModel> listar(){
		return produtoRepository.findAll();
	}
	
	@RequestMapping(value="/produtos", method=RequestMethod.POST)
	public ProductModel cadastrar(@RequestBody ProductModel p) {
		return produtoRepository.save(p);
	}
	
	@RequestMapping(value="/produtos/{id}", method = RequestMethod.GET)
	public ProductModel filtrar(@PathVariable int id) {
		return produtoRepository.findById(id);
	}

	@RequestMapping(value="/produtos", method = RequestMethod.PUT)
	public ProductModel alterar(@RequestBody ProductModel p) {
		return produtoRepository.save(p);
	}
	
	@RequestMapping(value="/produtos/{id}", method=RequestMethod.DELETE)
	public void remover(@PathVariable int id) {
		ProductModel p = filtrar(id);
		produtoRepository.delete(p);
	}
}
