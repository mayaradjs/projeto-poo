package clientes;

public class PJuridica extends Cliente {
	
	private String cnpj;



	public PJuridica(String nome, String telefone, String endereco, String cnpj) {
		super(nome, telefone, endereco);
		this.cnpj = cnpj;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

}
