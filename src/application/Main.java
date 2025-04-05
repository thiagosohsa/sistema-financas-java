package application;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		GerenciadorFinanceiro gf = new GerenciadorFinanceiro();

		System.out.println("\nDescrição da transação:");
		String descricao = sc.next();

		System.out.println("Valor: ");
		double valor = sc.nextDouble();

		System.out.println("Data (ex: 05/04/2025): ");
		String data = sc.next();

		Transacao receita = new Transacao("entrada", descricao, valor, data);
		gf.adicionarTransacao(receita);

		System.out.println("Receita adicionada com sucesso.");
		
		sc.close();
	}

}
