package certificate;

import java.sql.SQLException;

/**
 * The Interface TicketDBGateway.
 */
public interface TicketDBGateway {	
	
	/**
	 * Gets the certificate by id.
	 *
	 * @param id the id
	 * @return the certificate by id
	 * @throws SQLException the SQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	public Certificate getCertificateById(String id) throws SQLException, ClassNotFoundException;
}
