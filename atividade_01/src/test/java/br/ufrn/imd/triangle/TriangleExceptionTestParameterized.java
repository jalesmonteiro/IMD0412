package br.ufrn.imd.triangle;

import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TriangleExceptionTestParameterized {
	private static Triangle t;
	
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
			{null, 1, 1, NullPointerException.class},
			{1, null, 1, NullPointerException.class},
			{1, 1, null, NullPointerException.class},
			{-1, 1, 1, IllegalArgumentException.class},
			{1, -1, 1, IllegalArgumentException.class},
			{1, 1, -1, IllegalArgumentException.class},
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
	public Class<? extends Exception> expectedException;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void triangleExceptionTestTemplate() throws NullPointerException, IllegalArgumentException {
		// Verificação
		thrown.expect(expectedException);
		
		// Ação
		t.defineType(s1, s2, s3);
	}
}