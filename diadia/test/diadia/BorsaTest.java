package diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

class BorsaTest {
	private Borsa borsa; 
	private Attrezzo martello; 
	
	@BeforeEach
	public void setUp() {
		borsa = new Borsa();
		martello = new Attrezzo("martello", 3); 
	}
	
	@Test
	public void testaddAttrezzoVero(){
		assertTrue(borsa.addAttrezzo(martello));
	}

	@Test
	public void testaddAttrezzoFalsoperPeso(){
		Borsa borsa=new Borsa(2); 
		Attrezzo pesante = new Attrezzo("incudine", 5); 
		assertFalse(borsa.addAttrezzo(pesante));
	}
	
	@Test
	public void testaddAttrezzoFalsopeNumeroAttrezzi(){
		Borsa borsa=new Borsa(10);
		for( int i=0; i<10; i++) {
			Attrezzo attrezzo = new Attrezzo("a"+i, 1); 
			borsa.addAttrezzo(attrezzo); 
		}
		assertFalse(borsa.addAttrezzo(martello));
	}
	
	
	@Test
	public void testPesomassimo() {
		assertEquals(10, borsa.getPesoMax()); 
	}
	
	@Test
	public void TestgetAttrezzo() {
		borsa.addAttrezzo(martello); 
		assertEquals(martello, borsa.getAttrezzo("martello")); 
	}
	
	@Test
	public void TestgetAttrezzononrestituito() {
		assertNull(borsa.getAttrezzo("martello")); 
	}
	
	@Test
	public void testPesoZero() {
		assertEquals(0, borsa.getPeso()); 
	}
	
	@Test
	public void testPesoMartello() {
		borsa.addAttrezzo(martello); 
		assertEquals(3, borsa.getPeso()); 
	}
	
	@Test
	public void testIsEmptyVero() {
		assertTrue(borsa.isEmpty()); 
	}

	@Test
	public void testIsEmptyFalso() {
		borsa.addAttrezzo(martello); 
		assertFalse(borsa.isEmpty()); 
	}
	
	@Test
	public void testhasAttrezzoFalso() {
		assertFalse(borsa.hasAttrezzo("martello")); 
	}

	@Test
	public void testHasAttrezziVero() {
		borsa.addAttrezzo(martello); 
		assertTrue(borsa.hasAttrezzo("martello")); 
	}

	@Test
	public void TestremoveAttrezzo() {
		borsa.addAttrezzo(martello); 
		assertEquals(martello, borsa.removeAttrezzo("martello")); 
	}
	
	@Test
	public void TestremoveAttrezzoNull() {
		assertNull(borsa.removeAttrezzo("martello")); 
	}
	
	
}
