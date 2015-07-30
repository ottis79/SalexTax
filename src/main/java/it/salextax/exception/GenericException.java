package it.salextax.exception;



/**
 * @author
 * 
 * Generic Exception
 *
 */
public class GenericException extends RuntimeException{
	 
	private static final long serialVersionUID = 1L;
	public String message;

	public GenericException() {
		super();
	}

	public GenericException(String message) {
		this.message=message;
	}

	public String getMessage() {
		if(message!=null)
			if(!message.equalsIgnoreCase("null"))
				return message;
	    return "";
	}

	public void setMessage(String message) {
		this.message = message;
	}	
}
