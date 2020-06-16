package interactor;

import java.sql.SQLException;

/**
 * The Interface HistorySaverInterface.
 */
public interface HistorySaverInterface {
	
	/**
	 * Update embarking station.
	 *
	 * @param certificateId the certificate id
	 * @param stationId the station id
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	public void updateEmbarkingStation(String certificateId, int stationId) throws ClassNotFoundException, SQLException;
	
	/**
	 * Update ending station.
	 *
	 * @param certificateId the certificate id
	 * @param stationId the station id
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	public void updateEndingStation(String certificateId, int stationId) throws ClassNotFoundException, SQLException;
	
	/**
	 * Creates the new history slot.
	 *
	 * @param certificateId the certificate id
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	public void createNewHistorySlot(String certificateId) throws ClassNotFoundException, SQLException;
}
