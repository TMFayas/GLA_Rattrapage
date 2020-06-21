package couchedepersistance;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Planning {
	private Salle salle;
	private Film film;
	private List<LocalDateTime> planning;
	
	public Planning() {
		salle = new Salle();
		film = new Film();
		planning = new ArrayList<LocalDateTime>();
	}
	
	public Planning(Salle s, Film f, List<LocalDateTime> p ) {
		salle = s;
		film = f;
		planning = p;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public List<LocalDateTime> getPlanning() {
		return planning;
	}

	public void setPlanning(List<LocalDateTime> planning) {
		this.planning = planning;
	}
	
	

}
