package ressource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import couchedepersistance.FIlmDaoImpl;
import couchedepersistance.Film;
import couchedepersistance.Salle;
import couchedepersistance.SalleDaoImpl;

@Path("/salles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SalleRessource {
	
	private SalleDaoImpl Database = new SalleDaoImpl();
	private FIlmDaoImpl Database_film = new FIlmDaoImpl();
	//GET
	@GET
	public List<Salle> getAllFilms(){
		return Database.getAllSalles();
	}
	
	@Path("/{salle_id}/films")
	@GET
	public List<Film> getFilms(@PathParam("salle_id") int id){
		List<Integer> film_id = Database.getAllFilm(id);
		System.out.println(film_id);
		List<Film> res = new ArrayList<Film>();
		for(int id_film : film_id) {
			res.add(Database_film.getFilm(id_film));
		}
		return res;
	}
	
	
	

}
