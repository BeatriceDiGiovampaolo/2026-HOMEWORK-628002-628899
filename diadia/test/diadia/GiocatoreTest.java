package diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.giocatore.Giocatore;

class GiocatoreTest {
	private Giocatore giocatore; 
	
	@BeforeEach
	public void setUp() {
		giocatore = new Giocatore(); 
	}
	
	@Test
	public void testsetCfu() {
		giocatore.setCfu(5); 
		assertEquals(5, giocatore.getCfu());
	}
	
	@Test
	public void testgetCfu() {
		assertEquals(20,giocatore.getCfu());
	}
	
	@Test
	public void memorizzaAttrezziTest(){
		Borsa borsa= new Borsa(); 
		giocatore.memorizzaAttrezzi(borsa); 
		assertNotNull(borsa); 
	}
	
}
