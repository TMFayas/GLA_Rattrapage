package couchedepersistance;

import java.time.LocalDate;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

public class FIlmDaoImpl implements FilmDao{

	@SuppressWarnings("unchecked")
	public List<Film> getAllFilm() {
		List<Film> t = null;
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Example");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Query q = pm.newQuery("SELECT FROM couchedepersistance.Film");
			List<Film> f= (List<Film>) q.execute();
			t = (List<Film>) pm.detachCopyAll(f);
			q.closeAll();
			tx.commit();
		} finally {
			if (tx.isActive()) tx.rollback();
			pm.close();
			pmf.close();
		}
		return t;
	}

	public Film getFilm(int id) {
		Film copy = null;
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Example");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Film u = pm.getObjectById(Film.class, id );
			copy = pm.detachCopy(u);
			tx.commit();
		} finally {
			if (tx.isActive()) tx.rollback();
			pm.close();
			pmf.close();
		}
		return copy;
	}

	public void setName(String name, int id) {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Example");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Film f = pm.getObjectById(Film.class, id);
			f.setName(name);
			tx.commit();
		} finally {
			if (tx.isActive()) tx.rollback();
			pm.close();
			pmf.close();
		}
		
	}

	public void setSynopsis(String synopsis, int id) {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Example");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Film f = pm.getObjectById(Film.class, id);
			f.setSynopsis(synopsis);
			tx.commit();
		} finally {
			if (tx.isActive()) tx.rollback();
			pm.close();
			pmf.close();
		}
		
	}

	public void setCritiques(List<Critique> critiques, int id) {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Example");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Film f = pm.getObjectById(Film.class, id);
			f.setCritiques(critiques);
			tx.commit();
		} finally {
			if (tx.isActive()) tx.rollback();
			pm.close();
			pmf.close();
		}
		
	}
	

	public void addFilm(String name, String synopsis, LocalDate release) {
		Film f = new Film(name, synopsis, release);
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Example");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			pm.makePersistent(f);
			tx.commit();
		} finally {
			if (tx.isActive()) tx.rollback();
			pm.close();
			pmf.close();
		}
		
	}

	public void deleteFilm(int id) {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Example");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Film u = pm.getObjectById(Film.class, id);
			pm.deletePersistent(u);
			tx.commit();
		} finally {
			if (tx.isActive()) tx.rollback();
			pm.close();
			pmf.close();
		}
	}

	

	
}
