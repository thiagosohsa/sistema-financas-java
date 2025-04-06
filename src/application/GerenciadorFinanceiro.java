package application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GerenciadorFinanceiro {

	public void adicionarTransacao(Transacao t) {
		
		File arquivo = new File("financas.csv");
		boolean novoArquivo = false;

		if (!arquivo.exists()) {
			System.out.println("Arquivo csv não existe! Criando arquivo...");
			novoArquivo = true;
		}

		try (FileWriter fw = new FileWriter(arquivo, true)) {
			if (novoArquivo) {
				fw.write("Tipo,Descrição,Valor,Data\n");
			}
			fw.write(t.toString() + "\n");
		} catch (IOException e) {
			System.out.println("Erro ao salvar transação: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
