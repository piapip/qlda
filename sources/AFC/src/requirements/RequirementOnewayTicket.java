package requirements;

import java.sql.SQLException;

import certificate.OnewayTicket;
import certificate.TicketDBGateway;
import history.HistoryDBGateway;
import interactor.RequirementInterface;

/**
 * The Class RequirementOnewayTicket.
 */
public class RequirementOnewayTicket implements RequirementInterface{

	private TicketDBGateway ticketGW;

	private HistoryDBGateway historyGW;
	
	/**
	 * Instantiates a new requirement for one-way ticket.
	 *
	 * @param ticketMapper the ticket mapper
	 * @param historyMapper the history mapper
	 */
	public RequirementOnewayTicket(TicketDBGateway ticketMapper, HistoryDBGateway historyMapper) {
		this.ticketGW = ticketMapper;
		this.historyGW = historyMapper;
	}
	
	/**
	 * Check if the one-way ticket can be used to enter the station.
	 *
	 * @param certificateId the certificate id
	 * @return the string represent the result
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	@Override
	public String passEntering(String certificateId) throws ClassNotFoundException, SQLException {
		OnewayTicket ticket = (OnewayTicket) ticketGW.getCertificateById(certificateId);
		if (ticket == null) return "Ticket doesn't exist. Please buy a new one.";
		if(ticket.getStatus() == Config.EXPIRED) {
			return "The ticket is already used.";
		}
		if(historyGW.getLastHistoryByCertificateId(certificateId).getStatus() != Config.UNUSED) {
			return "You can't enter the station with this ticket.";
		}
		return null;
	}

	/**
	 * Check if the one-way ticket can be used to exit the station.
	 *
	 * @param certificateId the certificate id
	 * @param fee the fee
	 * @return the string represent the result
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	@Override
	public String passExiting(String certificateId, double fee) throws ClassNotFoundException, SQLException {
		OnewayTicket ticket = (OnewayTicket) ticketGW.getCertificateById(certificateId);
		if (ticket == null) return "Ticket doesn't exist. Please buy a new one.";
		if(ticket.getStatus() == Config.EXPIRED) {
			return "The ticket is already used.";
		}
		if (historyGW.getLastHistoryByCertificateId(certificateId).getStatus() != Config.PENDING) {
			return "You can't exit the station with this ticket.";
		}
		if (ticket.getFare() < fee) 
			return "You have gone too far. Please purchase another ticket with the price of " + fee;
		return null;
	}
}

