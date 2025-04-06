package application;

import java.io.Serializable;

public class Transacao implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String tipo;
	private String descricao;
	private Double valor;
	private String data;
	
	public Transacao(String tipo, String descricao, Double valor, String data) {
		this.tipo = tipo;
		this.descricao = descricao;
		this.valor = valor;
		this.data = data;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return tipo + "," + descricao + "," + valor + "," + data;
	}
	
}
