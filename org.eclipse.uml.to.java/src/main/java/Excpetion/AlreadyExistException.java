package Excpetion;

// TODO: Auto-generated Javadoc
/**
 * The Class AlreadyExistException.
 */
public class AlreadyExistException extends RuntimeException {
	
	/** The name exception. */
	private String nameException;
	
	/**
	 * Instantiates a new already exist exception.
	 */
	public AlreadyExistException() {
		super("");
	}
	
	/**
	 * Instantiates a new already exist exception.
	 *
	 * @param nameError the name error
	 */
	public AlreadyExistException(String nameError) {
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
