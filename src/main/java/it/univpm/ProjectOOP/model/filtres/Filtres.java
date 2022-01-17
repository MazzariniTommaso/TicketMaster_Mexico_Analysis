 package it.univpm.ProjectOOP.model.filtres;

/**
 * Questa classe si occupa di descrivere 
 * tre oggetti differenti:
 * - StatePerFiltres
 * - GenrePerFiltres
 * - PeriodPerFiltres
 * 
 * @author Merelli Leonardo
 */
public class Filtres 
{
	private StatePerFiltres state;
	private GenrePerFiltres genre;
	private PeriodPerFiltres period;
	
	/**
	 * Costruttore di default
	 */
	public Filtres() {}

	public StatePerFiltres getState() {
		return state;
	}

	public void setState(StatePerFiltres state) {
		this.state = state;
	}

	public GenrePerFiltres getGenre() {
		return genre;
	}

	public void setGenre(GenrePerFiltres genre) {
		this.genre = genre;
	}

	public PeriodPerFiltres getPeriod() {
		return period;
	}

	public void setPeriod(PeriodPerFiltres period) {
		this.period = period;
	}
	
}
