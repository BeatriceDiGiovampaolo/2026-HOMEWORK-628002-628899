package diadia;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach; 
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

public class PartitaTest {
	private Partita partita; 
	private Stanza stanza1; 
	private Stanza stanzaVincente; 
	
	@BeforeEach 
	public void setUp() {
		stanza1 = new Stanza("s1"); 
		stanzaVincente = new Stanza("sv"); 
		partita = new Partita(stanza1, stanzaVincente); 
	}
	
	
	@Test
	public void testvintafalso() {
		assertFalse(partita.vinta());
	}
	
	@Test
	public void testvintavero() {
		partita.setStanzaCorrente(stanzaVincente);
		assertTrue(partita.vinta());
	}
	
	@Test
	public void testisFinitafalso() {
		assertFalse(partita.isFinita());
	}
	
	@Test
	public void testisFinitaveropervittoria() {
		partita.setStanzaCorrente(stanzaVincente);
		assertTrue(partita.isFinita());
	}
	
	@Test
	public void testisFinitaveroperCFU() {
			Giocatore giocatore = partita.getGiocatore();
		    giocatore.setCfu(0);
		    assertTrue(partita.isFinita());
	}
	
	@Test
	public void testisFinitaveroperfinita() {
		partita.setFinita();
		assertTrue(partita.isFinita());

	}
	
}
