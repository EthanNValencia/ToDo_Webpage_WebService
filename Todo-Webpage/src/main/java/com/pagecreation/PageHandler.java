/*
Ethan Nephew
Due: October 11, 2021
PageHandler.java
*/

package com.pagecreation;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.client.ClientConfig;

/***
 * This class is behind the front page. It populates the rows in the table. It also begins data deletion and addition. 
 * @author Ethan J. Nephew
 */
public class PageHandler {
	
	/***
	 * This is used by the display page to initiate the data insertion process. It conducts basic checks, if the data passes those checks, then it is sent to the Web Service.
	 * @param priority The priority of the item. 
	 * @param description The description of the item. 
	 * @param completeDate The completion date of the item. 
	 */
	public static void addItem(String priority, String description, String completeDate) {
		try {
			checkInputs(priority, description, completeDate);
			// AccessorFacade accessor = new AccessorFacade();
			// accessor.addToDoItem(priority, description, completeDate);
			// SEND TO RESTFUL WEB SERVICE HERE
			String url = "http://localhost:8080/Todo-RESTful-Hibernate-WebService-TOMCAT/rest/todo/db";
			ClientConfig config = new ClientConfig();
			Client client = ClientBuilder.newClient(config);	
			WebTarget target = client.target(url);
			// CREATE OBJECT
	        Data data = new Data();
	        data.setPriority(priority);
	        data.setCompleteDate(completeDate);
	        data.setDescription(description);
			// SEND OBJECT
			target.request().post(Entity.json(data));
		} catch (LengthException | NullException e) {
			e.printStackTrace();
		}
	}
	
	
	/***
	 * This is a simple and lightweight input checker for the interface layer. If the data entries would fail upon a database insertion attempt, then they will be rejected. This should minimize the amount of unnecessary service requests. 
	 * @param priority The priority of the item. 
	 * @param description The description of the item. 
	 * @param completeDate The completion date of the item. 
	 * @throws LengthException This exception is thrown if the size of the data is too large. 
	 * @throws NullException This exception is thrown if the data is either empty or null. 
	 */
	public static void checkInputs(String priority, String description, String completeDate) throws LengthException, NullException {
		
		if(description == null && priority == null && completeDate == null) {
			throw new NullException();
		}
		
		if(description == "" && priority == "" && completeDate == "") {
			throw new NullException();
		}
		
		if(priority.length() > 6 || description.length() > 50 || completeDate.length() > 10) {
			throw new LengthException();
		}
		
	}
	
	/***
	 * Initiates the deletes of specified a item based on database id through a service request. 
	 * @param id Requires the database id number to be deleted.
	 */
	public static void deleteItem(String id) {
		if(id != null) {
			if(id != "") {
				String url = "http://localhost:8080/Todo-RESTful-Hibernate-WebService-TOMCAT/rest/todo/db/" + id;
				ClientConfig config = new ClientConfig();
				Client client = ClientBuilder.newClient(config);	
				WebTarget target = client.target(url);
				// target.request().delete(String.class);
				// target.path(url).request().delete();
				client.target(url).property(url, target).request().delete();
			}
		}
	}
	
	/***
	 * Initiates the data request to the web service that will return the table rows. 
	 * @return returns the prepared HTML row codes.
	 */
	public static String addRows() {
		String url = "http://localhost:8080/Todo-RESTful-Hibernate-WebService-TOMCAT/rest/todo/db";
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);	
		WebTarget target = client.target(url);
		String resource = target.request().accept(MediaType.TEXT_PLAIN).get(String.class);
		return resource;
	}
}
