package Brainiac;

import java.util.ArrayList;

public class Camada {
	private ArrayList<Neuronio> neuronios;
	private int quantidadeNeuronios;

	public static final int ENTRADA = 0;
	public static final int OCULTA = 1;
	public static final int SAIDA = 2;

	public Camada(){}

	public Camada(int quantidadeNeuronios, int tipoCamada, int funcaoAtivacao){
		this.quantidadeNeuronios = quantidadeNeuronios;
		neuronios = new ArrayList<Neuronio>();
		Neuronio n;
		for (int i = 0; i < quantidadeNeuronios; i++) {
			n = new Neuronio(tipoCamada, funcaoAtivacao);
			this.neuronios.add(n);
		}
	}

	public void print(){
		System.out.println("\tQuantidade de neurônios: " + quantidadeNeuronios);
		for (int i = 0; i < quantidadeNeuronios; i++) {
			System.out.println("\tNeurônio " + i + ": ");
			neuronios.get(i).print();
		}
	}

	public int getTamanhoCamada(){
		return this.quantidadeNeuronios;
	}

	public ArrayList<Neuronio> getNeuronios(){
		return this.neuronios;
	}

	public void setNeuronios(ArrayList<Neuronio> neuronios){
		this.neuronios = neuronios;
	}

	public Neuronio getNeuronio(int i){
		return this.neuronios.get(i);
	}

	public void setNeuronio(Neuronio neuronio, int i){
		this.neuronios.set(i, neuronio);
	}
}
