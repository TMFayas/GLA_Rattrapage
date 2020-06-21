package couchedepersistance;

public interface SpectateurDao {
	
	String getSpectateurName(int id);
	
	void addSpectateur(String name, String password);
	
	

}
