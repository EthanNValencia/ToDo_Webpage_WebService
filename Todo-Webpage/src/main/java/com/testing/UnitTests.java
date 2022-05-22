package com.testing;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.pagecreation.Data;
import com.pagecreation.LengthException;
import com.pagecreation.NullException;
import com.pagecreation.PageHandler;

/***
 * Unit tests for the client side of the to do web application. 
 * @author Ethan J Nephew
 */
class UnitTests {

	/***
	 * Verifies that the checkInputs method is throwing a NullException given the certain parameters. 
	 * @throws LengthException Exception that is thrown if any of the input string lengths are too long. 
	 * @throws NullException Exception that is thrown if any of the input strings are null or empty. 
	 */
	@Test(expectedExceptions = NullException.class)
	void test_empty_NullException() throws LengthException, NullException {
		PageHandler.checkInputs("", "", "");
		Assert.fail(); // This should not be reached. 
	}
	
	/***
	 * Verifies that the checkInputs method is throwing a NullException given the certain parameters. 
	 * @throws LengthException Exception that is thrown if any of the input string lengths are too long. 
	 * @throws NullException Exception that is thrown if any of the input strings are null or empty.
	 */
	@Test(expectedExceptions = NullException.class)
	void test_null_NullException() throws LengthException, NullException {
		PageHandler.checkInputs(null, null, null);
		Assert.fail(); // This should not be reached. 
	}
	
	/***
	 * Verifies that the checkInputs method is throwing a LengthException given the certain parameters. 
	 * @throws LengthException Exception that is thrown if any of the input string lengths are too long. 
	 * @throws NullException Exception that is thrown if any of the input strings are null or empty.
	 */
	@Test(expectedExceptions = LengthException.class)
	void test_priority_LengthException() throws LengthException, NullException {
		PageHandler.checkInputs("ooooooo", "o", "o");
		Assert.fail(); // This should not be reached. 
	}
	
	/***
	 * Verifies that the checkInputs method is throwing a LengthException given the certain parameters. 
	 * @throws LengthException Exception that is thrown if any of the input string lengths are too long. 
	 * @throws NullException Exception that is thrown if any of the input strings are null or empty.
	 */
	@Test(expectedExceptions = LengthException.class)
	void test_description_LengthException() throws LengthException, NullException {
		PageHandler.checkInputs("o", "ooooooooooooooooooooooooooooooooooooooooooooooooooo", "o");
		Assert.fail(); // This should not be reached. 
	}
	
	/***
	 * Verifies that the checkInputs method is throwing a LengthException given the certain parameters. 
	 * @throws LengthException Exception that is thrown if any of the input string lengths are too long. 
	 * @throws NullException Exception that is thrown if any of the input strings are null or empty.
	 */
	@Test(expectedExceptions = LengthException.class)
	void test_completedate_LengthException() throws LengthException, NullException {
		PageHandler.checkInputs("o", "o", "ooooooooooo");
		Assert.fail(); // This should not be reached. 
	}

	/***
	 * Tests that the three parameter constructor is not null upon instantiation. 
	 */
	@Test
	void test_data_threeparameterconstructor() {
		Data data = new Data("High", "2021-10-10", "Do the dishes.");
		Assert.assertNotNull(data);
	}
	
	/***
	 * Tests that the zero parameter constructor is not assigning default parameters. 
	 */
	@Test
	void test_data_zeroparameterconstructor() {
		Data data = new Data();
		Assert.assertNull(data.getDescription());
		Assert.assertNull(data.getPriority());
		Assert.assertNull(data.getCompleteDate());
	}
	
	/***
	 * Tests that the getPriority method is returning the correct results. 
	 */
	@Test
	void test_data_getPriority() {
		Data data = new Data("High", "2021-10-10", "Do the dishes.");
		Assert.assertEquals("High", data.getPriority());
	}
	
	/***
	 * Tests that the getCompleteDate method is returning the correct results. 
	 */
	@Test
	void test_data_getCompleteDate() {
		Data data = new Data("High", "2021-10-10", "Do the dishes.");
		Assert.assertEquals("2021-10-10", data.getCompleteDate());
	}

	/***
	 * Tests that the getDescription method is returning the correct results. 
	 */
	@Test
	void test_data_getDescription() {
		Data data = new Data("High", "2021-10-10", "Do the dishes.");
		Assert.assertEquals("Do the dishes.", data.getDescription());
	}

}
