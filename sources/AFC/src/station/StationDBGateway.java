package station;

import java.sql.SQLException;

/**
 * The Interface StationDBGateway.
 */
public interface StationDBGateway {
	
	/**
	 * Gets the station by id.
	 *
	 * @param id the id
	 * @return the station by id
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	public Station getStationById(int id) throws ClassNotFoundException, SQLException;
}
