package tad.listasEncadeadas;

public interface ListaEncadeadaIF<T extends Comparable<T>> {
	
	public boolean isEmpty();
	public int size();
	public NodoListaEncadeada<T> search(T chave);
	public void insert(T chave);
	public void insert(T chave, int index);
	public NodoListaEncadeada<T> remove(T chave);
	/**
	 * Existem uma conotação semântica para o imprime em ordem. É para imprimir na ordem em que
	 * os elementos são inseridos.
	 * @return String cadeia de string com as chaves dos elementos concatenadas e separadas
	 *  por um espaço
	 */
	public String imprimeEmOrdem();
	
	/**
	 * Imprimir uma cadeia de caracteres de acordo com as chaves inseridas. A ordem dos elementos
	 * deve ser inversa a que foram inseridos
	 * @return String com o conjunto das chaves inseridas em ordem inversa.
	 */
	public String imprimeInverso();
	public NodoListaEncadeada<T> sucessor(T chave);
	public NodoListaEncadeada<T> predecessor(T chave);
	/**
	 * Gerar um array de elementos de acordo com a ordem em que foram inseridos
	 * @return Array de elementos chave de acordo como foi inserido 
	 */
	public T[] toArray(Class<T> clazz);

}
