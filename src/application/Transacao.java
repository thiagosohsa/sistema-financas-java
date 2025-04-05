package application;

public class Transacao {
	
	private String tipo;
	private String descricao;
	private double valor;
	private String data;
	
	public Transacao(String tipo, String descricao, double valor, String data) {
		this.tipo = tipo;
		this.descricao = descricao;
		this.valor = valor;
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "Tipo: " + tipo + ", Descrição: " + descricao + ", Valor: R$" + valor + ", Data: " + data;
	}
	
}
