package contas;

public abstract class CONTA {
	//=========== ATRIBUTOS ===========//
	private String nConta;
	private float saldo;
	
	
	//=========== MÉTODOS ===========//
	public String transferir(float transf, String conta){
		//construir condição para realizar a transferência
		//é preciso conferir a conta que terá o crédito
		//retornar mensagem de sucesso ou não para a transferência
		return "Saldo Insuficiente.";
		//return "Transferência realizada com sucesso.";		
	}
	
	public String saque(float transf, String conta){
		//construir condição para realizar o saque
		//é preciso conferir o saldo e limite da conta
		//retornar mensagem de sucesso ou não e o uso do limite(perguntar se usa ou não o limite) 
		return "Saldo Insuficiente.";
		//return "Saque realizado com sucesso.";
		//return "Esta operação vai utilizar X do seu limite."
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
	

}
