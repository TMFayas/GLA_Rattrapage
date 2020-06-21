package couchedepersistance;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import couchedepersistance.Salle;
import couchedepersistance.SalleDao;

public class SalleDaoImpl implements SalleDao {

	@SuppressWarnings("unchecked")
	public List<Salle> getAllSalles() {
		List<Salle> t = null;
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Example");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Query q = pm.newQuery("SELECT FROM couchedepersistance.Salle");
			List<Salle> s= (List<Salle>) q.execute();
			t = (List<Salle>) pm.detachCopyAll(s);
			q.closeAll();
			tx.commit();
		} finally {
			if (tx.isActive()) tx.rollback();
			pm.close();
			pmf.close();
		}
		return t;
	}

	public List<Integer> getAllFilm(int id) {
		Salle copy = null;
		List<Integer> res =null;
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Example");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Salle u = pm.getObjectById(Salle.class, id );
			System.out.println(u.getFilms());
			copy = pm.detachCopy(u);
			res = copy.getFilms();
			tx.commit();
		} finally {
			if (tx.isActive()) tx.rollback();
			pm.close();
			pmf.close();
		}
		return res;
	}

	public void setName(String name, int id) {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Example");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Salle s = pm.getObjectById(Salle.class, id);
			s.setName(name);
			tx.commit();
		} finally {
			if (tx.isActive()) tx.rollback();
			pm.close();
			pmf.close();
		}

	}

	public void setAddress(String address, int id) {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Example");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Salle s = pm.getObjectById(Salle.class, id);
			s.setAddress(address);
			tx.commit();
		} finally {
			if (tx.isActive()) tx.rollback();
			pm.close();
			pmf.close();
		}

	}

	public void setFilm(List<Integer> film, int id) {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Example");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Salle s = pm.getObjectById(Salle.class, id);
			s.setFilms(film);
			System.out.println(s.getFilms());
			tx.commit();
		} finally {
			if (tx.isActive()) tx.rollback();
			pm.close();
			pmf.close();
		}

	}

	public void addSalle(String name, String address, List<Integer> film) {
		Salle s = new Salle(name, address, film);
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Example");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			pm.makePersistent(s);
			tx.commit();
		} finally {
			if (tx.isActive()) tx.rollback();
			pm.close();
			pmf.close();
		}

	}

	public void deleteSalle(int id) {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Example");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Salle s = pm.getObjectById(Salle.class, id);
			pm.deletePersistent(s);
			tx.commit();
		} finally {
			if (tx.isActive()) tx.rollback();
			pm.close();
			pmf.close();
		}

	}

}
