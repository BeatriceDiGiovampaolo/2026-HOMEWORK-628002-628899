package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoFine implements Comandointerfaccia {
	private IO ioconsole; 
	
	@Override
	public void setIO(IO console) {
		this.ioconsole = console;
	}
	
	@Override
	public void esegui(Partita partita) {
		ioconsole.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}
	
	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
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
