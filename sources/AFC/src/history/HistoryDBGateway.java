package history;

import java.sql.SQLException;

/**
 * The Interface HistoryDBGateway.
 */
public interface HistoryDBGateway {
	
	/**
	 * Gets the last history of certificate specified by certificate id.
	 *
	 * @param certificateId the certificate id
	 * @return the last history by certificate id
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	public History getLastHistoryByCertificateId(String certificateId) throws ClassNotFoundException, SQLException;
}
