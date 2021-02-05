package br.ufrn.imd.triangle;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import br.ufrn.imd.triangle.Triangle.TriangleType;

@RunWith(Parameterized.class)
public class TriangleFullTestParameterized {
	private static Triangle t;
	
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
			{1, 1, 1, TriangleType.EQUILATERAL, null},
			{4, 2, 4, TriangleType.ISOCELES, null},
			{3, 2, 4, TriangleType.SCALENE, null},
			{3, 9, 4, TriangleType.NOT_TRIANGLE, null},
			{7, 7, 7, TriangleType.EQUILATERAL, null},
			{7, 2, 7, TriangleType.ISOCELES, null},
			{3, 5, 7, TriangleType.SCALENE, null},
			{7, 77, 777, TriangleType.NOT_TRIANGLE, null},
			{null, 1, 1, null, NullPointerException.class},
			{1, null, 1, null, NullPointerException.class},
			{1, 1, null, null, NullPointerException.class},
			{-1, 1, 1, null, IllegalArgumentException.class},
			{1, -1, 1, null, IllegalArgumentException.class},
			{1, 1, -1, null, IllegalArgumentException.class},
		});
	}
	
	@BeforeClass
	public static void setUpBeforeClass() {
		t = new Triangle();
	}
	
	@Parameter(0)
	public Integer s1;
	
	@Parameter(1)
	public Integer s2;
	
	@Parameter(2)
	public Integer s3;
	
	@Parameter(3)
	public TriangleType expectedType;
	
	@Parameter(4)
	public Class<? extends Exception> expectedException;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void triangleTypeTestTemplate() {
		// Verificação se for exceção
		if (expectedException != null) {
			thrown.expect(expectedException);
		}
		
		// Ação
		final TriangleType actualType = t.defineType(s1, s2, s3);
		
		// Verificação
		Assert.assertEquals(expectedType, actualType);
	}
}