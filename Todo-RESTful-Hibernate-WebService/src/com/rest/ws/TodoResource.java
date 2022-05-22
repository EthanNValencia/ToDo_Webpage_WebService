package com.rest.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.hibernate.ws.AccessorFacade;
import com.hibernate.ws.Data;

/***
 * Resource class for the RESTful web service. 
 * @author Ethan J. Nephew
 */
@Path("/todo")
public class TodoResource {

	/***
	 * Returns a test string. Not used in application deployment, but used in testing a development. 
	 * @return Returns a string that contains "test". 
	 */
	@GET
	@Path("test")
	@Produces("text/plain")
	public String test() {
		return "test";
	}
	
	/***
	 * Returns the individual rows that will be displayed in the table. 
	 * @return Returns the row entries for the todo table. 
	 */
	@GET
	@Path("db")
	@Produces("text/plain")
	public String getTable() {
		AccessorFacade af = new AccessorFacade();
		return af.getToDoItemList();
	}
	
	/***
	 * Initiates the deletion of a specified row. 
	 * @param id Requires the id of the row that will be deleted. 
	 */
	@DELETE
	@Path("db/{id}")
	public void deleteRow(@PathParam("id")Integer id) {
		AccessorFacade accessor = new AccessorFacade();
		long deleteId = id;
		accessor.deleteToDoItem(deleteId);
	}

	/***
	 * POST request that handles insertion of a new todo entry. 
	 * @param data Requires the data object. 
	 */
	@POST
	@Path("db")
	@Consumes({MediaType.APPLICATION_JSON})
	public void insertItem(Data data) {
		AccessorFacade accessor = new AccessorFacade();
		accessor.addToDoItem(data.getPriority(), data.getDescription(), data.getCompleteDate());
	}
	
}
