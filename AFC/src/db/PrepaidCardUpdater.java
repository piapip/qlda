package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import interactor.TicketUpdater;

public class PrepaidCardUpdater implements TicketUpdater {

	@Override
	public void updateCertificateEnter(String certificateId) throws ClassNotFoundException, SQLException {
		Connection connection = ConnectToMySQL.getInformation("travelling_certificate");
		Statement statement = connection.createStatement();
		String sql = "UPDATE prepaid_card SET status=" + Config.PENDING + " WHERE id=\"" + certificateId + "\"";
		statement.executeUpdate(sql);
		connection.close();
	}

	@Override
	public void updateCertificateExit(String certificateId, double fee) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}
	
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
