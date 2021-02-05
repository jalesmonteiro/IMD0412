package br.ufrn.imd.triangle;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import br.ufrn.imd.triangle.Triangle.TriangleType;

@RunWith(Parameterized.class)
public class TriangleTestParameterized {
	private static Triangle t;
	
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
			{1, 1, 1, TriangleType.EQUILATERAL},
			{4, 2, 4, TriangleType.ISOCELES},
			{3, 2, 4, TriangleType.SCALENE},
			{3, 9, 4, TriangleType.NOT_TRIANGLE},
			{7, 7, 7, TriangleType.EQUILATERAL},
			{7, 2, 7, TriangleType.ISOCELES},
			{3, 5, 7, TriangleType.SCALENE},
			{7, 77, 777, TriangleType.NOT_TRIANGLE},
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
	
	@Test
	public void triangleTypeTestTemplate() {
		// Ação
		final TriangleType actualType = t.defineType(s1, s2, s3);
		
		// Verificação
		Assert.assertEquals(expectedType, actualType);
	}
}