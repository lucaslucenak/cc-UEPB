package tad.listasEncadeadas;

public class ListaVaziaException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2035554480259121771L;

	public ListaVaziaException() {
		super("lista vazia!");
	}
	
	public ListaVaziaException(String message) {
		super(message);
	}

}
