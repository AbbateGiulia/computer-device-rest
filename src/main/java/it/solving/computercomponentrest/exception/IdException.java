package it.solving.computercomponentrest.exception;


public class IdException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String error;

	public IdException(String error) {
		super();
		this.error = error;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
	

}
