package tad.conjuntoDinamico;

public interface ConjuntoDinamicoIF<E> {
	
	public void inserir(E item);
	
	public E remover(E item);
	
	public E predecessor(E item);
	
	public E sucessor(E item);
	
	public int tamanho();
	
	public E buscar(E item);
	
	public E minimum();
	
	public E maximum();

}
