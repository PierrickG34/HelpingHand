package Excpetion;

public class PasswordException extends RuntimeException {
	
	private String nameException;
	
	
	public PasswordException() {
		super("");
	}
	
	public PasswordException(String nameError) {
		super(nameError);
		this.nameException = nameError;
	}
	
	
	public String getNameError() {
		return this.nameException;
	}

}
