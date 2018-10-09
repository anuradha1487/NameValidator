import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

public class TestNameValidatorRunnable {
	private NameValidatorRunnable name;

	@Ignore
	@Test
	public void validateTestName() {
		name = new NameValidatorRunnable("Hello_A_07121987_99.csv");
		name.run();
		String expected = "File 'Hello_A_07121987_99.csv' failed validation.Prefix for the file should be ‘Test’ found ‘Hello’.";
		String actual = name.getResult();
		if (expected.equals(actual)) {
			System.out.println("*******");
		}
		assertEquals(expected, actual);

	}


	@Test
	public void validateportfolioCode() {
		name = new NameValidatorRunnable("Test_E_07121987_00.csv");
		name.run();
		String expected = "File 'Test_E_07121987_00.csv' failed validation.PortfolioCode should be A/B/C found E.";
		String actual = name.getResult();
		assertEquals(expected, actual);
	}

	@Test
	public void validateDataFormat() {
		name = new NameValidatorRunnable("Test_A_12131987_02.csv");
		name.run();
		String expected = "File 'Test_A_12131987_02.csv' failed validation.Valuation Date is not a valid date format 'ddmmyyyy’.";
		String actual = name.getResult();
		assertEquals(expected, actual);
	}


	@Test
	public void validateExt() {
		name = new NameValidatorRunnable("Test_A_07121987_23.txt");
		name.run();
		String expected = "File 'Test_A_07121987_23.txt' failed validation.Invalid File format.Expected ‘csv' found txt .";
		String actual = name.getResult();
		assertEquals(expected, actual);
	}


	@Test
	public void validateFormat() {
		name = new NameValidatorRunnable("Test.txt");
		name.run();
		String expected = "File 'Test.txt' failed validation.File format should be 'Test_<portfoliocode>_<ddmmyyyy>_<2digit-sequencenumber>.csv'";
		String actual = name.getResult();
		assertEquals(expected, actual);
	}

}
