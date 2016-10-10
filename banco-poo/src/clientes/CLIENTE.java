package clientes;


import contas.Conta;


public abstract class Cliente {
	//=========== ATRIBUTOS ===========//
	private String nome;
	private String telefone;
	private String endereco;
	private Conta[] contasDoCliente;
	//private int codCliente = 0; //TODO Colocar a lógica de id's em quem cria e carrega os clientess
	
	
	
	//Construtor
	public Cliente(String nome, String telefone, String endereco) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		//this.setCodCliente(this.getCodCliente() + 1);
	}

	
	
	
//=========== M�TODOS ===========//


//Cadastrar clientes com n� da conta, nome e saldo. Esse dados ficar�o salvos em arquivo txt.



	
	
	// Getters and Setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Conta[] getContasDoCliente() {
		return contasDoCliente;
	}

	public void setContasDoCliente(Conta[] contasDoCliente) {
		this.contasDoCliente = contasDoCliente;
	}




	public int getCodCliente() {
		return codCliente;
	}




	public void setCodCliente(int codCliente) {
		this.codCliente = codCliente;
	}

	
	
}
