import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import Util.Arquivo;
import clientes.*;
import contas.*;


public class Principal {
	private Conta contaLogada;
	Cliente logado;
	int tipoContaLogada;
	private static int contagemCod=0;
	public static ArrayList<Cliente> listCliente = new ArrayList<Cliente>();
	public static ArrayList<Conta> listConta = new ArrayList<Conta>();
	

	public void start(){
		Scanner entrada = new Scanner(System.in);
		
		try{			
			CarregarDados();
		}catch(Exception e){
			sop("Erro - Falhar ao carregar o dados. Exceção retornada: "
					+e.getMessage());
			System.exit(-1);
		}

		int opcao, op;
		
		do{
			menuPrincipal();
			opcao = entrada.nextInt();
			
			switch (opcao){
			case 0:
				break;
			case 1:
				do{
					menuCliente();
					op = entrada.nextInt();
					switch (op){
						case 0:
							break;
						case 1:
							Cliente nvCliente;
							Conta nvConta;
							sop("Cadastro de Pessoa"); 
							sop("Nome?");
							String nome = new Scanner(System.in).nextLine();
							sop("Telefone?");
							String tel = new Scanner(System.in).nextLine();
							sop("Endereço?");
							String end = new Scanner(System.in).nextLine();
							sop("Pessoa 1-Fisica ou  2-Juridica?");
							int tpessoa = new Scanner(System.in).nextInt();
							if (tpessoa == 1){
								sop("CPF?");
								String cpf = new Scanner(System.in).nextLine();
								nvCliente = new PFisica(contagemCod, nome, tel, end, cpf);
								contagemCod++;
							}else if (tpessoa == 0){
								sop("CNPJ?");
								String cnpj = new Scanner(System.in).nextLine();
								nvCliente = new PFisica(contagemCod, nome, tel, end, cnpj);
								contagemCod++;
							}else{
								sop("Opcao inválida");
								break;
							}
							sop("Numero da conta");
							String nconta = new Scanner(System.in).nextLine();
							sop("Saldo");
							float saldo = (float)new Scanner(System.in).nextFloat();
							sop("Qual tipo da conta deseja criar? 0 Corrente - 1 Poupanca");
							int t = new Scanner(System.in).nextInt();
							if (t == 1){
								sop("Informe a taxa de rendimento");
								float tx = (float)entrada.nextFloat();
								nvConta = new Poupanca(nconta, saldo, nvCliente, t, tx);
							}else{
								sop("Informe o limite");
								float lm = entrada.nextFloat();
								nvConta = new Corrente(nconta, saldo, nvCliente, t, lm);
								
							}
							nvCliente.setContasDoCliente(nvConta, t);	
							try {
								SalvarClienteArquivo(nvCliente, true);
								listCliente.add(nvCliente);
								listConta.add(nvConta);
								sop("Cliente e Conta cadastrados com sucesso");
								sop("O codigo do cliente eh " + nvCliente.getCodCliente());
							} catch (Exception e) {
								sop("Erro - Falha ao salvar no arquivo. Exceção retornado do objeto: "+
										e.getMessage());
								contagemCod--;
							}
							
							break;
							
						case 2:
							sop("---- Exclusão ----"); 
							sop("Informe o codigo do cliente que deseja excluir");
							int codExc = entrada.nextInt();
							Cliente excluido = getCliente(codExc);
							if (excluido == null)
								sop("Cliente inexistente");
							else{
								try{
									SalvarClienteArquivo(excluido, false);
									sop("Cliente excluido com sucesso!");
								}catch (Exception e){
									sop("Erro - Falha ao salvar no arquivo. Exceção retornado do objeto: "+
											e.getMessage());
								}
							}
							break;
						default:
							sop("Opcao Invalida.");
							break;
					}
				}while (op!=0);
				break;
				
			case 2:
				if (logar()){
					do{
						menuConta();
						op = entrada.nextInt();
						switch (op){
							case 0:
								break;
							case 1:
								sop("Informe o numero da conta do destinatário");
								String codContaDestino = new Scanner(System.in).nextLine();
								sop("Informe o valor a ser transferido");
								float valor = new Scanner(System.in).nextFloat();
								if (getConta(codContaDestino) == null){
									sop("Conta inexistente");
									break;
								}else{
									Conta contaDestino = getConta(codContaDestino);
									contaLogada.transferir(valor, contaDestino);
									try{
										SalvarClienteArquivo(logado, true);
										SalvarClienteArquivo(contaDestino.getTitular(), true);
									}catch(Exception e){
										sop("Erro - Falha ao salvar no arquivo. Exceção retornado do objeto: "+
												e.getMessage());
									}
								}
								
								
								break;
							case 2:
								sop("Informe o valor a ser sacado");
								valor = entrada.nextFloat();
								contaLogada.saque(valor);
								try{
									SalvarClienteArquivo(logado, true);
								}catch(Exception e){
									sop("Erro - Falha ao salvar no arquivo. Exceção retornado do objeto: "+
											e.getMessage());
								}
								break;
							case 3:
								sop("Seu saldo é: " + contaLogada.getSaldo());
								break;
							default:
								sop("Opcao Invalida.");
								break;
						}
					}while (op!=0);
				}
				break;
			case 3:
				sop("Informe o numero da conta em que deseja depositar");
				String codContaDestino = new Scanner(System.in).nextLine();
				sop("Informe o valor a ser depositado");
				float valor = new Scanner(System.in).nextFloat();
				if (getConta(codContaDestino) == null){
					sop("Conta inexistente");
					break;
				}else{
					Conta contaDestino = getConta(codContaDestino);
					contaDestino.receberDeposito(valor);
					sop("Deposito realizado com sucesso");
					try{
						SalvarClienteArquivo(contaDestino.getTitular(), true);
					}catch(Exception e){
						sop("Erro - Falha ao salvar no arquivo. Exceção retornado do objeto: "+
								e.getMessage());
					}
				}
				break;
			default:
				sop("Opcao Invalida.");
				break;
			}
			
		}while(opcao != 0);
	}
	
	public static void main(String[] args) {
		new Principal().start();
	}
	
	public void menuPrincipal(){
		sop("- - - - -  Menu  - - - - - -\n");
		sop("Escolha um opcao abaixo:");
		sop("1- Acessar menu do cliente");
		sop("2- Acessar menu da Conta");
		sop("3- Fazer deposito");
		sop("0- Encerrar");
	}
	
	public void menuCliente(){
		sop("- - - - -  Menu  - - - - - -\n");
		sop("Escolha um opcao abaixo:");
		sop("1- Cadastrar cliente");
		sop("2- Remover cliente");
		sop("0- Retornar ao menu principal");
	}
	
	public void menuConta(){
		sop("- - - - -  Menu  - - - - - -\n");
		sop("Escolha um opcao abaixo:");
		sop("1- Transferir");
		sop("2- Sacar");
		sop("3- Ver saldo");
		sop("0- Retornar ao menu principal");
	}
	
	public void sop(String msg){
		System.out.println(msg);
	}
	
	public boolean logar(){
		boolean continuar;
		do{
			sop("Informe o codigo do cliente");
			int codCliente = new Scanner(System.in).nextInt();
			logado = getCliente(codCliente);
			if (!(logado == null)){
			sop("Informe o tipo da conta que deseja efetuar a transacao. (0 -CC/ 1- Poup)");
			tipoContaLogada = new Scanner(System.in).nextInt();
				if(logado.getUmaContaDoCliente(tipoContaLogada) == null){
					sop("Esse cliente nao possui esse tipo de conta");
					sop("Por favor, tente novamente");
					continuar = true;
				}else{
					contaLogada = logado.getUmaContaDoCliente(tipoContaLogada);
					return true;
				}
			}else{
				sop("Cliente invalido");
				sop("Deseja tentar novamente? true/false");
				continuar = new Scanner(System.in).nextBoolean();
			}
		}while(continuar);
		return false;
	}
	
	public void CarregarDados() throws IOException,Exception{
		int index = 0;
		Arquivo dado; //Classe arquivo para Abstrair leitura/escrita de arquivos
		
		//-- INFORMAÇÕES DE CLIENTE
		int codCliente;
		int tipoCliente;
		String cpf_cnpj;
		String nome;
		String telefone;
		String endereco;		
		Cliente client;
		//-- INFORMAÇÕES DE CONTA
		String nConta;
		float saldo;
		int tipoConta;
		Conta account;
		float limite_juros;
		
		while (new File(String.valueOf(index++)+".mld").exists()){
			dado = new Arquivo(String.valueOf(index-1)+".mld");
			if(dado.carregar().equals("1")){
				//Carregando a classe CLIENTE
				codCliente = Integer.parseInt(dado.carregar());
				tipoCliente = Integer.parseInt(dado.carregar());
				cpf_cnpj = dado.carregar();
				nome = dado.carregar();
				telefone = dado.carregar();
				endereco = dado.carregar();
				if(tipoCliente==0)
					client = new PFisica(codCliente,nome,telefone,endereco,cpf_cnpj);
				else
					client = new PJuridica(codCliente, nome, telefone, endereco, cpf_cnpj);
				contagemCod++;
				listCliente.add(client);
				//Fim do carregamendo do cliente
				dado.carregar(); // Para jogar fora o ---
				
				if(!dado.NEOF())
					continue;
				while(dado.NEOF()){
					//Carregando conta
					tipoConta = Integer.parseInt(dado.carregar());
					nConta = dado.carregar();
					saldo = Float.parseFloat(dado.carregar());
					limite_juros = Float.parseFloat(dado.carregar());
					if(tipoConta==0)
						account = new Corrente(nConta, saldo, client, 0, limite_juros);
					else
						account = new Poupanca(nConta, saldo, client, 1, limite_juros);
						
					client.setContasDoCliente(account, account.getTipo());
					listConta.add(account);
					//Fim do carregamento da conta
					dado.carregar();
				}
				
			}
		}
	}

	public void SalvarClienteArquivo(Cliente client,boolean contaHabilitada) throws IOException{
		Arquivo dado = new Arquivo(String.valueOf(client.getCodCliente())+".mld");
		dado.reCriaArquivo();
		if(contaHabilitada)
			dado.salvar("1");
		else
			dado.salvar("0");
		
		dado.salvar(String.valueOf(client.getCodCliente()));
		dado.salvar(String.valueOf(client.getTpCliente()));
		
		if(client.getTpCliente() == 0){
			dado.salvar(((PFisica)client).getCpf());
		}else{
			dado.salvar(((PJuridica)client).getCnpj());
		}
		
		dado.salvar(client.getNome());
		dado.salvar(client.getTelefone());
		dado.salvar(client.getEndereco());
		dado.salvar("---");
		for(int i=0;i < client.getContasDoCliente().length;i++){
			Conta account = client.getContasDoCliente()[i];
			if(account!=null){
				dado.salvar(String.valueOf(account.getTipo()));
				dado.salvar(account.getnConta());
				dado.salvar(String.valueOf(account.getSaldo()));
				if(account.getTipo() == 0)
					dado.salvar(String.valueOf(((Corrente)account).getLimite()));
				else
					dado.salvar(String.valueOf(((Poupanca)account).getTaxaDeRendimento()));
				
				dado.salvar("---");
			}
		}
	}
	
	public Cliente getCliente(int codCliente){
		for(int i=0;i<listCliente.size();i++)
			if(listCliente.get(i).getCodCliente() == codCliente)
				return listCliente.get(i);
		
		return null;
	}
	
	public Conta getConta(String nConta){
		for(int i=0;i<listConta.size();i++)
			if(listConta.get(i).getnConta().equals(nConta))
				return listConta.get(i);
		
		return null;
	}
	

	

}
