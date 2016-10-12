package net.minis.bdd;

public class NotYetImplementedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NotYetImplementedException() {
	}

	public NotYetImplementedException(String message) {
		super(message);
	}

	public NotYetImplementedException(String message, Throwable cause) {
		super(message, cause);
	}

	public NotYetImplementedException(Throwable cause) {
		super(cause);
	}

}
