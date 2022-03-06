package testes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import tad.conjuntoDinamico.ConjuntoDinamicoIF;
import tad.conjuntoDinamico.MeuConjuntoDinamico;



public class TestaConjuntoDinamico {
	
	private ConjuntoDinamicoIF<Integer> cd = null;
	
	@Before
	public void iniciar() {
		cd = new MeuConjuntoDinamico();
	}
	
	public void tamanhoTest() {
		Assert.assertEquals(0, cd.tamanho());
		cd.inserir(2);
		Assert.assertEquals(1, cd.tamanho());
		cd.inserir(2);
		Assert.assertEquals(2, cd.tamanho());
		cd.inserir(1);
		Assert.assertEquals(3, cd.tamanho());
		cd.inserir(5);
		Assert.assertEquals(4, cd.tamanho());
	}
	
	@Test
	public void inserirTeste() {
		Assert.assertEquals(0, cd.tamanho());
		cd.inserir(9);
		Assert.assertEquals(1, cd.tamanho());
		cd.inserir(4);
		Assert.assertEquals(2, cd.tamanho());
		cd.inserir(1);
		Assert.assertEquals(3, cd.tamanho());
		cd.inserir(1);
		Assert.assertEquals(4, cd.tamanho());
	}
	
	@Test
	public void removerTeste() throws Exception {
		Assert.assertEquals(0, cd.tamanho());
		cd.inserir(2);
		cd.inserir(2);
		cd.inserir(1);
		cd.inserir(5);
		Assert.assertEquals(new Integer(2), cd.remover(2));
		Assert.assertEquals(3, cd.tamanho());
		
		Assert.assertEquals(new Integer(1), cd.remover(1));
		Assert.assertEquals(2, cd.tamanho());
		
		Assert.assertEquals(new Integer(5), cd.remover(5));
		Assert.assertEquals(1, cd.tamanho());
		
		Assert.assertEquals(new Integer(2), cd.remover(2));
		Assert.assertEquals(0, cd.tamanho());
	}
	
	@Test(expected=Exception.class)
	public void removerFailTeste() throws Exception {
		cd.remover(3);
		cd.inserir(4);
		cd.inserir(5);
		cd.inserir(10);
		cd.inserir(8);
	}
	
	@Test(expected=Exception.class)
	public void removerFail2Teste() throws Exception {
		cd.inserir(4);
		cd.inserir(5);
		cd.inserir(10);
		cd.inserir(8);
		cd.remover(3);
	}
	
	@Test
	public void buscarTeste() throws Exception {
		cd.inserir(4);
		cd.inserir(5);
		cd.inserir(10);
		cd.inserir(8);
		Assert.assertEquals(new Integer(10), cd.buscar(10));
	}
	
	@Test(expected=Exception.class)
	public void buscarFailTeste() throws Exception {
		cd.inserir(4);
		cd.inserir(5);
		cd.inserir(10);
		cd.inserir(8);
		cd.buscar(1);
	}
	
	@Test
	public void minimumTeste() throws Exception {
		try {
			cd.minimum();
			Assert.fail("deveria lan�ar exce��o quando chamar minimum num conjunto vazio");
		}catch (Exception e) {}
		
		cd.inserir(4);
		cd.inserir(5);
		cd.inserir(10);
		cd.inserir(8);
		Assert.assertEquals(new Integer(4),cd.minimum());
		
	}
	
	@Test
	public void maximumTest() throws Exception {
		try {
			cd.maximum();
			Assert.fail("deveria lan�ar exce��o quando chamar minimum num conjunto vazio");
		}catch (Exception e) {}
		
		cd.inserir(5);
		cd.inserir(4);
		cd.inserir(10);
		cd.inserir(8);
		Assert.assertEquals(new Integer(10),cd.maximum());
	}
	
	@Test
	public void sucessorTeste() throws Exception {
		try {
			cd.sucessor(5);
			Assert.fail("deveria lan�ar exce��o quando chamar minimum num conjunto vazio");
		}catch (Exception e) {}
		
		cd.inserir(4);
		cd.inserir(5);
		cd.inserir(10);
		cd.inserir(8);
		Assert.assertEquals(new Integer(5),cd.sucessor(4));
		Assert.assertEquals(new Integer(10),cd.sucessor(5));
		Assert.assertNull(cd.sucessor(8));
		Assert.assertEquals(new Integer(8),cd.sucessor(10));
	}
	
	@Test
	public void predecessorTeste() throws Exception {
		try {
			cd.predecessor(5);
			Assert.fail("deveria lan�ar exce��o quando chamar minimum num conjunto vazio");
		}catch (Exception e) {}
		
		cd.inserir(4);
		cd.inserir(5);
		cd.inserir(10);
		cd.inserir(8);
		Assert.assertNull(cd.predecessor(4));
		Assert.assertEquals(new Integer(5),cd.predecessor(10));
		Assert.assertEquals(new Integer(4),cd.predecessor(5));
		Assert.assertEquals(new Integer(10),cd.predecessor(8));
		
		try {
			cd.predecessor(83);
			Assert.fail("deveria lan�ar exce��o quando chamar minimum num conjunto vazio");
		}catch (Exception e) {}
	}

}
