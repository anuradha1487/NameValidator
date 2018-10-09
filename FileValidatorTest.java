import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class FileValidatorTest {

	private static FileValidator fileVal;

	@BeforeClass
	public static void initFilevalidator() {
		fileVal = new FileValidator();
		fileVal.getPropertyValues();
	}

	@Test
	public void testFileLocation() {
		assertEquals("/Users/anukar/Desktop/Test/", fileVal.fileLocation);
	}

	@Test
	public void testTotalThread() {
		assertEquals(10, fileVal.totalThreads);

	}

}
