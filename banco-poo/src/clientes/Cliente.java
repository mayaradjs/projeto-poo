package clientes;


import contas.Conta;
import java.util.ArrayList;
import java.util.Arrays;


public abstract class Cliente {
	//=========== ATRIBUTOS ===========//
	private String nome;
	private String telefone;
	private String endereco;
	private Conta[] contasDoCliente = new Conta[2];
	private int codCliente; //TODO Colocar a lógica de id's em quem cria e carrega os clientes
	
	
	//Construtor
	public Cliente( int codCliente, String nome, String telefone, String endereco) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.codCliente = codCliente;
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
