package com.testing.ws;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hibernate.ws.Data;
import com.hibernate.ws.ToDoAbstractFactory;
import com.hibernate.ws.ToDoItem;

/***
 * Unit tests for the RESTful web service. 
 * @author Ethan J. Nephew
 */
class UnitTests {

	/***
	 * Tests that a low todo item is created properly. 
	 */
	@Test
	void test_todoitem_low() {
		ToDoAbstractFactory factory;
        factory = ToDoAbstractFactory.getFactory("Low");
        ToDoItem item = factory.createToDo();
		assertEquals("Low", item.getPriority());
	}
	
	/***
	 * Tests that a medium todo item is created properly. 
	 */
	@Test
	void test_todoitem_medium() {
		ToDoAbstractFactory factory;
        factory = ToDoAbstractFactory.getFactory("Medium");
        ToDoItem item = factory.createToDo();
		assertEquals("Medium", item.getPriority());
	}
	
	/***
	 * Tests that a high todo item is created properly. 
	 */
	@Test
	void test_todoitem_high() {
		ToDoAbstractFactory factory;
        factory = ToDoAbstractFactory.getFactory("High");
        ToDoItem item = factory.createToDo();
		assertEquals("High", item.getPriority());
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
