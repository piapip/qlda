package db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import interactor.TicketUpdater;

/**
 * The Class OnewayTicketUpdater.
 */
public class OnewayTicketUpdater implements TicketUpdater {

	/**
	 * Update one-way ticket status to "enter".
	 *
	 * @param certificateId the one-way ticket id
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	@Override
	public void updateCertificateEnter(String certificateId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection connection = ConnectToMySQL.getInformation("travelling_certificate");
		Statement statement = connection.createStatement();
		String sql = "UPDATE oneway_ticket SET status=" + Config.PENDING + " WHERE id=\"" + certificateId + "\"";
		statement.executeUpdate(sql);
		connection.close();
	}

	/**
	 * Update one-way ticket status to "exit".
	 *
	 * @param certificateId the certificate id
	 * @param fee the one-way ticket fee
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	@Override
	public void updateCertificateExit(String certificateId, double fee) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection connection = ConnectToMySQL.getInformation("travelling_certificate");
		Statement statement = connection.createStatement();
		String sql = "UPDATE oneway_ticket SET status=" + Config.EXPIRED + " WHERE id=\"" + certificateId + "\"";
		statement.executeUpdate(sql);
		connection.close();
	}

}
