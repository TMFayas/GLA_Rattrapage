package couchedepersistance;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

public class SpectateurDaoImpl implements SpectateurDao {

	public String getSpectateurName(int id) {
		Spectateur copy = null;
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Example");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Spectateur u = pm.getObjectById(Spectateur.class, id );
			copy = pm.detachCopy(u);
			tx.commit();
		} finally {
			if (tx.isActive()) tx.rollback();
			pm.close();
			pmf.close();
		}
		return copy.getName();
	}

	public void addSpectateur(String name, String password) {
		Spectateur f = new Spectateur(name, password);
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
