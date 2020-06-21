package couchedepersistance;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

public class CritiqueDaoImpl implements CritiqueDao {

	public Critique getCritique(int id) {
		Critique copy = null;
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Example");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Critique u = pm.getObjectById(Critique.class, id );
			copy = pm.detachCopy(u);
			tx.commit();
		} finally {
			if (tx.isActive()) tx.rollback();
			pm.close();
			pmf.close();
		}
		return copy;
	}

	public void addCritique(Spectateur s, String Description, int note) {
		Critique f = new Critique(s, Description, note);
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

}
