package certificate;

/**
 * The Class OnewayTicket.
 */
public class OnewayTicket extends Certificate {
	
	/** The status. */
	private int status;
	
	/** The starting station. */
	private int startingStation;
	
	/** The ending station. */
	private int endingStation;
	
	/** The fare. */
	private double fare;
	
	/**
	 * Instantiates a new oneway ticket.
	 *
	 * @param onewayId the oneway id
	 * @param status the status
	 * @param startingStation the starting station
	 * @param endingStation the ending station
	 * @param fare the fare
	 */
	public OnewayTicket(String onewayId, int status, int startingStation, int endingStation, double fare) {
		super(onewayId, Config.ONEWAY_TYPE);
		this.status = status;
		this.startingStation = startingStation;
		this.endingStation = endingStation;
		this.fare = fare;
	}
	
	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public int getStatus() {
		return this.status;
	}
	
	/**
	 * Gets the starting station.
	 *
	 * @return the starting station
	 */
	public int getStartingStation() {
		return startingStation;
	}

	/**
	 * Gets the ending station.
	 *
	 * @return the ending station
	 */
	public int getEndingStation() {
		return endingStation;
	}

	/**
	 * Gets the fare.
	 *
	 * @return the fare
	 */
	public double getFare() {
		return fare;
	}
}
