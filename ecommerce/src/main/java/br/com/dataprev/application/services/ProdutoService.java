package br.com.dataprev.application.services;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.com.dataprev.application.dto.ProdutoDTO;
import br.com.dataprev.application.model.Produto;
import br.com.dataprev.application.repository.ProdutoRepository;

@Service
public class ProdutoService {

	private final ProdutoRepository repository;
	private ModelMapper mapper;

	public ProdutoService(ProdutoRepository repository) {
		super();
		this.repository = repository;
		mapper = new ModelMapper();
	}
	
	public ProdutoDTO cadastrarProduto(ProdutoDTO produto) throws Exception {
		Optional<Produto> produtoExistente = repository.findByProduto(produto.getProduto());
		if(produtoExistente.isPresent()) {
			throw new Exception("Produto Ja Cadastrado!");
		}
		Produto produtoNovo = mapper.map(produto, Produto.class);
		produtoNovo = repository.save(produtoNovo);
		return mapper.map(produtoNovo, ProdutoDTO.class);
	}
	
	public ProdutoDTO atualizarProduto(ProdutoDTO produto) throws Exception {
		Optional<Produto> produtoExistente = repository.findByProduto(produto.getProduto());
		if(!produtoExistente.isPresent()) {
			throw new Exception("Produto nao encontrado!");
		}
		Produto produtoNovo = mapper.map(produto, Produto.class);
		produtoNovo = repository.save(produtoNovo);
		return mapper.map(produtoNovo, ProdutoDTO.class);
	}
	
	public ProdutoDTO consultaProdutoPorId(Long id) throws Exception {
		Optional<Produto> produto = repository.findById(id);
		if(produto.isPresent()) {
			Produto prod = produto.get();
			return mapper.map(prod, ProdutoDTO.class);
		}
		throw new Exception("Produto Nao Encontrado");
	}
	
}
