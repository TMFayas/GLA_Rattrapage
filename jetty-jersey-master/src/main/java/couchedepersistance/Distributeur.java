package couchedepersistance;

import java.util.ArrayList;
import java.util.List;

public class Distributeur extends Spectateur {

	private boolean status; // true = valide false = non valide
	private List<Film> added_film;
	
	public Distributeur() {
		status = false;
		added_film = new ArrayList<Film>();
		
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public List<Film> getAdded_film() {
		return added_film;
	}

	public void setAdded_film(List<Film> added_film) {
		this.added_film = added_film;
	}
	
	
	
}
