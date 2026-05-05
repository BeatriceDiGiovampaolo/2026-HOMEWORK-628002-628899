package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza {
	private String attrezzobuio; 
	
	public StanzaBuia(String nome, String nomeAttrezzo) {
		super(nome); 
		this.attrezzobuio=nomeAttrezzo; 
	}
	
	@Override
	public String getDescrizione(){
		if(this.hasAttrezzo(attrezzobuio)) 
			return this.toString();
		else {
			return "qui c'è buio pesto"; 
		}
	}
}
