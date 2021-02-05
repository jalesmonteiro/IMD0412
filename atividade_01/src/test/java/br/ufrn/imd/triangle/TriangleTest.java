package br.ufrn.imd.triangle;

import org.junit.BeforeClass;
import org.junit.Test;

import br.ufrn.imd.triangle.Triangle.TriangleType;

import org.junit.Assert;

public class TriangleTest {
	private static Triangle t;
	
	@BeforeClass
	public static void setUpBeforeClass() {
		t = new Triangle();
	}

	@Test
	public void triangleShouldBeNotTriangle() {
		// ​Configuração
		final Integer s1 = 50;
		final Integer s2 = 10;
		final Integer s3 = 10;
		
		// ​Açãofinal
		final TriangleType actualType = t.defineType(s1, s2, s3);
		
		// ​Verificação
		Assert.assertEquals(TriangleType.NOT_TRIANGLE, actualType);
	}

	@Test
	public void triangleShouldBeEquilateral() {
		// ​Configuração
		final Integer s1 = 10;
		final Integer s2 = 10;
		final Integer s3 = 10;
		
		// ​Açãofinal
		final TriangleType actualType = t.defineType(s1, s2, s3);
		
		// ​Verificação
		Assert.assertEquals(TriangleType.EQUILATERAL, actualType);
	}

	@Test
	public void triangleShouldBeIsoceles() {
		// ​Configuração
		final Integer s1 = 5;
		final Integer s2 = 10;
		final Integer s3 = 10;
		
		// ​Açãofinal
		final TriangleType actualType = t.defineType(s1, s2, s3);
		
		// ​Verificação
		Assert.assertEquals(TriangleType.ISOCELES, actualType);
	}

	@Test
	public void triangleShouldBeScalene() {
		// ​Configuração
		final Integer s1 = 5;
		final Integer s2 = 10;
		final Integer s3 = 15;
		
		// ​Açãofinal
		final TriangleType actualType = t.defineType(s1, s2, s3);
		
		// ​Verificação
		Assert.assertEquals(TriangleType.SCALENE, actualType);
	}

}
