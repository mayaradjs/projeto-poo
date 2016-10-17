package contas;

import clientes.Cliente;

public abstract class Conta {
	//=========== ATRIBUTOS ===========//
	private String nConta;
	private float saldo;
	private Cliente titular;
	private int tipo; // 0-corrente 1-popupanca
	

	//=========== Construtores ===========//
	
	public Conta(){
		
	}
	
	public Conta(String nConta, float saldo, Cliente titular, int tipo) {
		this.nConta = nConta;
		this.saldo = saldo;
		this.titular = titular;
		this.tipo = tipo;
	}
	
	
	
	//=========== METODOS ===========//
	public void transferir(float transf, Conta destinatario){
		
		if (getSaldo() >= transf){
			this.setSaldo(this.getSaldo()-transf);
			destinatario.receberDeposito(transf);
			System.out.println("Operação realizada com sucesso!");
		}else
			System.out.println("Saldo insuficiente");
	
	}
	



	//Metodo Saque sem levar em consideração se há limite ou nao. Apenas quem tem essa opção sao contas correntes
	public String saque(float valor){
		
		
		if (getSaldo() >= valor){
			this.setSaldo(getSaldo() - valor);
			return "Operação realizada com sucesso!";
		}else
			return "Saldo insuficiente";

	}
	
	public void receberDeposito(float valor){
		setSaldo(getSaldo()+valor);
	}
	
	
	public float getSaldo() {
		return saldo;
	}
	
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public String getnConta() {
		return nConta;
	}

	public void setnConta(String nConta) {
		this.nConta = nConta;
	}

	public Cliente getTitular() {
		return titular;
	}

	public void setTitular(Cliente titular) {
		this.titular = titular;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	

}