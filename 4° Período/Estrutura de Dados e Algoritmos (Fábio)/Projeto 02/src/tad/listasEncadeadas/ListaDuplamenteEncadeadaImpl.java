package tad.listasEncadeadas;

public class ListaDuplamenteEncadeadaImpl<T extends Comparable<T>> implements ListaDuplamenteEncadeadaIF<T> {
	
	//TODO: implementar o nó cabeça
	//TODO: implementar o nó cauda 
	//TODO: implementar as sentinelas

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public NodoListaDuplamenteEncadeada<T> search(T chave) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(T chave) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public NodoListaEncadeada<T> remove(T chave) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String imprimeEmOrdem() {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public String imprimeInverso() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NodoListaEncadeada<T> sucessor(T chave) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NodoListaEncadeada<T> predecessor(T chave) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T[] toArray(Class<T> clazz) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void inserePrimeiro(T elemento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public NodoListaDuplamenteEncadeada<T> removeUltimo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NodoListaDuplamenteEncadeada<T> removePrimeiro() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(T chave, int index) {
		throw new UnsupportedOperationException("Precisa implementar!");
		
	}

	

}
