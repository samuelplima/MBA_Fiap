package br.com.fiap.banco.program;

import br.com.fiap.banco.ContaCorrente;
import br.com.fiap.banco.ContaPoupanca;

public class Program {

	public static void main(String[] args) {
		
		//conta corrente
		ContaCorrente cc = new ContaCorrente("PF", 321);
		cc.setAgencia(123);
		cc.depositar(1000);
		cc.retirar(500);	
		System.out.println("Conta corrente tipo : " + cc.getTipo() + ", agencia: " + cc.getAgencia() + ", conta : " + cc.getNumero());
		System.out.println("Saldo conta corrente : "  + cc.getSaldo() + ", cheque especial + saldo : " + cc.getSaldoDisponivel());
		
		//conta poupanca
		ContaPoupanca poupanca = new ContaPoupanca(789);
		poupanca.setAgencia(456);
		poupanca.depositar(1000.0);
		poupanca.retirar(1000.0);
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("Conta poupança agencia : " + poupanca.getAgencia() + ", conta numero : " + poupanca.getNumero());
		System.out.println("Saldo conta Poupança : " + poupanca.getSaldo());
		System.out.println("Verificando se possui limite especial para conta poupança...");
		System.out.println("Possui direito : " + poupanca.checagemLimiteEspecial());
		
		System.out.println();
		if(poupanca.checagemLimiteEspecial()) {
			System.out.println("Adicionando limite especial...");
			poupanca.adcionaLimiteEspecial();
			System.out.println("Novo saldo : " + poupanca.getSaldo());
		}
		
		
		else {
			System.out.println("Nao possui direito.");
			System.out.println("Saldo : " + poupanca.getSaldo());
		}
		
	
	}

}
