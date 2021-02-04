package br.ufrn.imd.triangle;

public class Triangle {

	public enum TriangleType {
		NOT_TRIANGLE, EQUILATERAL, ISOCELES, SCALENE;
	}

	public Triangle() {
		super();
	}

	private boolean allEqualSides(Integer s1, Integer s2, Integer s3) {
		return s1 == s2 && s2 == s3;
	}

	private boolean anyNegative(Integer s1, Integer s2, Integer s3) {
		return s1 < 0 || s2 < 0 || s3 < 0;
	}

	private boolean anyNull(Integer s1, Integer s2, Integer s3) {
		return s1 == null || s2 == null || s3 == null;
	}

	public TriangleType defineType(Integer s1, Integer s2, Integer s3) {
		if (anyNull(s1, s2, s3)) {
			throw new NullPointerException();
		}

		if (anyNegative(s1, s2, s3)) {
			throw new IllegalArgumentException();
		}

		if (oneSideLargerThanSumOfOthers(s1, s2, s3)) {
			return TriangleType.NOT_TRIANGLE;
		}
		else if (allEqualSides(s1, s2, s3)) {
			return TriangleType.EQUILATERAL;
		}
		else if (twoEqualSides(s1, s2, s3)) {
			return TriangleType.ISOCELES;
		}
		else {
			return TriangleType.SCALENE;
		}
	}

	private boolean oneSideLargerThanSumOfOthers(Integer s1, Integer s2, Integer s3) {
		return s1 > s2 + s3 || s2 > s1 + s3 || s3 > s1 + s2;
	}

	private boolean twoEqualSides(Integer s1, Integer s2, Integer s3) {
		return s1 == s2 || s1 == s3 || s2 == s3;
	}
}
