package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoPrendi implements Comandointerfaccia {
	private IO ioconsole; 
	private String nomeAttrezzo;
	private Stanza stanzaCorrente; 
	
	@Override
	public void setIO(IO console) {
		this.ioconsole = console;
	}
	
	public ComandoPrendi(String nomeAttrezzo) {
		this.nomeAttrezzo = nomeAttrezzo;
	}
	
	@Override
	public void esegui(Partita partita) {
			if(nomeAttrezzo==null) {
				ioconsole.mostraMessaggio("Che attrezzo vuoi prendere?");
				return;
			}
			stanzaCorrente = partita.getStanzaCorrente();
			if(stanzaCorrente.hasAttrezzo(nomeAttrezzo)) {

				Attrezzo attrezzo=stanzaCorrente.getAttrezzo(nomeAttrezzo);
				Borsa borsa=partita.getGiocatore().getBorsa();
				
				if(borsa.addAttrezzo(attrezzo)) {
					stanzaCorrente.removeAttrezzo(attrezzo);
					ioconsole.mostraMessaggio("Hai preso: "+ attrezzo.getNome());
				}
				else {
					ioconsole.mostraMessaggio("La borsa è troppo piena per prendere "+ attrezzo.getNome());
				}
			}
			else 
				ioconsole.mostraMessaggio("questo attrezzo non è presente nella stanza");
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
