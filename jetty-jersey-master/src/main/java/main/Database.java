package main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import couchedepersistance.Film;
import couchedepersistance.Salle;
import couchedepersistance.SalleDaoImpl;
import couchedepersistance.Spectateur;
import couchedepersistance.Critique;

@SuppressWarnings("unchecked")
public class Database {
	
	public static int addData (Object o, char classe) {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Example");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		int id = 0;
		try {
			tx.begin();
			switch (classe) {
				case 'F': 
					Film copy_film = pm.makePersistent((Film) o); 
					id = copy_film.getId();
					break;
				case 'S': 
					Salle copy_salle = pm.makePersistent((Salle) o); 
					id = copy_salle.getId();
					break;
				case 'U': 
					Spectateur copy_spectateur = pm.makePersistent((Spectateur) o); 
					id = copy_spectateur.getId();
					break;
				case 'C': 
					Critique copy_critique = pm.makePersistent((Critique) o); 
					id = copy_critique.getId();
					break;
			}
			tx.commit();
		} finally {
			if (tx.isActive()) tx.rollback();
			pm.close();
			pmf.close();
		}
		return id;
	}
	
	public static void initialise () {
		List<Integer> listeFilm = new ArrayList<Integer>();
		List<Integer> listeFilm2 = new ArrayList<Integer>();
		SalleDaoImpl data = new SalleDaoImpl();
		
		Salle salle1 = new Salle("Cinema pathe gaumont", "Paris", listeFilm);
		Salle salle2 = new Salle("Cinema CGR", "Bordeaux", listeFilm2);
		
		Film Harry_Potter = new Film("Harry Potter", "Synopsis1", LocalDate.now());
		Film Star_wars = new Film("Star Wars", "Synopsis2", LocalDate.now());
		Film Fast_and_furious = new Film("Fast and Furious", "Synopsis", LocalDate.now());
		int idF1= addData(Harry_Potter, 'F');
		int idF2 = addData(Star_wars, 'F');
		int idF3 = addData(Fast_and_furious, 'F');
		int id_salle1 = addData(salle1, 'S');
		int id_salle2= addData(salle2,'S');
		listeFilm.add(idF1);
		listeFilm2.add(idF1);
		listeFilm.add(idF2);
		listeFilm.add(idF3);
		listeFilm2.add(idF3);
		data.setFilm(listeFilm, id_salle1);
		data.setFilm(listeFilm2, id_salle2);
		
		
		
	}
	
	public static Film getFilm (int film_id){
		Film copy = null;
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Example");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Query q = pm.newQuery("SELECT FROM couchedepersistance.Film");
			List<Film> f= (List<Film>) q.execute(); 
			Film u = pm.getObjectById(Film.class, film_id );
			copy = pm.detachCopy(u);
			List<Film> t = (List<Film>) pm.detachCopyAll(f);
			System.out.println(t);
			q.closeAll();
			tx.commit();
		} finally {
			if (tx.isActive()) tx.rollback();
			pm.close();
			pmf.close();
		}
		return copy;
		
	}
	
}
