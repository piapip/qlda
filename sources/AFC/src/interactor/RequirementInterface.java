package interactor;

import java.sql.SQLException;

/**
 * The Interface RequirementInterface.
 */
public interface RequirementInterface {
	
	/**
	 * Pass entering for certificate specified by id.
	 *
	 * @param certificateId the certificate id
	 * @return the string
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	public String passEntering(String certificateId) throws ClassNotFoundException, SQLException;
	
	/**
	 * Pass exiting for certificate specified by id.
	 *
	 * @param certificateId the certificate id
	 * @param fee the fee
	 * @return the string
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	public String passExiting(String certificateId, double fee) throws ClassNotFoundException, SQLException;
}
