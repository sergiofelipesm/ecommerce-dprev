package br.com.dataprev.application.dto;

import java.math.BigDecimal;

public class ProdutoDTO {
	
	private Long id;

	private String produto;

	private BigDecimal preco;
	
	private Integer quantidade;
	
	private String descricao;
	
	private byte[] foto;
	
	private CategoriaDTO categoria;
	
	private RequestStatus status;
	
	public ProdutoDTO() {}
	
	public ProdutoDTO(RequestStatus status) {
		super();
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public CategoriaDTO getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaDTO categoria) {
		this.categoria = categoria;
	}
	
	

	public RequestStatus getStatus() {
		return status;
	}

	public void setStatus(RequestStatus status) {
		this.status = status;
	}



	public class RequestStatus {
		
		private int codigo;
		private String message;
		
		public RequestStatus() {}
		
		public RequestStatus(int codigo, String message) {
			super();
			this.codigo = codigo;
			this.message = message;
		}

		public int getCodigo() {
			return codigo;
		}
		public void setCodigo(int codigo) {
			this.codigo = codigo;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}

	}
}
