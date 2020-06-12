package station;

import java.sql.SQLException;

import interactor.StationDistanceInterface;

public class StationDistanceByDistance implements StationDistanceInterface{
	
	private StationDBGateway gw;
	//	this one left me wondering... shouldn't I specify this initiator already here, the book said that I mustn't do that
	public StationDistanceByDistance(StationDBGateway gw) {
		this.gw = gw;
	}
	
}
