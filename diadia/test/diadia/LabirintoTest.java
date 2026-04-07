package diadia;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

class LabirintoTest {	
	private Stanza atrio; 
	private Stanza biblioteca; 
	@BeforeEach
	public void setUp(){
		Labirinto lab = new Labirinto(); 
		atrio = lab.getStanzaCorrentelab(); 
		biblioteca = lab.getStanzaVincentelab(); 
	}
	
	@Test
	public void testgetStanzaIniziale() {
		assertNotNull(atrio); 
	}
	
	@Test
	public void testgetStanzaVincente() {
		assertNotNull(biblioteca); 
	}
}
