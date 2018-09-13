package model;

public abstract class Ingresso {
	protected final double precoNormal = 100;
	protected Cadeira cadeira;
	private static int quantidade = 200;
	
	public Ingresso(Cadeira cadeira){
		this.cadeira = cadeira;
		Ingresso.quantidade --;
	}
	
	public Cadeira getCadeira(){
		return cadeira;
	}
	
	public abstract double getValor();

	public static int getQuantidade() {
		return quantidade;

	}
}