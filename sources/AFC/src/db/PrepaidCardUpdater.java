package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import interactor.TicketUpdater;

/**
 * The Class PrepaidCardUpdater.
 */
public class PrepaidCardUpdater implements TicketUpdater {

	/**
	 * Update certificate enter.
	 *
	 * @param certificateId the certificate id
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	@Override
	public void updateCertificateEnter(String certificateId) throws ClassNotFoundException, SQLException {
		Connection connection = ConnectToMySQL.getInformation("travelling_certificate");
		Statement statement = connection.createStatement();
		String sql = "UPDATE prepaid_card SET status=" + Config.PENDING + " WHERE id=\"" + certificateId + "\"";
		statement.executeUpdate(sql);
		connection.close();
	}

	/**
	 * Update certificate exit.
	 *
	 * @param certificateId the certificate id
	 * @param fee the fee
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	@Override
	public void updateCertificateExit(String certificateId, double fee) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection connection = ConnectToMySQL.getInformation("travelling_certificate");
		Statement statement = connection.createStatement();
		double newBalance = getBalance(certificateId) - fee;
		String sql = "UPDATE prepaid_card SET balance=\"" + newBalance +"\" WHERE id=\"" + certificateId + "\"";
		statement.executeUpdate(sql);
		connection.close();
		String statusUpdater = "UPDATE prepaid_card SET status=" + Config.UNUSED + " WHERE id=\"" + certificateId + "\"";
		statement.executeUpdate(statusUpdater);
		connection.close();		
	}
	
	/**
	 * Gets the balance.
	 *
	 * @param certificateId the certificate id
	 * @return the balance
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	private double getBalance(String certificateId) throws ClassNotFoundException, SQLException {
		Connection connection = ConnectToMySQL.getInformation("travelling_certificate");
		Statement statement = connection.createStatement();
		String sql = "Select * from prepaid_card WHERE id='" + certificateId + "'";
		ResultSet rs = statement.executeQuery(sql);
		double result = 0;
		if(rs != null) {
			while(rs.next()){
				result = rs.getDouble(2);
			}
		}
		connection.close();
		return result;
	}

}
