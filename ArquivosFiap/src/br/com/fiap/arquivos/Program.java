package br.com.fiap.arquivos;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		ReadFiles read = new ReadFiles();
		WriteFiles write = new WriteFiles();
		Arquivo arquivo = new Arquivo();
		
		System.out.println("Abrindo arquivo...");
		System.out.print("Escreva no arquivo : ");
		String s = sc.nextLine() ;
		write.writeFile(s);
		
		System.out.println();
		System.out.println("Lendo...");
		read.readFiles();
		
		System.out.println();
		System.out.println("Criando nova pasta...");
		System.out.println("Criando arquivo ...");
		System.out.println();		
		arquivo.criaDiretorio();
		
		System.out.println();
		System.out.println("Caminho do arquivo criado : ");
		arquivo.retornaDiretorio();
		
		
		
		sc.close();
	}
	
}
