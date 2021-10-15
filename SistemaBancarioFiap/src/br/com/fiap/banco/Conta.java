package br.com.fiap.banco;

import java.io.Serializable;

public abstract class Conta implements Serializable{

	private static final long serialVersionUID = 1L;
	private int agencia;
	private int numero;
	private double saldo;

	public Conta(int numero){
		this.numero = numero;
		}	
	
	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public double getSaldo() {
		return saldo;
	}
	
	public void depositar(double valor) {
		this.saldo += valor;
	}
	
	public void retirar(double valor) {
		this.saldo -= valor;
	}	
	
	public abstract double verificarSaldo();
	
}
