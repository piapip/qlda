package controller;

import java.sql.SQLException;

/**
 * The Interface ControllerInterface.
 */
public interface ControllerInterface {
	
	/**
	 * Enter.
	 *
	 * @param certificateId the certificate id
	 * @param stationId the station id
	 * @return the string
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	public String enter(String certificateId, int stationId) throws ClassNotFoundException, SQLException;
	
	/**
	 * Exit.
	 *
	 * @param certificateId the certificate id
	 * @param stationId the station id
	 * @return the string
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	public String exit(String certificateId, int stationId) throws ClassNotFoundException, SQLException;
}
