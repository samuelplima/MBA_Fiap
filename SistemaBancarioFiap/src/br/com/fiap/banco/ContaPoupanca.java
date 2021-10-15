package br.com.fiap.banco;

import br.com.fiap.banco.especial.Especial;

public class ContaPoupanca extends Conta implements Especial{

	private static final long serialVersionUID = 1L;
	private static final boolean temDireito = true;
	
	
	/*//obs: construtores com parametros na superclasse nao sao herdados e caso n haja
	 *  construtor padrao na superclasse ocorrera falha
	 */
	public ContaPoupanca(int numero) {
		super(numero); 
	}

	@Override
	public double verificarSaldo() {
		return getSaldo();
	}

	@Override
	public boolean checagemLimiteEspecial() {
		if(getSaldo()<=0 && temDireito) {
		return true;
		}
		else{
		return false;	
		}
	}

	@Override
	public void adcionaLimiteEspecial() {
		if(checagemLimiteEspecial() == true) {
			super.depositar(especialLimite);
		}
	}
	
	

}
