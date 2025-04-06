package application;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		GerenciadorFinanceiro gf = new GerenciadorFinanceiro();

		menuPrincipal();

		System.out.print(">> ");
		int escolha = sc.nextInt();
		sc.nextLine();

		while (escolha != 5) {

			switch (escolha) {
			case 1:
				System.out.println("\n--- Adicionando receita ---");
				adicionarReceita(sc, gf);
				break;
			case 2:
				System.out.println("\n--- Adicionando despesa ---");
				adicionarDespesa(sc, gf);
				break;
			case 3:
				System.out.println("\n--- Consultando saldo ---");
				consultarSaldo();
				break;
			case 4:
				System.out.println("\n--- Listando transações ---");
				listarTransacoes();
				break;
			case 5:
				System.out.println("Saindo...");
				return;
			default:
				System.out.println("Opção inválida...");
			}
			System.out.println();
			menuPrincipal();
			System.out.print(">> ");
			escolha = sc.nextInt();
			sc.nextLine();
		}

		sc.close();
	}

	private static void menuPrincipal() {
		System.out.println("--- Menu Principal ---");
		System.out.println("1- Adicionar receita");
		System.out.println("2- Adicionar despesa");
		System.out.println("3- Consultar saldo");
		System.out.println("4- Listar transações");
		System.out.println("5- Sair");
	}

	private static void adicionarReceita(Scanner sc, GerenciadorFinanceiro gf) {

		System.out.println("\nDescrição da transação:");
		String descricao = sc.next();
		sc.nextLine();

		System.out.println("Valor: ");
		double valor = sc.nextDouble();
		sc.nextLine();

		System.out.println("Data (ex: 05/04/2025): ");
		String data = sc.next();
		sc.nextLine();

		Transacao receita = new Transacao("entrada", descricao, valor, data);
		gf.adicionarTransacao(receita);

		System.out.println("Receita adicionada com sucesso.");
	}

	private static void adicionarDespesa(Scanner sc, GerenciadorFinanceiro gf) {

		System.out.println("\nDescrição da transação:");
		String descricao = sc.next();

		System.out.println("Valor: ");
		double valor = sc.nextDouble();
		sc.nextLine();

		System.out.println("Data (ex: 05/04/2025): ");
		String data = sc.next();

		Transacao receita = new Transacao("saida", descricao, valor, data);
		gf.adicionarTransacao(receita);

		System.out.println("Despesa adicionada com sucesso.");

	}

	private static void consultarSaldo() {

	}

	private static void listarTransacoes() {

	}

}
