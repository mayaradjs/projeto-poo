package clientes;

public class PFisica extends Cliente {
	
	private String cpf;


	public PFisica(String nome, String telefone, String endereco, String cpf) {
		super(nome, telefone, endereco);
		this.cpf = cpf;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	

}
