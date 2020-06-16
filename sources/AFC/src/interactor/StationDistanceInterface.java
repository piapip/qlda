package interactor;

import java.sql.SQLException;

/**
 * The Interface StationDistanceInterface.
 */
public interface StationDistanceInterface {
	
	/**
	 * Gets the distance between the two stations specified by station IDs.
	 *
	 * @param startingStationId the starting station id
	 * @param endingStationId the ending station id
	 * @return the distance
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	public double getDistance(int startingStationId, int endingStationId) throws ClassNotFoundException, SQLException;
}
