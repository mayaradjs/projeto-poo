package contas;

import clientes.Cliente;
import contas.Conta;

public class Poupanca extends Conta {
	


	private float taxaDeRendimento;

	/**
	 * Construtores
	 **/
	
	public Poupanca(){
		
	}
	
	public Poupanca(String nConta, float saldo, Cliente titular, int tipo,
			float taxaDeRendimento) {
		super(nConta, saldo, titular, tipo);
		this.taxaDeRendimento = taxaDeRendimento;
	}
	
	
	
	/**
	 * Receber deposito incluindo a taxa de rendimento
	 */
	public void receberDeposito(float valor){
		setSaldo(getSaldo()+ (valor*(1+taxaDeRendimento)));
	}
	
	
	/**
	 * Getters and Setters
	 **/
	public float getTaxaDeRendimento() {
		return taxaDeRendimento;
	}

	public void setTaxaDeRendimento(float taxaDeRendimento) {
		this.taxaDeRendimento = taxaDeRendimento;
	}
	
	

}
