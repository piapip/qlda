package history;

/**
 * The Class History.
 */
public class History {

	private int id;

	private String certificateId;

	private int status;

	private String dayIn;

	private String dayOut;

	private int embarkingStationID;

	private int endingStationID;
	
	/**
	 * Instantiates a new history.
	 *
	 * @param id the id
	 * @param certificateId the certificate id
	 * @param status the status
	 * @param dayIn the day in
	 * @param dayOut the day out
	 * @param embarkingStationID the embarking station ID
	 * @param endingStationID the ending station ID
	 */
	public History(int id, String certificateId, int status, String dayIn, String dayOut, int embarkingStationID, int endingStationID) {
		this.id = id;
		this.certificateId = certificateId;
		this.status = status;
		this.dayIn = dayIn;
		this.dayOut = dayOut;
		this.embarkingStationID = embarkingStationID;
		this.endingStationID = endingStationID;
	}

	/**
	 * Gets the certificate id.
	 *
	 * @return the certificate id
	 */
	protected String getCertificateId() {
		return certificateId;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
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
	 * Gets the day in.
	 *
	 * @return the day in
	 */
	public String getDayIn() {
		return dayIn;
	}
	
	/**
	 * Gets the day out.
	 *
	 * @return the day out
	 */
	public String getDayOut() {
		return dayOut;
	}
	
	/**
	 * Gets the embarking station ID.
	 *
	 * @return the embarking station ID
	 */
	public int getEmbarkingStationID() {
		return embarkingStationID;
	}
	
	/**
	 * Gets the ending station ID.
	 *
	 * @return the ending station ID
	 */
	public int getEndingStationID() {
		return endingStationID;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		String result = "";
		result = result + "CertificateId: " + this.certificateId + "\n";
		if(this.dayIn != null) result = result + "Day in: " + this.dayIn + "\n";
		if(this.dayOut != null) result = result + "Day out: " + this.dayOut + "\n";
		return result;
	}
}
