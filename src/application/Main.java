package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
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
				mostrarSaldo();
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
		String descricao = sc.nextLine();

		System.out.println("Valor: ");
		double valor = 0.0;
		boolean valorValido = false;

		while (!valorValido) {
		    try {
		        valor = sc.nextDouble();
		        sc.nextLine();
		        valorValido = true;
		    } catch (InputMismatchException e) {
		        System.out.println("Valor inválido. Digite um número válido.");
		        sc.nextLine();
		    }
		}

		System.out.println("Data (ex: 05/04/2025): ");
		String data = sc.nextLine();

		Transacao receita = new Transacao("entrada", descricao, valor, data);
		gf.adicionarTransacao(receita);

		System.out.println("Receita adicionada com sucesso.");
	}

	private static void adicionarDespesa(Scanner sc, GerenciadorFinanceiro gf) {

		System.out.println("\nDescrição da transação:");
		String descricao = sc.nextLine();

		double valor = 0.0;
		boolean valorValido = false;

		while (!valorValido) {
		    try {
		    	System.out.println("Valor: ");
		        valor = sc.nextDouble();
		        sc.nextLine();
		        valorValido = true;
		    } catch (InputMismatchException e) {
		        System.out.println("Valor inválido. Digite um número válido.");
		        sc.nextLine();
		    }
		}

		System.out.println("Data (ex: 05/04/2025): ");
		String data = sc.nextLine();

		Transacao despesa = new Transacao("saida", descricao, valor, data);
		gf.adicionarTransacao(despesa);

		System.out.println("Despesa adicionada com sucesso.");

	}

	private static void mostrarSaldo() {
		
		File arquivo = new File("financas.csv");
		if (!arquivo.exists()) {
			System.out.println("Nenhuma transação encontrada.");
			return;
		}
		
		List<Transacao> lista = new ArrayList<>();
		
		String arquivoCSV = "financas.csv";
		
		try (BufferedReader br = new BufferedReader(new FileReader(arquivoCSV))){
			String line = br.readLine();
			line = br.readLine();
			while ((line != null)) {
				
				String[] vetor = line.split(",");
				String tipo = vetor[0];
				String descricao = vetor[1];
				Double valor = Double.parseDouble(vetor[2].replaceAll("[^0-9.]",""));
				String data = vetor[3];
				
				Transacao t = new Transacao(tipo,descricao,valor, data);
				lista.add(t);
				
				line = br.readLine();
			}
			
			Double receita = 0.0;
			Double despesa = 0.0;
			
			if (lista.isEmpty() == false) {
				for (Transacao t : lista) {
					if (t.getTipo().equals("entrada")) {
						receita += t.getValor();
					} else {
						despesa += t.getValor();
					}
				}
			}
					
			Double saldo = receita - despesa;
			System.out.println("R$: " + saldo);
		} catch (IOException e){
			System.out.println(e.getMessage());
		}
	}

	private static void listarTransacoes() {
		
		File arquivo = new File("financas.csv");
		if (!arquivo.exists()) {
			System.out.println("Nenhuma transação encontrada.");
			return;
		}
		
		List<Transacao> lista = new ArrayList<>();
		
		String arquivoCSV = "financas.csv";
		
		try (BufferedReader br = new BufferedReader(new FileReader(arquivoCSV))){
			String line = br.readLine();
			line = br.readLine();
			while ((line != null)) {
				
				String[] vetor = line.split(",");
				String tipo = vetor[0];
				String descricao = vetor[1];
				Double valor = Double.parseDouble(vetor[2].replaceAll("[^0-9.]",""));
				String data = vetor[3];
				
				Transacao t = new Transacao(tipo,descricao,valor, data);
				lista.add(t);
				
				line = br.readLine();
			}
			
			for(Transacao t : lista) {
				System.out.println(t);
			}
		} catch (IOException e){
			System.out.println(e.getMessage());
		}

	}

}
