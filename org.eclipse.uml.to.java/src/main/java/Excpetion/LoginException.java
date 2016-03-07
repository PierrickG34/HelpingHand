package Excpetion;

public class LoginException extends RuntimeException {
	
	private String nameException;
	
	public LoginException() {
		super("");
	}
	
	public LoginException(String nameError) {
		super(nameError);
		this.nameException = nameError;
	}
	
	public String getNameError() {
		return this.nameException;
	}

}
