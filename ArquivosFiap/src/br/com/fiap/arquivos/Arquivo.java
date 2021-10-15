package br.com.fiap.arquivos;

import java.io.File;
import java.io.IOException;

public class Arquivo {
	
	private File diretorio;	
	private File arquivo;

	public void criaDiretorio() {		
		 diretorio = new File("fiap");

		if (diretorio.exists()) {
			System.out.println("Diretório existe!");
		} else {
			if (diretorio.mkdir())
				System.out.println("Diretório criado!");
			else
				System.out.println("Diretório não criado.");
		}

		arquivo = new File(diretorio, "file.txt");
		try {
			if (arquivo.createNewFile())
				System.out.println("Arquivo criado!");
			else
				System.out.println("Arquivo não criado!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void retornaDiretorio() {
		if(diretorio.exists()) {
			System.out.println("Diretorio existe ... mostrando caminho :");
			System.out.println(arquivo.getPath());
		}
		else {
			System.out.println("Diretorio nao existe.");
		}
	}

}
