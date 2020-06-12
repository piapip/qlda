package controller;

import java.sql.SQLException;

import history.HistoryDBGateway;
import interactor.HistorySaverInterface;
import interactor.RequirementInterface;
import interactor.StationDistanceInterface;
import interactor.TicketUpdater;

public class Controller implements ControllerInterface {

	private RequirementInterface req;
	private TicketUpdater ticketInt;
	private StationDistanceInterface stationInt;
	private HistorySaverInterface historyInt;
	private HistoryDBGateway historyGW;

}
