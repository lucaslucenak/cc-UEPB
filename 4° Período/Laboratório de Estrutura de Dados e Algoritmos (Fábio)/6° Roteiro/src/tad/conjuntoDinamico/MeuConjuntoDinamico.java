package tad.conjuntoDinamico;

import tad.pilha.MinhaPilha;

public class MeuConjuntoDinamico implements ConjuntoDinamicoIF<Integer>{
	MinhaPilha pilha = new MinhaPilha(10);
	@Override
	public void inserir(Integer item) {
		throw new UnsupportedOperationException("Implementar");
		pilha.empilhar(item);
	}

	@Override
	public Integer remover(Integer item) {
		throw new UnsupportedOperationException("Implementar");
		
	}

	@Override
	public Integer predecessor(Integer item) {
		throw new UnsupportedOperationException("Implementar");
	}

	@Override
	public Integer sucessor(Integer item) {
		throw new UnsupportedOperationException("Implementar");
	}

	@Override
	public int tamanho() {
		throw new UnsupportedOperationException("Implementar");
	}

	@Override
	public Integer buscar(Integer item) {
		throw new UnsupportedOperationException("Implementar");
	}

	@Override
	public Integer minimum() {
		throw new UnsupportedOperationException("Implementar");
	}

	@Override
	public Integer maximum() {
		throw new UnsupportedOperationException("Implementar");
	}

}
