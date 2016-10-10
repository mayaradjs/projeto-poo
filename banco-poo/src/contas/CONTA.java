package contas;

import clientes.Cliente;

public abstract class Conta {
	//=========== ATRIBUTOS ===========//
	private String nConta;
	private float saldo;
	private Cliente titular;
	
	//=========== M�TODOS ===========//
	public String transferir(float transf, Cliente destinatario){
		
		if (getSaldo() >= transf){
			this.setSaldo(getSaldo() - transf);
			//destinatario.contasDoCliente. //TODO depositar saldo no destinatario
		}else
			return "Saldo insuficiente"
		
		//construir condi��o para realizar a transfer�ncia
		//� preciso conferir a conta que ter� o cr�dito
		//retornar mensagem de sucesso ou n�o para a transfer�ncia
		return "Saldo Insuficiente.";
		//return "Transfer�ncia realizada com sucesso.";		
	}
	
	public String saque(float transf, String conta){
		//construir condi��o para realizar o saque
		//� preciso conferir o saldo e limite da conta
		//retornar mensagem de sucesso ou n�o e o uso do limite(perguntar se usa ou n�o o limite) 
		return "Saldo Insuficiente.";
		//return "Saque realizado com sucesso.";
		//return "Esta opera��o vai utilizar X do seu limite."
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
	

}