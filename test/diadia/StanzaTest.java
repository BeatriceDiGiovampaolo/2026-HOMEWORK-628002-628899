package diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;


import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {
	private Stanza stanza; 
	private Attrezzo attrezzo; 
	static final private int NUMERO_MASSIMO_ATTREZZI = 10;
	@BeforeEach
	void setUp() {
		stanza = new Stanza("s1"); 
		attrezzo = new Attrezzo("martello", 3); 
	}
	
	
	@Test
	public void testaddAttrezzovero() {
		stanza.addAttrezzo(attrezzo);
		assertTrue(stanza.addAttrezzo(attrezzo)); 
	}
	
	@Test
	public void testaddAttrezzofalsotroppiattrezzi() {
		for(int i=0; i<NUMERO_MASSIMO_ATTREZZI; i++) {
			stanza.addAttrezzo(new Attrezzo("attrezzo"+i, 1));
		}
		assertFalse(stanza.addAttrezzo(attrezzo)); 
	}
	
	@Test
	public void testhasAttrezzovero() {
		stanza.addAttrezzo(attrezzo);
		assertTrue(stanza.hasAttrezzo(attrezzo.getNome())); 
	}
	
	@Test
	public void testhasAttrezzofalso() {
		assertFalse(stanza.hasAttrezzo(attrezzo.getNome())); 
	}
	
	@Test
	public void testremoveAttrezzovero(){
		stanza.addAttrezzo(attrezzo);
		assertTrue(stanza.removeAttrezzo(attrezzo)); 
	}
	
	@Test
	public void testremoveAttrezzofalso() {
		assertFalse(stanza.removeAttrezzo( attrezzo)); 
	}
}
