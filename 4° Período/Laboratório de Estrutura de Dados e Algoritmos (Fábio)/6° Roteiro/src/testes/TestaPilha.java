package testes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tad.pilha.MinhaPilha;
import tad.pilha.PilhaCheiaException;
import tad.pilha.PilhaIF;
import tad.pilha.PilhaVaziaException;

public class TestaPilha {
	
	protected PilhaIF<Integer> pilha = null;
	
	@BeforeEach
	public void iniciar() {
		pilha = new MinhaPilha();
	}
	
	@Test
	public void empilharTest() {
		try {
			pilha.empilhar(3);
		
			Assert.assertEquals(new Integer(3), pilha.topo());
			pilha.empilhar(5);
			Assert.assertEquals(new Integer(5), pilha.topo());
			pilha.empilhar(7);
			Assert.assertEquals(new Integer(7), pilha.topo());
			pilha.empilhar(4);
			Assert.assertEquals(new Integer(4), pilha.topo());
			pilha.empilhar(2);
			Assert.assertEquals(new Integer(2), pilha.topo());
		} catch (PilhaCheiaException e) {
			Assert.fail("empilharTest está estourando a pilha erroneamente");
		}
	}
	
	@Test
	public void topoTest() {
		Assert.assertNull(pilha.topo());
		try {
			pilha.empilhar(3);
			Assert.assertEquals(new Integer(3), pilha.topo());
			pilha.empilhar(5);
			Assert.assertEquals(new Integer(5), pilha.topo());
			pilha.empilhar(7);
			Assert.assertEquals(new Integer(7), pilha.topo());
			pilha.empilhar(4);
			Assert.assertEquals(new Integer(4), pilha.topo());
			pilha.empilhar(2);
			Assert.assertEquals(new Integer(2), pilha.topo());
		} catch (PilhaCheiaException e) {
			Assert.fail(" está estourando a pilha erroneamente");
		}
		
	}
	
	@Test
	public void desempilharTest() {
		try {
			pilha.desempilhar();
			Assert.fail("deveria lançar uma exceção quando chamar o desempilhar de uma pilha vazia");
		} catch (Exception e) {}
		try {
			pilha.empilhar(3);
			Assert.assertEquals(new Integer(3), pilha.topo());
			pilha.empilhar(5);
			Assert.assertEquals(new Integer(5), pilha.topo());
			pilha.empilhar(7);
			Assert.assertEquals(new Integer(7), pilha.topo());
			pilha.empilhar(4);
			Assert.assertEquals(new Integer(4), pilha.topo());
			pilha.empilhar(2);
		} catch (PilhaCheiaException e) {
			Assert.fail(" está estourando a pilha erroneamente");
		} 
		try {
			Assert.assertEquals(new Integer(2), pilha.topo());
			Assert.assertEquals(new Integer(2), pilha.desempilhar());
			Assert.assertEquals(new Integer(4), pilha.topo());
			
			Assert.assertEquals(new Integer(4), pilha.desempilhar());
			Assert.assertEquals(new Integer(7), pilha.topo());
			
			Assert.assertEquals(new Integer(7), pilha.desempilhar());
			Assert.assertEquals(new Integer(5), pilha.topo());
			
			Assert.assertEquals(new Integer(5), pilha.desempilhar());
			Assert.assertEquals(new Integer(3), pilha.topo());
			
			Assert.assertEquals(new Integer(3), pilha.topo());
		} catch (PilhaVaziaException e) {
			Assert.fail(" está esvaziando a pilha erroneamente");
		}
	}
	
	@Test
	public void isEmptyTest() {
		Assert.assertTrue(pilha.isEmpty());
		try { 
			pilha.empilhar(3);
			Assert.assertEquals(new Integer(3), pilha.topo());
			Assert.assertFalse(pilha.isEmpty());
			pilha.desempilhar();
			Assert.assertTrue(pilha.isEmpty());
			pilha.empilhar(4);
			pilha.empilhar(6);
			Assert.assertFalse(pilha.isEmpty());
		} catch (PilhaCheiaException e) {
			Assert.fail(" está estourando a pilha erroneamente");
		} catch (PilhaVaziaException e) {
			Assert.fail(" está esvaziando a pilha erroneamente");
		}
	}
	
	@Test
	public void pilhaVaziaTest() {
		assertThrows(PilhaVaziaException.class, () -> {
			pilha.empilhar(3);
			pilha.empilhar(2);
			pilha.empilhar(10);
			pilha.desempilhar();
			pilha.desempilhar();
			pilha.desempilhar();
			pilha.desempilhar();
	    });
	}
	
	@Test
	public void pilhaCheiaTest() {
		assertThrows(PilhaCheiaException.class, () -> {
			pilha.empilhar(3);
			pilha.empilhar(2);
			pilha.empilhar(10);
			pilha.empilhar(3);
			pilha.empilhar(2);
			pilha.empilhar(10);
	    });
	}
	
	@Test
	public void multitopTest() {
		PilhaIF<Integer> saida = new MinhaPilha();
		PilhaIF<Integer> saida2 = new MinhaPilha();
		try {
			pilha.empilhar(3);
			pilha.empilhar(2);
			pilha.empilhar(10);
			pilha.empilhar(3);
			saida.empilhar(3);
			saida.empilhar(10);
			saida.empilhar(2);
			saida2.empilhar(3);
		} catch (PilhaCheiaException e) {
			Assert.fail("Estouro inexperado da pilha");
		}
		assertEquals(saida, pilha.multitop(3));
		assertEquals(saida2,pilha.multitop(5));
		
		assertThrows(PilhaVaziaException.class, () -> {
			pilha.multitop(10);
	    });
	}
	

	

}
