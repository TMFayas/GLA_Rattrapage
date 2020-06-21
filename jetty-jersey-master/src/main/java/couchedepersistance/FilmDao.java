package couchedepersistance;

import java.time.LocalDate;
import java.util.List;

public interface FilmDao {

	//Get all the films from the database
	List<Film> getAllFilm();
	//Get film details
	Film getFilm(int id);
	
	void setName(String name, int id);
	
	void setSynopsis(String synopsis, int id);
	
	void setCritiques(List<Critique> critiques, int id);
	
	void addFilm(String name, String synopsis, LocalDate release);
	
	void deleteFilm(int id);
	
	
}

