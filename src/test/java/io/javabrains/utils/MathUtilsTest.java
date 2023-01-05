package io.javabrains.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

class MathUtilsTest {
	
	private MathUtils mathUtils;
	
	
	@BeforeEach
	void initEach(TestInfo testInfo, TestReporter testReporter) {
		testReporter.publishEntry(testInfo.getDisplayName()+ " starts");
		mathUtils = new MathUtils();
	}

	@Nested
	class AddTest {
		@Test
		void testAddingTwoPositives() {
			assertEquals(2, mathUtils.add(1, 1), 
					"Add method should return the sum of two numbers");
		}
		
		@RepeatedTest(3)
		void testAddingTwoNegatives(RepetitionInfo repetitionInfo) {
			System.out.println("Repetition :" + repetitionInfo.getCurrentRepetition());
			assertEquals(-2, mathUtils.add(-1, -1), 
					"Add method should return the sum of two numbers");
		}
		
		@Test
		void testAddingAPositiveAndANegative() {
			assertEquals(0, mathUtils.add(-1, 1), 
					"Add method should return the sum of two numbers");
		}
	}
	
	@Test 
	void testMultiply() {
		assertAll(
				() -> assertEquals(0, mathUtils.multiply(1, 0)),
				() -> assertEquals(1, mathUtils.multiply(1, 1)),
				() -> assertEquals(6, mathUtils.multiply(2, 3))
				);
	}
	
	@Test 
	void computeCircleArea() {
		assertEquals(314.1592653589793, mathUtils.computeCircleArea(10), 
				"Should return right circle area");
	}
	
	@Test
	void testDivide() {
		assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0), 
				"Divide should throw ArithmeticException when denominator is zero");
	}
	
	
}