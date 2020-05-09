package br.com.dataprev.application.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.dataprev.application.dto.ProdutoDTO;
import br.com.dataprev.application.dto.ProdutoDTO.RequestStatus;
import br.com.dataprev.application.services.ProdutoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "Api de Cadastro de Produtos - DataPrev")
public class ProdutoController {

	
	private final ProdutoService produtoService;
	
	public ProdutoController(ProdutoService produtoService) {
		super();
		this.produtoService = produtoService;
	}

	@ApiOperation(value = "Metodo responsavel por cadastrar novos produtos", response = ProdutoDTO.class)
	@PostMapping(value = "/produto/cadastrar")
	public ResponseEntity<ProdutoDTO> cadastrar(@RequestBody ProdutoDTO produto) {
		try {
			ProdutoDTO produtoDTO = produtoService.cadastrarProduto(produto);
			produtoDTO.setStatus(produtoDTO.new RequestStatus());
			produtoDTO.getStatus().setCodigo(HttpStatus.CREATED.value());
			produtoDTO.getStatus().setMessage("Produto Criado com sucesso");
			return new ResponseEntity<ProdutoDTO>(produtoDTO, HttpStatus.CREATED);
		} catch (Exception e) {
			produto.setStatus(produto.new RequestStatus());
			produto.getStatus().setCodigo(HttpStatus.INTERNAL_SERVER_ERROR.value());
			produto.getStatus().setMessage(e.getMessage());
			return new ResponseEntity<ProdutoDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation(value = "Metodo responsavel por atualizar novos produtos", response = ProdutoDTO.class)
	@PostMapping(value = "/produto/atualizar")
	public ResponseEntity<ProdutoDTO> atualizar(@RequestBody ProdutoDTO produto) {
		try {
			ProdutoDTO produtoDTO = produtoService.atualizarProduto(produto);
			produtoDTO.setStatus(produtoDTO.new RequestStatus());
			produtoDTO.getStatus().setCodigo(HttpStatus.OK.value());
			produtoDTO.getStatus().setMessage("Produto Atualizado com sucesso");
			return new ResponseEntity<ProdutoDTO>(produtoDTO, HttpStatus.OK);
		} catch (Exception e) {
			produto.setStatus(produto.new RequestStatus());
			produto.getStatus().setCodigo(HttpStatus.INTERNAL_SERVER_ERROR.value());
			produto.getStatus().setMessage(e.getMessage());
			return new ResponseEntity<ProdutoDTO>(produto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@ApiOperation(value = "Metodo responsavel por produto por id", response = ProdutoDTO.class)
	@GetMapping(value = "/produto/consultaPorId/{idProduto}")
	public ResponseEntity<ProdutoDTO> consultaPorId(@PathVariable(name = "idProduto") Long idProduto) {
		try {
			ProdutoDTO produtoDTO = produtoService.consultaProdutoPorId(idProduto);
			produtoDTO.setStatus(produtoDTO.new RequestStatus());
			produtoDTO.getStatus().setCodigo(HttpStatus.OK.value());
			produtoDTO.getStatus().setMessage("Produto Atualizado com sucesso");
			return new ResponseEntity<ProdutoDTO>(produtoDTO, HttpStatus.OK);
		} catch (Exception e) {
			ProdutoDTO produto = new ProdutoDTO();
			RequestStatus requestStatus = produto.new RequestStatus(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
			produto.setStatus(requestStatus);
			return new ResponseEntity<ProdutoDTO>(produto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
