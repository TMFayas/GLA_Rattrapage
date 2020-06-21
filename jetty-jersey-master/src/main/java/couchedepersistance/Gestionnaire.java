package couchedepersistance;

public class Gestionnaire extends Spectateur {

	private boolean status;
	
	public Gestionnaire() {
		status =false;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
}
