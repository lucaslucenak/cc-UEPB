package testes;


import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tad.listasEncadeadas.ListaEncadeadaIF;
import tad.listasEncadeadas.ListaEncadeadaImpl;
import tad.listasEncadeadas.ListaVaziaException;
import tad.listasEncadeadas.NodoListaEncadeada;


public class TestaListaEncadeada {
	
	private ListaEncadeadaIF<Integer> listaEnc = null;
	
	@BeforeEach
	public void inicializar() {
		listaEnc = new ListaEncadeadaImpl<Integer>();
	}
	
	@Test
	public void imprimeEmOrdemTest() {
		assertEquals("", listaEnc.imprimeEmOrdem());
		listaEnc.insert(2);
		assertEquals("2", listaEnc.imprimeEmOrdem());
		assertArrayEquals(new Integer[2], listaEnc.toArray(Integer.class));
		listaEnc.insert(10);
		assertEquals("2, 10", listaEnc.imprimeEmOrdem());
		listaEnc.insert(5);
		assertEquals("2, 10, 5", listaEnc.imprimeEmOrdem());
		listaEnc.insert(9);
		assertEquals("2, 10, 5, 9", listaEnc.imprimeEmOrdem());
		listaEnc.insert(1);
		assertEquals("2, 10, 5, 9, 1", listaEnc.imprimeEmOrdem());
		listaEnc.insert(3);
		assertEquals("2, 10, 5, 9, 1, 3", listaEnc.imprimeEmOrdem());
		listaEnc.insert(4);
		assertEquals("2, 10, 5, 9, 1, 3, 4", listaEnc.imprimeEmOrdem());
	}
	
	@Test
	public void toArrayTest() {
		assertArrayEquals(null, listaEnc.toArray(Integer.class));
		listaEnc.insert(2);
		assertEquals("2", listaEnc.imprimeEmOrdem());
		assertArrayEquals(new Integer[] {2}, listaEnc.toArray(Integer.class));
		listaEnc.insert(10);
		assertArrayEquals(new Integer[] {2,10}, listaEnc.toArray(Integer.class));
		listaEnc.insert(5);
		assertArrayEquals(new Integer[] {2,10, 5}, listaEnc.toArray(Integer.class));
		listaEnc.insert(9);
		assertArrayEquals(new Integer[] {2,10, 5,9}, listaEnc.toArray(Integer.class));
		listaEnc.insert(1);
		assertArrayEquals(new Integer[] {2,10, 5, 9, 1}, listaEnc.toArray(Integer.class));
		listaEnc.insert(3);
		assertArrayEquals(new Integer[] {2,10, 5, 9, 1, 3}, listaEnc.toArray(Integer.class));
		listaEnc.insert(4);
		assertArrayEquals(new Integer[] {2,10, 5, 9, 1, 3, 4}, listaEnc.toArray(Integer.class));
	}
	
	@Test
	public void imprimeInversoTest() {
		assertEquals("", listaEnc.imprimeInverso());
		listaEnc.insert(2);
		assertEquals("2", listaEnc.imprimeInverso());
		listaEnc.insert(10);
		assertEquals("10, 2", listaEnc.imprimeInverso());
		listaEnc.insert(5);
		assertEquals("5, 10, 2", listaEnc.imprimeInverso());
		listaEnc.insert(9);
		assertEquals("9, 5, 10, 2", listaEnc.imprimeInverso());
		listaEnc.insert(1);
		assertEquals("1, 9, 5, 10, 2", listaEnc.imprimeInverso());
		listaEnc.insert(3);
		assertEquals("3, 1, 9, 5, 10, 2", listaEnc.imprimeInverso());
		listaEnc.insert(4);
		assertEquals("4, 3, 1, 9, 5, 10, 2", listaEnc.imprimeInverso());
	}
	
	@Test
	public void insertsearchTeste() {
		assertEquals(null, listaEnc.search(20));
		listaEnc.insert(20);
		assertEquals(new NodoListaEncadeada<Integer>(20), listaEnc.search(20));
		assertNull(listaEnc.search(20).getProximo());
		listaEnc.insert(15);
		assertEquals(new NodoListaEncadeada<Integer>(15), listaEnc.search(15));
		assertEquals(new NodoListaEncadeada<Integer>(15),listaEnc.search(20).getProximo());
		assertNull(listaEnc.search(15).getProximo());
		listaEnc.insert(3);
		assertEquals(new NodoListaEncadeada<Integer>(3), listaEnc.search(3));
		assertEquals(new NodoListaEncadeada<Integer>(3),listaEnc.search(15).getProximo());
		assertNull(listaEnc.search(3).getProximo());
		listaEnc.insert(90);
		assertEquals(new NodoListaEncadeada<Integer>(90), listaEnc.search(90));
		assertEquals(new NodoListaEncadeada<Integer>(90),listaEnc.search(3).getProximo());
		assertNull(listaEnc.search(90).getProximo());
		listaEnc.insert(100);
		assertEquals(new NodoListaEncadeada<Integer>(100), listaEnc.search(100));
		assertEquals(new NodoListaEncadeada<Integer>(100),listaEnc.search(90).getProximo());
		assertNull(listaEnc.search(100).getProximo());
		listaEnc.insert(73);
		assertEquals(new NodoListaEncadeada<Integer>(73), listaEnc.search(73));
		assertEquals(new NodoListaEncadeada<Integer>(73),listaEnc.search(100).getProximo());
		assertNull(listaEnc.search(73).getProximo());
		listaEnc.insert(29);
		assertEquals(new NodoListaEncadeada<Integer>(29), listaEnc.search(29));
		assertEquals(new NodoListaEncadeada<Integer>(29),listaEnc.search(73).getProximo());
		assertNull(listaEnc.search(29).getProximo());
		assertEquals(null, listaEnc.search(230));
	}
	
	@Test
	public void insertRemoverTeste() {
		assertThrows(ListaVaziaException.class, () -> {
			listaEnc.remove(38);
		});
		
		listaEnc.insert(206);
		listaEnc.insert(152);
		listaEnc.insert(38);
		listaEnc.insert(91);
		listaEnc.insert(18);
		listaEnc.insert(93);
		listaEnc.insert(69);
		assertEquals("206, 152, 38, 91, 18, 93, 69", listaEnc.imprimeEmOrdem());
		assertEquals(new NodoListaEncadeada<Integer>(91), listaEnc.remove(91));
		assertEquals("206, 152, 38, 18, 93, 69", listaEnc.imprimeEmOrdem());
		assertArrayEquals(new Integer[] {206, 152, 38, 18, 93, 69}, listaEnc.toArray(Integer.class));
		
		assertEquals(new NodoListaEncadeada<Integer>(18), listaEnc.remove(18));
		assertEquals("206, 152, 38, 93, 69", listaEnc.imprimeEmOrdem());
		assertArrayEquals(new Integer[] {206, 152, 38, 93, 69}, listaEnc.toArray(Integer.class));
		
		assertEquals(new NodoListaEncadeada<Integer>(206), listaEnc.remove(206));
		assertEquals("152, 38, 93, 69", listaEnc.imprimeEmOrdem());
		assertArrayEquals(new Integer[] {152, 38, 93, 69}, listaEnc.toArray(Integer.class));
		
		assertEquals(new NodoListaEncadeada<Integer>(152), listaEnc.remove(152));
		assertEquals("38, 93, 69", listaEnc.imprimeEmOrdem());
		assertArrayEquals(new Integer[] {38, 93, 69}, listaEnc.toArray(Integer.class));
		
		assertEquals(new NodoListaEncadeada<Integer>(93), listaEnc.remove(93));
		assertEquals("38, 69", listaEnc.imprimeEmOrdem());
		assertArrayEquals(new Integer[] {38, 69}, listaEnc.toArray(Integer.class));
		
		assertEquals(new NodoListaEncadeada<Integer>(69), listaEnc.remove(69));
		assertEquals("38", listaEnc.imprimeEmOrdem());
		assertArrayEquals(new Integer[] {69}, listaEnc.toArray(Integer.class));
		
		assertEquals(new NodoListaEncadeada<Integer>(38), listaEnc.remove(38));
		assertEquals("", listaEnc.imprimeEmOrdem());
		assertArrayEquals(null, listaEnc.toArray(Integer.class));
		assertTrue(listaEnc.isEmpty());
		
		assertThrows(ListaVaziaException.class, () -> {
			listaEnc.remove(38);
		});
	}
	
	@Test
	public void sucessorTeste() {
		listaEnc.insert(206);
		listaEnc.insert(122);
		listaEnc.insert(58);
		listaEnc.insert(11);
		listaEnc.insert(78);
		listaEnc.insert(43);
		listaEnc.insert(59);
		assertEquals(new NodoListaEncadeada<Integer>(122), listaEnc.sucessor(206));
		assertEquals(new NodoListaEncadeada<Integer>(58), listaEnc.sucessor(122));
		assertEquals(new NodoListaEncadeada<Integer>(11), listaEnc.sucessor(58));
		assertEquals(new NodoListaEncadeada<Integer>(78), listaEnc.sucessor(11));
		assertEquals(new NodoListaEncadeada<Integer>(43), listaEnc.sucessor(78));
		assertEquals(new NodoListaEncadeada<Integer>(59), listaEnc.sucessor(43));
		
	}
	
	@Test
	public void predecessorTeste() {
		listaEnc.insert(206);
		listaEnc.insert(122);
		listaEnc.insert(58);
		listaEnc.insert(11);
		listaEnc.insert(78);
		listaEnc.insert(43);
		listaEnc.insert(59);
		assertEquals(new NodoListaEncadeada<Integer>(43), listaEnc.predecessor(59));
		assertEquals(new NodoListaEncadeada<Integer>(78), listaEnc.predecessor(43));
		assertEquals(new NodoListaEncadeada<Integer>(11), listaEnc.predecessor(78));
		assertEquals(new NodoListaEncadeada<Integer>(58), listaEnc.predecessor(11));
		assertEquals(new NodoListaEncadeada<Integer>(122), listaEnc.predecessor(58));
		assertEquals(new NodoListaEncadeada<Integer>(206), listaEnc.predecessor(122));
		
	}
	
	@Test
	public void isEmptyTest() {
		assertTrue(listaEnc.isEmpty());
		listaEnc.insert(206);
		listaEnc.insert(122);
		listaEnc.insert(58);
		listaEnc.insert(11);
		listaEnc.insert(78);
		listaEnc.insert(43);
		listaEnc.insert(59);
		assertFalse(listaEnc.isEmpty());
		listaEnc.remove(206);
		listaEnc.remove(122);
		listaEnc.remove(58);
		listaEnc.remove(11);
		listaEnc.remove(78);
		listaEnc.remove(43);
		assertFalse(listaEnc.isEmpty());
		listaEnc.remove(59);
		assertTrue(listaEnc.isEmpty());
	}
	
	@Test
	public void sizeRemoveCabecaTest() {
		assertEquals(0, listaEnc.size());
		listaEnc.insert(58);
		assertEquals(1, listaEnc.size());
		listaEnc.insert(11);
		assertEquals(2, listaEnc.size());
		listaEnc.insert(78);
		assertEquals(3, listaEnc.size());
		listaEnc.insert(43);
		assertEquals(4, listaEnc.size());
		listaEnc.remove(58);
		assertEquals(3, listaEnc.size());
		listaEnc.remove(11);
		assertEquals(2, listaEnc.size());
		listaEnc.remove(78);
		assertEquals(1, listaEnc.size());
		listaEnc.remove(43);
		assertEquals(0, listaEnc.size());
	}

}
