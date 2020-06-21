package ressource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import couchedepersistance.*;

@Path("/films")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FilmRessource {
	private FIlmDaoImpl Database = new FIlmDaoImpl();
	//GET
	@GET
	public List<Film> getAllFilms(){
		return Database.getAllFilm();
	}
	
	@Path("/{film_id}")
	@GET
	public Film getFilmDetail(@PathParam("film_id") int id) {
		return Database.getFilm(id);
	}
	
	@Path("/{film_id}/name")
	@POST
	public void setFilmName(@PathParam("film_id") int id, String name) {
		Database.setName(name, id);
	}
	
	@Path("/{film_id}/synopsis")
	@POST
	public void setFilmSynopsis(@PathParam("film_id") int id, String synopsis) {
		Database.setSynopsis(synopsis, id);
	}
	
	
	
	
	
	

}
