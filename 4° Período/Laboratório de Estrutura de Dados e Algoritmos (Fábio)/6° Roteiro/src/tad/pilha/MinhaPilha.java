package tad.pilha;

public class MinhaPilha implements PilhaIF<Integer> {
	
	private int tamanho = 10;

	public MinhaPilha(int tamanho) {
		this.tamanho = tamanho;
	}
	
	public MinhaPilha() {
	}

	@Override
	public void empilhar(Integer item) {
		throw new UnsupportedOperationException("Implementar");
		
	}

	@Override
	public Integer desempilhar() {
		throw new UnsupportedOperationException("Implementar");
	}

	@Override
	public Integer topo() {
		throw new UnsupportedOperationException("Implementar");
	}

	@Override
	public PilhaIF<Integer> multitop(int k) {
		throw new UnsupportedOperationException("Implementar");
	}

	@Override
	public boolean isEmpty() {
		throw new UnsupportedOperationException("Implementar");
	}


}
