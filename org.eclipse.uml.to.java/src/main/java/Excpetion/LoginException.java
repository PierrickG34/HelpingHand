package Excpetion;


/**
 * The Class LoginException.
 * @author Helping Hand
 */
public class LoginException extends RuntimeException {
	
	/** The name exception. */
	private String nameException;
	
	/**
	 * Instantiates a new login exception.
	 */
	public LoginException() {
		super("");
	}
	
	/**
	 * Instantiates a new login exception.
	 *
	 * @param nameError the name error
	 */
	public LoginException(String nameError) {
		super(nameError);
		this.nameException = nameError;
	}
	
	/**
	 * Gets the name error.
	 *
	 * @return the name error
	 */
	public String getNameError() {
		return this.nameException;
	}

}
