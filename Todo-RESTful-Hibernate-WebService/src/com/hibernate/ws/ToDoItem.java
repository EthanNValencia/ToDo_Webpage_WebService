package com.hibernate.ws;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/***
 * The parent abstract class for a ToDoItem.
 * @author Ethan J. Nephew
 */
@MappedSuperclass
public abstract class ToDoItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="todo_description")
    private String description;
	@Column(name="complete_Date")
    private String completeDate;
	@Column(name="priority")
    protected String priority;
	
	/***
	 * Accessor method for the priority variable. 
	 * @return The priority Low, Medium, High, or Null.
	 */
    public String getPriority() {
		return priority;
	}

    /***
     * Mutator method for the priority variable. 
     * @param priority The string that will be assigned to priority. 
     */
	public void setPriority(String priority) {
		this.priority = priority;
	}

	/***
     * Accessor method for the ToDoItem ID.
     * @return The ToDoItem ID.
     */
    public Long getId() {
		return id;
	}
    
    /***
     * Mutator method for the ToDoItem ID.
     * @param id The ID of the ToDoItem.
     */
	public void setId(Long id) {
		this.id = id;
	}

	/***
     * Accessor method for the ToDoItem description.
     * @return The ToDoItem description.
     */
    public String getDescription() {
        return description;
    }

    /***
     * Mutator method for the ToDoItem description.
     * @param description The description of the ToDoItem.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /***
     * Accessor method for the ToDoItem completion time. The completion time can be a date, like "4-21-2022", but it can also be word like "Today".
     * @return The ToDoItem completion time.
     */
    public String getCompleteDate() {
        return completeDate;
    }

    /***
     * Mutator method for the ToDoItem completion time.
     * @param completeDate The completion time can be a date, like "4-21-2022", but it can also be word like "Today".
     */
    public void setCompleteDate(String completeDate) {
        this.completeDate = completeDate;
    }

    /***
     * Overridden toString from the base object. This is used for display list data of ToDoItems to the user.
     * @return Returns the string that contains data of the contained variables.
     */
    @Override
    public String toString() {
        return "[Description = " + description + ", Completion Date = " + completeDate + ", ID = " + id + ", ";
    }
}