package br.com.fiap.arquivos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFiles {
	
	private FileReader stream;
	private BufferedReader reader;

	public void readFiles() {
		try {
			// Abre o arquivo
			stream = new FileReader("arquivo.txt");
			reader = new BufferedReader(stream);

			// Lê uma linha do arquivo
			String linha = reader.readLine();
			while (linha != null) {
				System.out.println(linha);
				// Lê a próxima linha do arquivo
				linha = reader.readLine();
			}

			reader.close();
			// Fecha o arquivo
			stream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
