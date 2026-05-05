package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccata extends Stanza{
	private String direzionebloccata; 
	private String oggettoSblocca; 
	
		public StanzaBloccata(String nome, String direzione, String oggetto) {
		super(nome);
		this.direzionebloccata=direzione; 
		this.oggettoSblocca=oggetto; 
	}
		
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if(direzione.equals(this.direzionebloccata)&& !this.hasAttrezzo(oggettoSblocca)) return this; 
		return super.getStanzaAdiacente(direzione); 
	}
	
	@Override 
	public String getDescrizione(){
		if(direzionebloccata== null || (direzionebloccata!=null && this.hasAttrezzo(oggettoSblocca))) 
				return this.toString(); 
		else {
			StringBuilder risultato = new StringBuilder();
	    	risultato.append(this.getNome());
	    	risultato.append("\nUscite: ");
	    	for (String direzione : this.getDirezioni())
	    		if (direzione!=null && direzione!=direzionebloccata)
	    			risultato.append(" " + direzione);
	    	risultato.append("\nAttrezzi nella stanza: ");
	    	for (Attrezzo attrezzo : this.getAttrezzi()) {
	    		if(attrezzo!=null) 													
	    		risultato.append(attrezzo.toString()+" ");
	    	}
	    	return risultato.toString();
		}
	}


}
