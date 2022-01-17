package it.univpm.ProjectOOP.model.filtres;

import java.util.List;

/**
 * Questa classe si occupa di descrivere una lista 
 * di nomi che descrivono i vari stati filtrati 
 * dall'utente, in numero minimo/massimo/medio di eventi 
 * divisi per stato
 * 
 * @author Merelli Leonardo
 */
public class StatePerFiltres 
{
	private List<String> stateList;
	private int numMinPerState;
	private int numMaxPerState;
	private float numMedPerState;
	
	/**
	 * Costruttore di default
	 */
	public StatePerFiltres() {}

	public List<String> getStateList() {
		return stateList;
	}

	public void setStateList(List<String> stateList) {
		this.stateList = stateList;
	}

	public int getNumMinPerState() {
		return numMinPerState;
	}

	public void setNumMinPerState(int numMinPerState) {
		this.numMinPerState = numMinPerState;
	}

	public int getNumMaxPerState() {
		return numMaxPerState;
	}

	public void setNumMaxPerState(int numMaxPerState) {
		this.numMaxPerState = numMaxPerState;
	}

	public float getNumMedPerState() {
		return numMedPerState;
	}

	public void setNumMedPerState(float numMedPerState) {
		this.numMedPerState = numMedPerState;
	}
	
}
