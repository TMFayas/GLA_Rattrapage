package couchedepersistance;

import java.time.LocalDateTime;
import java.util.List;

public interface PlanningDao {
	
	List<LocalDateTime> getPlanning(int id_salle, int id_film);
	
	void addPlanning(int id_salle, int id_film, List<LocalDateTime> planning);
	

}
