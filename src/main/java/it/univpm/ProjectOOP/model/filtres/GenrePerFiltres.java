package it.univpm.ProjectOOP.model.filtres;

import java.util.List;

/**
 * Questa classe si occupa di descrivere una lista 
 * di nomi che descrivono i vari generi filtrati 
 * dall'utente, in numero minimo/massimo/medio di eventi 
 * divisi per genere
 * 
 * @author Merelli Leonardo
 */
public class GenrePerFiltres 
{
	private List<String> genreList;
	private int numMinPerGenre;
	private int numMaxPerGenre;
	private float numMedPerGenre;
	
	/**
	 * Costruttore di default
	 */
	public GenrePerFiltres() {}

	public List<String> getGenreList() {
		return genreList;
	}

	public void setGenreList(List<String> genreList) {
		this.genreList = genreList;
	}

	public int getNumMinPerGenre() {
		return numMinPerGenre;
	}

	public void setNumMinPerGenre(int numMinPerGenre) {
		this.numMinPerGenre = numMinPerGenre;
	}

	public int getNumMaxPerGenre() {
		return numMaxPerGenre;
	}

	public void setNumMaxPerGenre(int numMaxPerGenre) {
		this.numMaxPerGenre = numMaxPerGenre;
	}

	public float getNumMedPerGenre() {
		return numMedPerGenre;
	}

	public void setNumMedPerGenre(float numMedPerGenre) {
		this.numMedPerGenre = numMedPerGenre;
	}
}
