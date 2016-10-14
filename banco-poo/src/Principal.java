import java.util.Scanner;
import Util.Arquivo;
import clientes.*;
import contas.*;


public class Principal {
	static Conta c;
	static int contagemCod=0;
	static Arquivo arq;
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		int opcao, op;
		
		do{
			menuPrincipal();
			opcao = entrada.nextInt();
			
			switch (opcao){
			
			case 1:
				do{
					menuCliente();
					op = entrada.nextInt();
					switch (op){
						case 1:
							Cliente nvCliente;
							Conta nvConta;
							sop("Cadastro de Pessoa"); 
							sop("Nome?");
							String nome = entrada.nextLine();
							sop("Telefone?");
							String tel = entrada.nextLine();
							sop("Endereço?");
							String end = entrada.nextLine();
							sop("Pessoa Fisica ou Juridica?");
							String tpessoa = entrada.nextLine();
							if (tpessoa.equals("fisica")){
								sop("CPF?");
								String cpf = entrada.nextLine();
								nvCliente = new PFisica(contagemCod, nome, tel, end, cpf);
								contagemCod++;
							}else{
								sop("CNPJ?");
								String cnpj = entrada.nextLine();
								nvCliente = new PFisica(contagemCod, nome, tel, end, cnpj);
								contagemCod++;
							}
							sop("Numero da conta");
							String nconta = entrada.nextLine();
							sop("Saldo");
							float saldo = entrada.nextFloat();
							sop("Qual tipo da conta deseja criar? 0 Corrente - 1 Poupanca");
							int t = new Scanner(System.in).nextInt();
							if (t == 1){
								sop("Informe a taxa de rendimento");
								float tx = entrada.nextFloat();
								nvConta = new Poupanca(nconta, saldo, nvCliente, t, tx);
							}else{
								sop("Informe o limite");
								float lm = entrada.nextFloat();
								nvConta = new Corrente(nconta, saldo, nvCliente, t, lm);
								
							nvCliente.setContasDoCliente(nvConta, t);
							sop("Cliente e Conta cadastrados com sucesso");
							}
							break;
						case 2:
							sop("Opcao 2"); //TODO Implementar para editar um cliente (Isso inclui editar suas informações ou criar mais uma conta)
							break;
						case 3:
							sop("Exclusão"); //TODO Implementar para remover um cliente
							sop("Informe o codigo do cliente que deseja excluir");
							int codExc = entrada.nextInt();
							//deletar arquivo, caso exista senão exibir msg
							break;
						default:
							sop("Opcao Invalida.");
							break;
					}
				}while (op!=0);
				break;
				
			case 2:		
				do{
					logar();
					menuConta();
					op = entrada.nextInt();
					switch (op){
						case 1:
							sop("Informe o destinatário");
							//ler conta de destino
							sop("Informe o valor a ser transferido");
							float valor = new Scanner(System.in).nextFloat();
							//chamar metodo de transferencia
							break;
						case 2:
							sop("Informe o valor a ser sacado");
							valor = entrada.nextFloat();
							c.saque(valor);
							break;
						case 3:
							sop("Seu saldo é: " + c.getSaldo());
							break;
						default:
							sop("Opcao Invalida.");
							break;
					}
				}while (op!=0);
				break;
				
			default:
				sop("Opcao Invalida.");
				break;
			}
			
		}while(opcao != 0);
	}
	
	public static void menuPrincipal(){
		sop("- - - - -  Menu  - - - - - -\n");
		sop("Escolha um opcao abaixo:");
		sop("1- Acessar menu do cliente");
		sop("2- Acessar menu da Conta");
		sop("0- Encerrar");
	}
	
	public static void menuCliente(){
		sop("- - - - -  Menu  - - - - - -\n");
		sop("Escolha um opcao abaixo:");
		sop("1- Cadastrar cliente");
		sop("2- Editar um cliente");
		sop("3- Remover cliente");
		sop("0- Retornar ao menu principal");
	}
	
	public static void menuConta(){
		sop("- - - - -  Menu  - - - - - -\n");
		sop("Escolha um opcao abaixo:");
		sop("1- Transferir");
		sop("2- Sacar");
		sop("3- Ver saldo");
		sop("0- Retornar ao menu principal");
	}
	
	public static void sop(String msg){
		System.out.println(msg);
	}
	
	public static void logar(){
		boolean continuar;
		do{
			sop("Informe o codigo do cliente");
			//ler entrada
			sop("Informe o tipo da conta que deseja efetuar a transacao. (0 -CC/ 1- Poup)");
			int tipo = new Scanner(System.in).nextInt();
			if (tipo == 1){
				c = new Poupanca();
			}else{
				c = new Corrente();
			}
			if (2==2){//Se existe cliente com esse codigo
				continuar = false;
			}else{
				sop("Deseja tentar novamente? True/False");
				continuar = new Scanner(System.in).nextBoolean();
			}
			//Validar as informações recebidas antes de continuar
		}while(continuar);
	}
	

}
