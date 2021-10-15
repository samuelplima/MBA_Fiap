package br.com.fiap.arquivos;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteFiles {
	
	private FileWriter stream;
	private PrintWriter print;

	public void writeFile(String string) {
		try {
			// Abre o arquivo
			stream = new FileWriter("arquivo.txt");
			print = new PrintWriter(stream);

			// Escreve no arquivo
			print.println(string);

			print.close();
			// Fecha o arquivo
			stream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}