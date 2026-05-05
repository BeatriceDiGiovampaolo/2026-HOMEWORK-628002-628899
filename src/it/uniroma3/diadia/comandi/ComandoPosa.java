package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPosa implements Comandointerfaccia {
	private IO ioconsole;
	String nomeAttrezzo; 
	Stanza stanzaCorrente; 
	
	public ComandoPosa(String nomeAttrezzo) {
		this.nomeAttrezzo = nomeAttrezzo;
	}
	@Override
	public void setIO(IO console) {
		this.ioconsole = console;
	}
	
	
	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		if(nomeAttrezzo==null) {
			ioconsole.mostraMessaggio("Che attrezzo vuoi lasciare?");
			return;
		}
		stanzaCorrente = partita.getStanzaCorrente();
		Borsa borsa=partita.getGiocatore().getBorsa();
		
		if(borsa.hasAttrezzo(nomeAttrezzo)) {
			Attrezzo attrezzo=borsa.getAttrezzo(nomeAttrezzo);
			if(stanzaCorrente.addAttrezzo(attrezzo)) {
				borsa.removeAttrezzo(nomeAttrezzo);
				ioconsole.mostraMessaggio("Hai posato: "+ attrezzo.getNome());
			}
			else {
				ioconsole.mostraMessaggio("Non c'è più spazio in questa stanza per posare: "+ attrezzo.getNome());
			}
		}
		else {
			ioconsole.mostraMessaggio("Non c'è questo attrezzo nella borsa");
		}
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		this.nomeAttrezzo=parametro; 
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
