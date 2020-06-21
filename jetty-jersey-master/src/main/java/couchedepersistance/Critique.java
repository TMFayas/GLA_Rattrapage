package couchedepersistance;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

public class Critique {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.NATIVE)
	private int id;
	
	private Spectateur author;
	private String description;
	private Integer note;
	
	public Critique() {
		author = new Spectateur();
		description ="";
		note = 0;
	}

	public Critique(Spectateur auteur, String desc, Integer note) {
		author = auteur;
		description = desc;
		this.note = note;
	}

	public Spectateur getAuthor() {
		return author;
	}

	public void setAuthor(Spectateur author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getNote() {
		return note;
	}

	public void setNote(Integer note) {
		this.note = note;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
