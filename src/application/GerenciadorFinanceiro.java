package application;

import java.io.FileWriter;
import java.io.IOException;

public class GerenciadorFinanceiro {

	public void adicionarTransacao(Transacao t) {
		try {
			FileWriter fw = new FileWriter("financas.csv", true);
			fw.write(t.toString() + "\n");
			fw.close();
		} catch (IOException e) {
			System.out.println("Erro ao salvar transação: " + e.getMessage());
		}
	}
}
