package it.uniroma3.diadia.giocatore;

public class Giocatore {
	public static final int CFU_INIZIALI = 20;
	private int cfu; 
	private Borsa borsa;  
	public Giocatore() {
		this(CFU_INIZIALI); 
	}
	public Giocatore(int cfu) {
		this.cfu=cfu; 
		this.borsa= new Borsa();
	}

	public int getCfu() {
		return this.cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}	
	public void memorizzaAttrezzi(Borsa borsa){
		this.borsa=borsa; 
	}
	
	public Borsa getBorsa() {
		return this.borsa;
	}
}
