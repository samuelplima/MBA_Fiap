package br.com.fiap.banco;

public class ContaCorrente extends Conta{

	private static final long serialVersionUID = 1L;
	private String tipo;
	private double chequeEspecial = 1000.0;	
	
	
	/*//obs: construtores com parametros na superclasse nao sao herdados e caso n haja
	 *  construtor padrao na superclasse ocorrera falha
	 */
	public ContaCorrente(String tipo, int numero) {
		super(numero); 
		this.tipo = tipo;
	}
		
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public double getChequeEspecial() {
		return chequeEspecial;
	}
	public void setChequeEspecial(double chequeEspecial) {
		this.chequeEspecial = chequeEspecial;
	}
	
	public double getSaldoDisponivel() {
		return getSaldo() + this.chequeEspecial;
	}
	
	@Override
	public void retirar(double valor){
	    valor += 10.0;
	    super.retirar(valor);
	}

	@Override
	public double verificarSaldo() {
		return getSaldo() + chequeEspecial;
	}
	

}
