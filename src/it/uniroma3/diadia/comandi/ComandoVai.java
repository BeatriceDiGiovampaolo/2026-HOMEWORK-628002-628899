package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;


public class ComandoVai implements Comandointerfaccia{
	private IO ioconsole; 
	private String direzione;
	

	public ComandoVai(String direzione) {
	this.direzione = direzione;
	}
	
	@Override
	public void setIO(IO console) {
		this.ioconsole = console; 
	}
	/**
	* esecuzione del comando
	*/
	@Override
	public void esegui(Partita partita) {
		Stanza stanzacorrente=partita.getStanzaCorrente(); 
		Stanza prossimastanza = null; 
		if(direzione==null) {
			ioconsole.mostraMessaggio("dove vuoi andare? devi secificare una direzione"); 
			return; 
		}
		prossimastanza= stanzacorrente.getStanzaAdiacente(this.direzione); 
		if(prossimastanza==null) {
			ioconsole.mostraMessaggio("Direzione Inesistente"); 
			return; 
		}
		partita.setStanzaCorrente(prossimastanza);
		ioconsole.mostraMessaggio(partita.getStanzaCorrente().getNome()); 
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
	}
	
	@Override
	public void setParametro(String parametro) {
		this.direzione=parametro; 
	}

	@Override
	public void getNome(String nome) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getParametro(String parametro) {
		// TODO Auto-generated method stub
		
	}
}
