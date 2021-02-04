package imd0412.academic;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GradeModuleNormalTest {

	@Test
	public void test() {
		final Float grade1 = 4.7f;
		final Float grade2 = 5.1f;
		final Float grade3 = 6.0f;
		final Integer attendanceFrequency = 80;

		final ApprovalStatus status = GradeModule.performPartialConsolidation(grade1, grade2, grade3,
				attendanceFrequency);

		assertEquals(ApprovalStatus.APRN, status);
	}

}
