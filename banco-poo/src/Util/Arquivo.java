package Util;

	
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Arquivo  {
	private File arquivo;
	
	private FileWriter fw ;
	private BufferedWriter bw;
	private FileReader fr;
	private BufferedReader br;

	/**
	 * 
	 * @param nome - Nome do arquivo ou caminho com nome do arquivo
	 * @throws IOException
	 */
	public Arquivo(String nome)throws IOException{		
		arquivo = new File(nome);
	
		fw = new FileWriter(arquivo, true);
		bw = new BufferedWriter(fw);
		fr = new FileReader(arquivo);
		br = new BufferedReader(fr);

		arquivo.createNewFile();			
		
		fw.close();
		bw.close();
	}


	/**
	 * Cria o arquivo caso não exista o arquivo.
	 * @throws IOException
	 */
	public void criaArquivo() throws IOException{
		if(!arquivo.exists()){
			arquivo.createNewFile();
		}
	}
	
	public void reCriaArquivo() throws IOException{
		arquivo.delete();
		arquivo.createNewFile();
	}
	
	/**
	 * Retorna o File utilizado no arquivo
	 * @return File
	 */
	public File getFile(){
		return arquivo;
	}

	/**
	 * Salva uma String e automaticamente quebra linha
	 * @param texto - String do que se deseja salvar
	 * @throws IOException
	 */
	public void salvar(String texto)throws IOException{
		FileWriter fw = new FileWriter(arquivo, true);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(texto);
		bw.newLine();
		bw.close();
		fw.close();
	}
	
	/**
	 * Reinicia o ponteiro de leitor do arquivo
	 * @throws IOException
	 */
	public void reset() throws IOException{
		br.close();
		fr.close();
		this.fr = new FileReader(arquivo);
		this.br = new BufferedReader(fr);

	}
	

	
	/**
	 * Carrega uma linha do arquivo e aponta pra próxima linha
	 * @return Linha do arquivo
	 * @throws IOException
	 */
	public String carregar() throws IOException{
		if(NEOF()){
			return br.readLine();
		}else{
			reset();
		return 	br.readLine();
		}		
	}

	/**
	 * Not End Of File
	 * @return
	 * @throws IOException
	 */
	public boolean NEOF() throws IOException{
		return br.ready();
	}
	
	/**
	 * Fecha o Arquivo
	 * @throws IOException
	 */
	public void fecha() throws IOException{
		br.close();
		fr.close();
	}
	
	/**
	 * Limpa o Arquivo
	 * @throws IOException
	 */
	public void deletarArquivo() throws IOException{
		FileWriter fw = new FileWriter(arquivo, false);
		BufferedWriter bw = new BufferedWriter(fw);
		fw.close();
		bw.close();
	}

	
}