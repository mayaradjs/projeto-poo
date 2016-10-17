package clientes;


import contas.Conta;
import java.util.ArrayList;
import java.util.Arrays;


public abstract class Cliente {
	//=========== ATRIBUTOS ===========//
	private String nome;
	private String telefone;
	private String endereco;
	private int tpCliente;
	private Conta[] contasDoCliente = new Conta[2];
	private int codCliente; //TODO Colocar a lógica de id's em quem cria e carrega os clientes
	
	
	//Construtor
	public Cliente( int codCliente, String nome, String telefone, String endereco, int tpCliente) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.codCliente = codCliente;
		this.setTpCliente(tpCliente);
	}
	
	
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

	public Conta getUmaContaDoCliente(int pos) {
		return contasDoCliente[pos];
	}
	
	public void setContasDoCliente(Conta contasDoCliente, int pos) {
		this.contasDoCliente[pos] = contasDoCliente;
	}




	public int getCodCliente() {
		return codCliente;
	}




	public void setCodCliente(int codCliente) {
		this.codCliente = codCliente;
	}




	public int getTpCliente() {
		return tpCliente;
	}




	public void setTpCliente(int tpCliente) {
		this.tpCliente = tpCliente;
	}

	
	
}
