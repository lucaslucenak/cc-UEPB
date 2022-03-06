package tad.util;

import java.lang.reflect.Array;

public class Conversor<E> {
	
	@SuppressWarnings("unchecked")
	public E[] gerarArray(Class<E> clazz, int capacity) {
		return (E[])Array.newInstance(clazz, capacity);
	}

}
