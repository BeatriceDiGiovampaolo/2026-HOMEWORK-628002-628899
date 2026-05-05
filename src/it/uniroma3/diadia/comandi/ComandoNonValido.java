package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoNonValido implements Comandointerfaccia {
	private IO console; 
	
	@Override
	public void setIO(IO console) {
		this.console = console;
	}
	
	private Comandointerfaccia comando; 
	@Override
	public void esegui(Partita partita) {
		console.mostraMessaggio("Comando non valido, ti do aiuto!"); 
		comando = new ComandoAiuto();
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
