package tad.fila;

/**
 * Fila deve ser implementada com array fixo e estratégia circular
 * de gerenciamento de apontadores de cauda e cabeça.
 * @author fabioleite
 *
 */
public class MinhaFila implements FilaIF<Integer> {
	
	private int tamanho = 10;

	public MinhaFila(int tamanhoInicial) {
		tamanho = tamanhoInicial;
	}
	
	public MinhaFila() {
	}

	@Override
	public void enfileirar(Integer item) {
		throw new UnsupportedOperationException("Implementar");
		
	}

	@Override
	public Integer desenfileirar() {
		throw new UnsupportedOperationException("Implementar");
	}

	@Override
	public Integer verificarCauda() {
		throw new UnsupportedOperationException("Implementar");
	}

	@Override
	public Integer verificarCabeca() {
		throw new UnsupportedOperationException("Implementar");
	}

	@Override
	public boolean isEmpty() {
		throw new UnsupportedOperationException("Implementar");
	}

	@Override
	public boolean isFull() {
		throw new UnsupportedOperationException("Implementar");
	}

}
