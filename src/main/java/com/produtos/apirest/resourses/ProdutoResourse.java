package com.produtos.apirest.resourses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.repository.ProdutoRepositoty;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.produtos.apirest.models.Produto;

@RestController
@RequestMapping(value = "/api")
@Api(value = "Api Rest para Produtos")
@CrossOrigin(origins = "*")
public class ProdutoResourse {
  
	@Autowired
	private ProdutoRepositoty produtoRepositoty;
	
	@GetMapping("/produtos")
	@ApiOperation(value = "Retorna uma lista de produtos")
	public List<Produto> listaProdutos(){
		return produtoRepositoty.findAll();
		
	}
	
	@GetMapping("/produto/{id}")
	@ApiOperation(value = "Retorna um produto")
	public Produto listaProdutoId(@PathVariable(value = "id") long id){
		return produtoRepositoty.findById(id);
		
	}
	
	@PostMapping("/produto")
	@ApiOperation(value = "Salva o produto")
	public Produto salvarProduto(@RequestBody Produto produto) {
		return produtoRepositoty.save(produto);
	}
	@DeleteMapping("/produto")
	@ApiOperation(value = "Deleta o produto")
	public void deletaProduto(@RequestBody Produto produto) {
		produtoRepositoty.delete(produto);
	}
	@PutMapping("/produto")
	@ApiOperation(value = "Atualiza o produto")
	public Produto atualizaProduto(@RequestBody Produto produto) {
		return produtoRepositoty.save(produto);
	}
}
