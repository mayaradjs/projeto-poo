package contas;

import java.util.Scanner;

import clientes.Cliente;


public class Corrente extends Conta{


	//=========== ATRIBUTOS ===========//
	private float limite;
	
	
	
	

	//=========== Construtores ===========//
	
	public Corrente() {

	}

	public Corrente(String nConta, float saldo, Cliente titular, int tipo, float limite) {
		super(nConta, saldo, titular, tipo);
		this.limite = limite;

	}

	
	

	//=========== MÉTODOS ===========//

	public String saque(float valor){
		
		
		if (getSaldo() >= valor){
			this.setSaldo(getSaldo() - valor);
			return "Operação realizada com sucesso!";
		}else if ((getSaldo()+limite) >= valor){
			System.out.println("Este valor usará seu limite tem certeza que quer continuar? S/N");
			String resposta = new Scanner(System.in).next(); 
			if (resposta.equals("S")){
				this.setSaldo(getSaldo() - valor);
				return "Operação realizada com sucesso! Seu saldo está negativo";
			}else{
				return "Operacao cancelada!";
			}
		}else
			return "Saldo insuficiente";

	}
	

	public float getLimite() {
		return limite;
	}

	public void setLimite(float limite) {
		this.limite = limite;
	}

}
