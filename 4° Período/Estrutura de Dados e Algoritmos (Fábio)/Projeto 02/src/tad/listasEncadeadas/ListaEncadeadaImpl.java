package tad.listasEncadeadas;

public class ListaEncadeadaImpl<T extends Comparable<T>> implements ListaEncadeadaIF<T>{
	
	NodoListaEncadeada<T> cabeça = null;
	

	@Override
	public boolean isEmpty() {
		throw new UnsupportedOperationException("Precisa implementar!");
	}

	@Override
	public int size() {
		throw new UnsupportedOperationException("Precisa implementar!");
	}

	@Override
	public NodoListaEncadeada<T> search(T chave) {
		throw new UnsupportedOperationException("Precisa implementar!");
	}

	@Override
	public void insert(T chave) {
		throw new UnsupportedOperationException("Precisa implementar!");
		
	}

	@Override
	public NodoListaEncadeada<T> remove(T chave) {
		throw new UnsupportedOperationException("Precisa implementar!");
		
	}

	@Override
	public T[] toArray(Class<T> clazz) {
		// Criar um array usando a classe utilitária conversor
//		Conversor<T> c = new Conversor<T>();
//		T[] meuArray = c.gerarArray(clazz, 10);
		throw new UnsupportedOperationException("Precisa implementar!");
	}

	@Override
	public String imprimeEmOrdem() {
		throw new UnsupportedOperationException("Precisa implementar!");
	}

	@Override
	public String imprimeInverso() {
		throw new UnsupportedOperationException("Precisa implementar!");
	}

	@Override
	public NodoListaEncadeada<T> sucessor(T chave) {
		throw new UnsupportedOperationException("Precisa implementar!");
	}

	@Override
	public NodoListaEncadeada<T> predecessor(T chave) {
		throw new UnsupportedOperationException("Precisa implementar!");
	}

	@Override
	public void insert(T chave, int index) {
		throw new UnsupportedOperationException("Precisa implementar!");
	}

}
