package imd0412.academic;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class GradeModuleParametizedTest {

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
			{4.7f, 5.1f, 6.0f, 80, ApprovalStatus.APRN},
			
			{0.0f, 7.5f, 7.5f, 76, ApprovalStatus.REC},
			{10.f, 2.5f, 2.5f, 76, ApprovalStatus.REC},
			
			{7.0f, 7.0f, 7.0f, 75, ApprovalStatus.APR},
			{7.0f, 7.0f, 6.9f, 75, ApprovalStatus.APRN},
			
			{5.0f, 5.0f, 5.0f, 75, ApprovalStatus.APRN},
			{5.0f, 5.0f, 4.9f, 75, ApprovalStatus.REC},
			{6.0f, 6.1f, 2.9f, 75, ApprovalStatus.REC},
			
			{3.0f, 3.0f, 3.0f, 75, ApprovalStatus.REC}, // falha -> REP
			{3.0f, 3.0f, 2.9f, 75, ApprovalStatus.REP},
			
			{7.0f, 7.0f, 7.0f, 74, ApprovalStatus.REPF},
			{7.0f, 7.0f, 6.9f, 74, ApprovalStatus.REPF},
			
			{5.0f, 5.0f, 5.0f, 74, ApprovalStatus.REPF},
			{5.0f, 5.0f, 4.9f, 74, ApprovalStatus.REPF},
			{6.0f, 6.1f, 2.9f, 74, ApprovalStatus.REPF},
			
			{3.0f, 3.0f, 3.0f, 74, ApprovalStatus.REPF}, // falha -> REMF
			{3.0f, 3.0f, 2.9f, 74, ApprovalStatus.REMF},
		});
	}
	
	@Parameter(0)
	public Float grade1;
	
	@Parameter(1)
	public Float grade2;

	@Parameter(2)
	public Float grade3;
	
	@Parameter(3)
	public Integer attendanceFrequency;
	
	@Parameter(4)
	public ApprovalStatus expectedStatus;
	
	@Test
	public void test() {
		// Ação
		final ApprovalStatus status = GradeModule.performPartialConsolidation(grade1, grade2, grade3, attendanceFrequency);

		// Verificação
		assertEquals(expectedStatus, status);
	}

}
