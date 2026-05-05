package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public interface Comandointerfaccia {
	public void esegui(Partita partita);
	public void setParametro(String parametro); 
	public void getNome(String nome); 
	public void getParametro(String parametro); 
	public void setIO(IO console);
}
