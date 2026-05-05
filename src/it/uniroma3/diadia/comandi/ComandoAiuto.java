package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comandointerfaccia{
	private IO ioconsole;
	static final private String[] elencoComandi = {"vai", "aiuto", "fine","prendi","posa"};

	@Override
	public void setIO(IO console) {
		this.ioconsole = console;
	}
	
	@Override
	public void esegui(Partita partita) {
		for(int i=0; i< elencoComandi.length; i++) 
			ioconsole.mostraMessaggio(elencoComandi[i]+" ");
		ioconsole.mostraMessaggio("");
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
