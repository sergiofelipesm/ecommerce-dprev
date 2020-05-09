package br.com.dataprev.application.enums;

public enum StatusPedidoEnum {

	PENDENTE("Pendente"),
	CONFIRMADO("Confirmado"),
	ENTREGUE("Entregue");
	
	private String descricao;
	
	private StatusPedidoEnum(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
