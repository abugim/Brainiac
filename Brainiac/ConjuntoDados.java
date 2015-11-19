package Brainiac;

import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.BufferedReader;

public class ConjuntoDados{
	private ArrayList<Amostra> amostras;
	private int contadorDados;

	public ConjuntoDados(){
		this.amostras = new ArrayList<Amostra>();
		this.contadorDados = 0;
	}

	public void carregarDados(String caminho, int quantidadeEntradas){
		try{
			File fonte = new File(caminho);
			if (!fonte.exists() || !fonte.isFile()){
				return;
			}

			FileReader leitor = new FileReader(fonte);
			BufferedReader bufferLeitura = new BufferedReader(leitor);

			String linha = null, dados[];
			Amostra amostra;
			while(bufferLeitura.ready()){
				linha = bufferLeitura.readLine();
				dados = linha.split("\t");
				amostra = new Amostra(quantidadeEntradas);
				for (int i = 0; i < quantidadeEntradas; i++){
					amostra.setEntrada(i, Double.valueOf(dados[i]));
				}
				amostras.add(amostra);
			}

			bufferLeitura.close();
			leitor.close();
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
	}

	public Amostra proximaAmostra(){
		return amostras.get(contadorDados++);
	}

	public void resetarContador(){
		contadorDados = 0;
	}

	public boolean terminado(){
		return (contadorDados < amostras.size());
	}
}
