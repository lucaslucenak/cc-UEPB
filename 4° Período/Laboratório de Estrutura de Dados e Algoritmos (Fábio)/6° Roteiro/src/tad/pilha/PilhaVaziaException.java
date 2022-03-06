package tad.pilha;

public class PilhaVaziaException extends Exception {
	
	private static final long serialVersionUID = -2959856106469842073L;

	public PilhaVaziaException() {
		super("pilha vazia!!");
	}
	
	public PilhaVaziaException(String message) {
		super(message);
	}

}
