package tad.listasEncadeadas;

public interface ListaDuplamenteEncadeadaIF<T extends Comparable<T>> extends ListaEncadeadaIF<T>{
	
	public void inserePrimeiro(T elemento);
	public NodoListaDuplamenteEncadeada<T> removeUltimo();
	public NodoListaDuplamenteEncadeada<T> removePrimeiro();

}
