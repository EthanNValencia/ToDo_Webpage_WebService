package com.hibernate.ws;

/***
 * This is a class for sending data to the web service. 
 * @author Ethan J Nephew
 */
public class Data {
	
	private String priority; 
	private String completeDate;
	private String description;
	
	/***
	 * Accessor for the priority. 
	 * @return Returns the priority. 
	 */
	public String getPriority() {
		return priority;
	}
	
	
	/***
	 * Mutator for the priority. 
	 * @param priority Assigns the given string to the priority. 
	 */
	public void setPriority(String priority) {
		this.priority = priority;
	}
	
	/***
	 * Accessor for the complete date. 
	 * @return Returns the complete date. 
	 */
	public String getCompleteDate() {
		return completeDate;
	}
	
	/***
	 * Mutator for the complete date. 
	 * @param priority Assigns the given string to the complete date. 
	 */
	public void setCompleteDate(String completeDate) {
		this.completeDate = completeDate;
	}
	
	/***
	 * Accessor for the description. 
	 * @return Returns the description. 
	 */
	public String getDescription() {
		return description;
	}
	
	/***
	 * Mutator for the description. 
	 * @param priority Assigns the given string to the description. 
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/***
	 * Three parameter constructor for the Data object. Fills all class parameters. 
	 * @param priority String that will be assigned as the priority. 
	 * @param completeDate String that will be assigned as the complete date. 
	 * @param description String that will be assigned as the description. 
	 */
	public Data(String priority, String completeDate, String description) {
		super();
		this.priority = priority;
		this.completeDate = completeDate;
		this.description = description;
	} 
	
	/***
	 * Default zero parameter constructor. 
	 */
	public Data() {
		// Default Constructor
	}
	
	/***
	 * Overridden toString method. 
	 */
	@Override
	public String toString() {
		return "Data [priority=" + priority + ", completeDate=" + completeDate + ", description=" + description + "]";
	}
	
}
