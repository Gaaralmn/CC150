/**
 * Runtime exception thrown when one tries to perform operation 
 * top or pop on the empty stack.
 */

public class EmptyStackException extends RuntimeException {
	public EmptyStackException(String err) {
		super(err);
	}
}
class FullStackException extends RuntimeException {
	public FullStackException(String err) {
		super(err);
	}
}
