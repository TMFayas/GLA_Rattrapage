package couchedepersistance;

public interface CritiqueDao {
	
	Critique getCritique (int id);
	
	void addCritique(Spectateur s, String Description, int note);

}
