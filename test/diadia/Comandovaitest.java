package diadia;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.comandi.ComandoVai;

class Comandovaitest {
	private Partita p; 
	private Stanza corrente; 
	private Stanza successiva; 
	private ComandoVai comando; 
	
	@BeforeEach
	public void setUp() {
		corrente = new Stanza("Atrio"); 
		successiva = new Stanza("biblioteca"); 
		p = new Partita(corrente, successiva);
		corrente.impostaStanzaAdiacente("nord", successiva);
		p.setStanzaCorrente(corrente);	
	}
	
	@Test
	void testDirezioneNull() {
		comando = new ComandoVai(null);
		IOConsole console = new IOConsole(); 
		comando.setIO(console);
		comando.esegui(p);
		assertEquals(corrente, p.getStanzaCorrente()); 
		assertEquals(20, p.getGiocatore().getCfu()); 
	}
	
	@Test
	void testDirezioneInesistente() {
		comando = new ComandoVai("sud");
		IOConsole console = new IOConsole(); 
		comando.setIO(console);
		comando.esegui(p);
		assertEquals(corrente, p.getStanzaCorrente()); 
		assertEquals(20, p.getGiocatore().getCfu()); 
	}
	
	@Test
	void testDirezioneValida() {
		comando = new ComandoVai("nord");
		IOConsole console = new IOConsole(); 
		comando.setIO(console);
		comando.esegui(p);
		assertEquals(successiva, p.getStanzaCorrente()); 
		assertEquals(19, p.getGiocatore().getCfu()); 
	}

}
