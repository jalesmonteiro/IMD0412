package br.ufrn.imd.triangle;

import org.junit.BeforeClass;
import org.junit.Test;

public class TriangleExceptionTest {
	private static Triangle t;
	
	@BeforeClass
	public static void setUpBeforeClass() {
		t = new Triangle();
	}
	
	@Test(expected = NullPointerException.class)
	public void triangleShouldThrowNullPointerException() {
		// Configuração
		final Integer s1 = null;
		final Integer s2 = 10;
		final Integer s3 = 10;
		
		// ​Açãofinal
		t.defineType(s1, s2, s3);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void triangleShouldThrowIllegalArgumentException() {
		// Configuração
		final Integer s1 = -1;
		final Integer s2 = 10;
		final Integer s3 = 10;
		
		// ​Açãofinal
		t.defineType(s1, s2, s3);
	}

}
