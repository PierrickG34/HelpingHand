package Excpetion;

public class AlreadyExistException extends RuntimeException {
	
	private String nameException;
	
	public AlreadyExistException() {
		super("");
	}
	
	public AlreadyExistException(String nameError) {
		super(nameError);
		this.nameException = nameError;
	}
	
	public String getNameError() {
		return this.nameException;
	}

}
