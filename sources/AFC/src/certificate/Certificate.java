package certificate;

/**
 * The Class Certificate.
 */
public abstract class Certificate {
	
	/** The id. */
	private String id;
	
	/** The type. */
	private int type;
	
	/**
	 * Instantiates a new certificate.
	 *
	 * @param id the id
	 * @param type the type
	 */
	public Certificate(String id, int type) {
		this.id = id;
		this.type = type;
	}	
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getID() {
		return this.id;
	}
	
	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public int getType() {
		return this.type;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {
		String typeName;
		if(this.type == Config.ONEWAY_TYPE) typeName = "Oneway ticket";
		else if(this.type == Config.HOUR24_TYPE) typeName = "24-hour ticket";
		else if(this.type == Config.PREPAID_TYPE) typeName = "Prepaid card";
		else typeName = null;
		return String.format("ID: " + this.id + "\nType: " + typeName);
	}
}
