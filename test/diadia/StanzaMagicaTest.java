package diadia;



import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.ambienti.StanzaMagica;
import it.uniroma3.diadia.attrezzi.Attrezzo;



class StanzaMagicaTest {

	private StanzaMagica s; 
	private Attrezzo a1; 
	private Attrezzo a2; 
	private Attrezzo a3; 
	private Attrezzo a4; 

	

	@BeforeEach
	public void setUp() {
		s = new StanzaMagica("elisa"); 
		a1= new Attrezzo("chiave", 2);
		a2= new Attrezzo("seve", 6);
		a3= new Attrezzo("vali", 10);
		a4= new Attrezzo("evvai", 100);
	}

	@Test
	void testaddattrezzo1() {
		s.addAttrezzo(a1); 
		assertEquals("chiave", s.getAttrezzo("chiave").getNome());
	}

	@Test
	void testaddattrezzo2() {
		s.addAttrezzo(a1); 
		s.addAttrezzo(a2);
		s.addAttrezzo(a3);
		s.addAttrezzo(a4); 
		assertEquals("iavve", s.getAttrezzo("iavve").getNome());
		assertEquals(200, s.getAttrezzo("iavve").getPeso());
	}


}