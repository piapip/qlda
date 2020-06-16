package interactor;

import java.sql.SQLException;

/**
 * The Interface TicketUpdater.
 */
public interface TicketUpdater {
	
	/**
	 * Update certificate status to "enter".
	 *
	 * @param certificateId the certificate id
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	public void updateCertificateEnter(String certificateId) throws ClassNotFoundException, SQLException;
	
	/**
	 * Update certificate status to "exit".
	 *
	 * @param certificateId the certificate id
	 * @param fee the fee
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	public void updateCertificateExit(String certificateId, double fee) throws ClassNotFoundException, SQLException;
}
