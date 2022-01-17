package it.univpm.ProjectOOP.model.filtres;

import it.univpm.ProjectOOP.model.Date;

/**
 * Questa classe si occupa di descrivere un presiso 
 * intervallo di tempo (data iniziale e finale) filtrato 
 * dall'utente, in numero minimo/massimo/medio di eventi 
 * divisi per i giorni di quel dato intervallo
 * 
 * @author Merelli Leonardo
 */
public class PeriodPerFiltres 
{
	private Date startDate;
	private Date endDate;
	private int numMinPerDate;
	private int numMaxPerDate;
	private float numMedPerDate;
	
	/**
	 * Costruttore di default
	 */
	public PeriodPerFiltres() {}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getNumMinPerDate() {
		return numMinPerDate;
	}

	public void setNumMinPerDate(int numMinPerDate) {
		this.numMinPerDate = numMinPerDate;
	}

	public int getNumMaxPerDate() {
		return numMaxPerDate;
	}

	public void setNumMaxPerDate(int numMaxPerDate) {
		this.numMaxPerDate = numMaxPerDate;
	}

	public float getNumMedPerDate() {
		return numMedPerDate;
	}

	public void setNumMedPerDate(float numMedPerDate) {
		this.numMedPerDate = numMedPerDate;
	}
}
