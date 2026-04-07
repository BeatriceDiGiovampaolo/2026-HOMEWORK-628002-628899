package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {
	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine","prendi","posa"};

	private Partita partita;
	private Stanza stanzaCorrente;
	private Labirinto labirinto;
	private IOConsole ioconsole;

	public DiaDia(IOConsole console) {
		this.labirinto= new Labirinto();
		this.partita = new Partita(labirinto.getStanzaCorrentelab(),labirinto.getStanzaVincentelab());
		this.ioconsole= console; //aggiunto
	}

	public void gioca() {
		String istruzione; 
		ioconsole.mostraMessaggio(MESSAGGIO_BENVENUTO);	
		do		
			istruzione = ioconsole.leggiriga();
		while (!processaIstruzione(istruzione));
	}   

	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);
		if(comandoDaEseguire.getNome()==null) return false; //caso anomalo aggiunto dal prof in classe
		
		if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true;
		} else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro());
		else if(comandoDaEseguire.getNome().equals("prendi"))
			this.prendi(comandoDaEseguire.getParametro());
		else if(comandoDaEseguire.getNome().equals("posa"))
			this.lascia(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();
		else
			ioconsole.mostraMessaggio("Comando sconosciuto");
		if (this.partita.vinta()) {
			ioconsole.mostraMessaggio("Hai vinto!");
			return true;
		} 
		else
			return false;
	}   

	// implementazioni dei comandi dell'utente:
	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			ioconsole.mostraMessaggio(elencoComandi[i]+" ");
		ioconsole.mostraMessaggio("");
	}
	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null) {
			ioconsole.mostraMessaggio("Dove vuoi andare ?");
			return;
		}
			
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			ioconsole.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getGiocatore().getCfu();
			this.partita.getGiocatore().setCfu(cfu-1);
		}
		ioconsole.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
	}

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		ioconsole.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}
	
	//comando prendi
	public void prendi(String nomeAttrezzo) {
		if(nomeAttrezzo==null) {
			ioconsole.mostraMessaggio("Che attrezzo vuoi prendere?");
			return;
		}
		stanzaCorrente = this.partita.getStanzaCorrente();
		if(stanzaCorrente.hasAttrezzo(nomeAttrezzo)) {

			Attrezzo attrezzo=stanzaCorrente.getAttrezzo(nomeAttrezzo);
			Borsa borsa=this.partita.getGiocatore().getBorsa();
			
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
	
	//comando lascia 
	public void lascia(String nomeAttrezzo) {
		if(nomeAttrezzo==null) {
			ioconsole.mostraMessaggio("Che attrezzo vuoi lasciare?");
			return;
		}
		stanzaCorrente = this.partita.getStanzaCorrente();
		Borsa borsa=this.partita.getGiocatore().getBorsa();
		
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
	
	public static void main(String[] argc) {
		IOConsole console=new IOConsole();
		DiaDia gioco = new DiaDia(console);
		gioco.gioca();
		
	}
}