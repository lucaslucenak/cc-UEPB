package tad.listasEncadeadas;

public class NodoListaEncadeada<T extends Comparable<T>> {
	
	protected T chave;
	protected NodoListaEncadeada<T> proximo = null;
	
	public NodoListaEncadeada() {
		this.setChave(null);
		this.setProximo(null);
	}
	
	public NodoListaEncadeada(T chave) {
		this.setChave(chave);
		this.setProximo(null);
	}
	
	public NodoListaEncadeada(T chave, NodoListaEncadeada<T> proximo) {
		this.setChave(chave);
		this.setProximo(proximo);
	}

	public T getChave() {
		return chave;
	}

	public void setChave(T chave) {
		this.chave = chave;
	}

	public NodoListaEncadeada<T> getProximo() {
		return proximo;
	}

	public void setProximo(NodoListaEncadeada<T> proximo) {
		this.proximo = proximo;
	}
	
	public boolean isNull() {
		return (chave == null ? true:false);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || this.chave == null) {
			return false;
		}
		@SuppressWarnings("unchecked")
		NodoListaEncadeada<T> aComparar = ((NodoListaEncadeada<T>) obj);
		if ( (this.chave.compareTo(aComparar.getChave()) == 0) &&
				(this.getProximo().equals(aComparar.getProximo())) ) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		if (!this.isNull())
			return this.chave.toString();
		return null;
	}
	
	

}
