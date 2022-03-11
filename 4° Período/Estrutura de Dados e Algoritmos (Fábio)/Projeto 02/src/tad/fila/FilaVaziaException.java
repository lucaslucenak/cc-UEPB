package tad.fila;

public class FilaVaziaException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2035554480259121771L;

	public FilaVaziaException() {
		super("fila vazia!");
	}
	
	public FilaVaziaException(String message) {
		super(message);
	}

}
