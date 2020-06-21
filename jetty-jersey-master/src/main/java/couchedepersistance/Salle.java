package couchedepersistance;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Salle {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.NATIVE)
	private int id;
	private String name;
	private String address;
	private List<Integer> films;
	
	public Salle() {
		name ="";
		address ="";
		films = new ArrayList<Integer>();
		
	}
	
	public Salle(String nom, String adresse, List<Integer> film) {
		name = nom;
		address = adresse;
		films = film;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Integer> getFilms() {
		return films;
	}

	public void setFilms(List<Integer> films) {
		this.films = films;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
