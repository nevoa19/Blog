package Blog.usecases.exceptions;

public class NotfoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NotfoundException(String message) {
        super(message);
    }

}
