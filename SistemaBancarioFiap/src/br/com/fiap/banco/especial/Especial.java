package br.com.fiap.banco.especial;

public interface Especial {
	
	Double especialLimite = 1000.0;
	
	boolean checagemLimiteEspecial();
	
	void adcionaLimiteEspecial();	

}
