package requirements;

import java.sql.SQLException;

import certificate.Hour24Ticket;
import certificate.TicketDBGateway;
import history.HistoryDBGateway;
import interactor.RequirementInterface;

/**
 * The Class RequirementHour24Ticket.
 */
public class RequirementHour24Ticket implements RequirementInterface{

	private TicketDBGateway ticketGW;
	
	private HistoryDBGateway historyGW;

	/**
	 * Instantiates a new requirement for 24-hour ticket.
	 *
	 * @param ticketMapper the ticket mapper
	 * @param historyMapper the history mapper
	 */
	public RequirementHour24Ticket(TicketDBGateway ticketMapper, HistoryDBGateway historyMapper) {
		this.ticketGW = ticketMapper;
		this.historyGW = historyMapper;
	}
	
	/**
	 * Check if the 24-hour ticket can be used to enter the station.
	 *
	 * @param certificateId the 24-hour ticket id
	 * @return the string represent the result
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	@Override
	public String passEntering(String certificateId) throws ClassNotFoundException, SQLException {
		Hour24Ticket ticket = (Hour24Ticket) ticketGW.getCertificateById(certificateId);
		if (ticket == null) return "Ticket doesn't exist. Please buy a new one.";
		if(ticket.getStatus() == Config.EXPIRED) {
			return "The ticket is already used.";
		}
		if(historyGW.getLastHistoryByCertificateId(certificateId).getStatus() != Config.UNUSED || 
				historyGW.getLastHistoryByCertificateId(certificateId).getStatus() != Config.SUCCESSFUL) {
			return "You can't enter the station with this ticket.";
		}
		return null;
	}

	/**
	 * Check if the 24-hour ticket can be used to exit the station.
	 *
	 * @param certificateId the 24-hour ticket id
	 * @param fee the fee
	 * @return the string represent the result
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	@Override
	public String passExiting(String certificateId, double fee) throws ClassNotFoundException, SQLException {
		Hour24Ticket ticket = (Hour24Ticket) ticketGW.getCertificateById(certificateId);
		if (ticket == null) return "Ticket doesn't exist. Please buy a new one.";
		if(ticket.getStatus() == Config.EXPIRED) {
			return "The ticket is already used.";
		}
		if (historyGW.getLastHistoryByCertificateId(certificateId).getStatus() != Config.PENDING) {
			return "You can't exit the station with this ticket.";
		}
		if (ticket.isExpired()) 
			return "The ticket is outdated! It can't be used anymore";
		return null;
	}
}

