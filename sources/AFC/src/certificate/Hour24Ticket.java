package certificate;

/**
 * The Class Hour24Ticket.
 */
public class Hour24Ticket extends Certificate{
	
	/** The status. */
	private int status;
	
	/** The active time. */
	private String activeTime;
	
	/** The expired time. */
	private String expiredTime;
	
	/**
	 * Instantiates a new hour 24 ticket.
	 *
	 * @param id the id
	 * @param status the status
	 * @param activeTime the active time
	 * @param expiredTime the expired time
	 */
	public Hour24Ticket(String id, int status, String activeTime, String expiredTime) {
		super(id, Config.HOUR24_TYPE);
		this.status = status;
		this.activeTime=activeTime;
		this.expiredTime=expiredTime;
	}
	
	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}
	
	/**
	 * Gets the active time.
	 *
	 * @return the active time
	 */
	public String getActiveTime() {
		return activeTime;
	}
	
	/**
	 * Gets the expired time.
	 *
	 * @return the expired time
	 */
	public String getExpiredTime() {
		return expiredTime;
	}
	
	/**
	 * Checks if is expired.
	 *
	 * @return true, if is expired
	 */
	public boolean isExpired() {
		if((this.getActiveTime()).compareTo(this.getExpiredTime())==-1) return false;
		return true;
	}
}


