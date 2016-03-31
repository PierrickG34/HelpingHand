package Excpetion;

// TODO: Auto-generated Javadoc
/**
 * The Class PasswordException.
 * @author Helping Hand
 */
public class PasswordException extends RuntimeException {
	
	/** The name exception. */
	private String nameException;
	
	
	/**
	 * Instantiates a new password exception.
	 */
	public PasswordException() {
		super("");
	}
	
	/**
	 * Instantiates a new password exception.
	 *
	 * @param nameError the name error
	 */
	public PasswordException(String nameError) {
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
