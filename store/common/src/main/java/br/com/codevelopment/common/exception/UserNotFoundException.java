package br.com.codevelopment.common.exception;

public class UserNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public UserNotFoundException() {
        super("User not found");
    }
	
	public UserNotFoundException(String msg) {
        super(msg);
    }
}
