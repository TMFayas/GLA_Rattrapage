package couchedepersistance;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

public class Spectateur {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.NATIVE)
	private int id;
	
	private String name;
	private String password;
	private String email;
	
	public Spectateur() {
		name = "";
		password ="";
		email ="";
	}
	
	public Spectateur(String nom, String motdepasse) {
		name = nom;
		password = motdepasse;
	}
	
	public Spectateur(String nom, String motdepasse, String email) {
		name = nom;
		password = motdepasse;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
}
