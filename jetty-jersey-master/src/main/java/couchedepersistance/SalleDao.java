package couchedepersistance;

import java.util.List;

public interface SalleDao {
	
	List<Salle> getAllSalles();
	
	List<Integer> getAllFilm(int id);
	
	void setName(String name,int id);
	
	void setAddress(String address, int id);
	
	void setFilm(List<Integer> film, int id);
	
	void addSalle(String name, String address, List<Integer> film);
	
	void deleteSalle(int id);

}
