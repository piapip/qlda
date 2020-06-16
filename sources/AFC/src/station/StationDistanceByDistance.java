package station;

import java.sql.SQLException;

import interactor.StationDistanceInterface;

/**
 * The Class StationDistanceByDistance.
 */
public class StationDistanceByDistance implements StationDistanceInterface{
	
	private StationDBGateway gw;
	
	/**
	 * Instantiates a new station distance by station gateway.
	 *
	 * @param gw the station gateway
	 */
	public StationDistanceByDistance(StationDBGateway gw) {
		this.gw = gw;
	}
	
	/**
	 * Gets the distance between the two stations specified by starting station id and ending station id.
	 *
	 * @param startingStationId the starting station id
	 * @param endingStationId the ending station id
	 * @return the distance
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	@Override
	public double getDistance(int startingStationId, int endingStationId) throws ClassNotFoundException, SQLException {
		Station starting = gw.getStationById(startingStationId);
		Station ending = gw.getStationById(endingStationId);
		return Math.abs(ending.getDistanceToTerminus() - starting.getDistanceToTerminus());
	}
	
}
