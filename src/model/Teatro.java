package model;

import javax.swing.JOptionPane;

public class Teatro {
	private final int fileiras = 10;
	private final int cadeiras = 20;
	private Cadeira[] assentos;
	
	public Teatro(){
		int posicao;
		
		assentos = new Cadeira[tamanhoTeatro()];
		
		posicao = 0;
		for(int i = 1; i <= fileiras; i++){
			for(int j = 1; j <= cadeiras; j++){
				assentos[posicao] = new Cadeira(i, j);
				posicao +=1;
			}
		}
	}
	
	public boolean vender(int fila, int assento){
		Cadeira cadeira;
		boolean deuCerto = false;

		cadeira = buscaCadeira(fila, assento);
		if(cadeira != null) {
			if(cadeira.estaLivre()){
				cadeira.ocupar();
				deuCerto = true;
			}
		}
		return deuCerto;

	}
	
	public Cadeira buscaCadeira(int fila, int assento){
		Cadeira cadeira = null;
		int i = 0;
		while(cadeira == null && i < tamanhoTeatro()){
			if(assentos[i].getFileira() == fila){
				if(assentos[i].getAssento() == assento){
					cadeira = assentos[i];
				}
			}
			i++;
		}
		return cadeira;
	}
	
	public int tamanhoTeatro(){
		int tamanho;
		tamanho = fileiras * cadeiras;
		return(tamanho);
	}
	
	public int fileiraValida() {
		int fileira = 0;
		while((fileira > fileiras) || (fileira < 1)) {
			fileira = Integer.parseInt(JOptionPane.showInputDialog("Digite uma fileira entre 1 e "+fileiras));
		}
		return fileira;
	}
	
	public int assentoValida() {
		int assento = 0;
		while((assento > cadeiras) || (assento < 1)) {
			assento = Integer.parseInt(JOptionPane.showInputDialog("Digite um assento entre 1 e "+cadeiras));
		}
		return assento;
	}
}
