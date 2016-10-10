import java.util.Scanner;

public class Principal {

	
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
							sop("Opcao 1"); //TODO Fazer as chamadas dos metodos e leituras necessarias para cadastrar novo cliente
							break;
						case 2:
							sop("Opcao 2"); //TODO Implementar para editar um cliente (Isso inclui editar suas informações ou criar mais uma conta)
							break;
						case 3:
							sop("Opcao 3"); //TODO Implementar para remover um cliente
							break;
						default:
							sop("Opcao Invalida.");
							break;
					}
				}while (op!=0);
				break;
				
			case 2:		
				do{
					sop("Informe o codigo do cliente");
					//ler entrada
					sop("Informe o numero da conta");
					//ler entrada
					//Validar as informações recebidas antes de continuar
					menuConta();
					op = entrada.nextInt();
					switch (op){
						case 1:
							sop("Informe o valor a ser transferido");
							float valor = new Scanner(System.in).nextFloat();
							break;
						case 2:
							sop("Opcao 2");
							break;
						case 3:
							sop("Opcao 3");
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
	
	

}
