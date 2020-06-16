package requirements;

import java.sql.SQLException;

import certificate.PrepaidCard;
import certificate.TicketDBGateway;
import history.HistoryDBGateway;
import interactor.RequirementInterface;

/**
 * The Class RequirementPrepaidCard.
 */
public class RequirementPrepaidCard implements RequirementInterface {
	
	private TicketDBGateway cardGateWay;
	
	private HistoryDBGateway historyGW;

	/**
	 * Instantiates a new requirement for prepaid card.
	 *
	 * @param cardMapper the card mapper
	 * @param historyMapper the history mapper
	 */
	public RequirementPrepaidCard(TicketDBGateway cardMapper, HistoryDBGateway historyMapper) {
		this.cardGateWay = cardMapper;
		this.historyGW = historyMapper;
	}

	/**
	 * Check if the prepaid card can be used to enter the station.
	 *
	 * @param certificateId the prepaid card id
	 * @return the string represent the result
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	@Override
	public String passEntering(String certificateId) throws ClassNotFoundException, SQLException {
		PrepaidCard card = (PrepaidCard) cardGateWay.getCertificateById(certificateId);
		if (card == null) return "Card doesn't exist. Please buy a new one.";
		if (card.getBalance() < Config.BASED_FARE) {
			double requirement = Config.BASED_FARE - card.getBalance();
			return "Card's balance is too low. Please recharge: " + requirement;
		}
		if (historyGW.getLastHistoryByCertificateId(certificateId).getStatus() != Config.UNUSED) {
			return "You can't enter the station with this card. Probably stolen card.";
		}
		return null;
	}

	/**
	 * Check if the prepaid card can be used to exit the station.
	 *
	 * @param certificateId the prepaid card id
	 * @param fee the fee
	 * @return the string represent the result
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	@Override
	public String passExiting(String certificateId, double fee) throws ClassNotFoundException, SQLException {
		PrepaidCard card = (PrepaidCard) cardGateWay.getCertificateById(certificateId);
		if (card == null) return "Card doesn't exist. Please buy a new one.";
		if (historyGW.getLastHistoryByCertificateId(certificateId).getStatus() != Config.PENDING) {
			return "You can't enter the station with this card. Probably stolen card.";
		}
		if (card.getBalance() < fee) {
			double requirement = fee - card.getBalance();
			return "Card's balance is too low. Please recharge: " + requirement; 
		}
		return null;
	}

	
}
