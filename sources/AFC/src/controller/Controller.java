package controller;

import java.sql.SQLException;

import history.HistoryDBGateway;
import interactor.HistorySaverInterface;
import interactor.RequirementInterface;
import interactor.StationDistanceInterface;
import interactor.TicketUpdater;

/**
 * The Class Controller.
 */
public class Controller implements ControllerInterface {

	private RequirementInterface req;
	
	private TicketUpdater ticketInt;
	
	private StationDistanceInterface stationInt;
	
	private HistorySaverInterface historyInt;
	
	private HistoryDBGateway historyGW;

	/**
	 * Instantiates a new controller.
	 *
	 * @param req the req
	 * @param ticketInt the ticket int
	 * @param stationInt the station int
	 * @param historyInt the history int
	 * @param historyGW the history GW
	 */
	public Controller(RequirementInterface req, TicketUpdater ticketInt, StationDistanceInterface stationInt, HistorySaverInterface historyInt, HistoryDBGateway historyGW) {
		// TODO Auto-generated constructor stub
		this.req = req;
		this.ticketInt = ticketInt;
		this.stationInt = stationInt;
		this.historyInt = historyInt;
		this.historyGW = historyGW;
	}
	
	/**
	 * Enter.
	 *
	 * @param certificateId the certificate id
	 * @param stationId the station id
	 * @return the string
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	@Override
	public String enter(String certificateId, int stationId) throws ClassNotFoundException, SQLException {
		String error = req.passEntering(certificateId);
		if (error != null) return error;
		ticketInt.updateCertificateEnter(certificateId);
		historyInt.updateEmbarkingStation(certificateId, stationId);
		return null;
	}
	
	/**
	 * Exit.
	 *
	 * @param certificateId the certificate id
	 * @param stationId the station id
	 * @return the string
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	@Override
	public String exit(String certificateId, int stationId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		double distance = stationInt.getDistance(historyGW.getLastHistoryByCertificateId(certificateId).getEmbarkingStationID(), stationId);
		double fee = getFee(distance);
		String error = req.passExiting(certificateId, fee);
		if (error != null) return error;
		ticketInt.updateCertificateExit(certificateId, fee);
		historyInt.updateEndingStation(certificateId, stationId);
		historyInt.createNewHistorySlot(certificateId);
		return null;
	}
	
	/**
	 * Gets the fee.
	 *
	 * @param distance the distance
	 * @return the fee
	 */
	private double getFee(double distance) {
		if(distance <= Config.BASED_DISTANCE) return Config.BASED_FARE;
		else {
			distance = distance - Config.BASED_DISTANCE;
			double cost = Config.BASED_FARE + Config.ADDITIONAL_FARE*Math.ceil(distance/Config.DEFAULT_ADDITION_DISTANCE);
			return cost;
		}
	}
	
}
