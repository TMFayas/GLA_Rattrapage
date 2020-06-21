package couchedepersistance;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.swing.ImageIcon;

@PersistenceCapable
public class Film {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.NATIVE)
	private int id;
	
	private String name;
	private String synopsis;
	private ImageIcon photo;
	private LocalDate release_date;
	private List<Critique> critiques;
	
	public Film() {
		name ="";
		synopsis = "";
		release_date = LocalDate.now();
		critiques = new ArrayList<Critique>();
		
	}
	
	public Film(String nom, String resume, LocalDate date_sortie) {
		name = nom;
		synopsis = resume;
		release_date = date_sortie;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public ImageIcon getPhoto() {
		return photo;
	}

	public void setPhoto(ImageIcon photo) {
		this.photo = photo;
	}

	public LocalDate getRelease_date() {
		return release_date;
	}

	public void setRelease_date(LocalDate release_date) {
		this.release_date = release_date;
	}

	public List<Critique> getCritiques() {
		return critiques;
	}

	public void setCritiques(List<Critique> critiques) {
		this.critiques = critiques;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String toString() {
		return ""+this.name+"\n";
	}
	
	
	
	
	

}
