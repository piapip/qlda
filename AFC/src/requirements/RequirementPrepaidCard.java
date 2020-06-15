package requirements;

import java.sql.SQLException;

import interactor.RequirementInterface;

public class RequirementPrepaidCard implements RequirementInterface {
	
	private TicketDBGateway cardGateWay;
	private HistoryDBGateway historyGW;
	//	this one left me wondering... shouldn't I specify this initiator already here, the book said that I mustn't do that
	public RequirementPrepaidCard(TicketDBGateway cardMapper, HistoryDBGateway historyMapper) {
		this.cardGateWay = cardMapper;
		this.historyGW = historyMapper;
	}

	@Override
	public String passEntering(String certificateId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String passExiting(String certificateId, double fee) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
