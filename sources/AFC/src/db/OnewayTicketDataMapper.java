package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import certificate.OnewayTicket;
import certificate.TicketDBGateway;

/**
 * The Class OnewayTicketDataMapper.
 */
public class OnewayTicketDataMapper implements TicketDBGateway {
	 
	/**
	 * Gets the one-way ticket by id.
	 *
	 * @param id the id
	 * @return the one-way ticket specified by id if found, null otherwise
	 * @throws SQLException the SQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	@Override
	public OnewayTicket getCertificateById(String id) throws SQLException, ClassNotFoundException {
		Connection connection = ConnectToMySQL.getInformation("travelling_certificate");
		Statement statement = connection.createStatement();
		String sql = "Select * from certificate_info WHERE id='" + id +"'";
		ResultSet rs = statement.executeQuery(sql);
		OnewayTicket result = null;
		if (rs != null) {
			while(rs.next()) {
				int type = rs.getInt(2);
				if (type != Config.ONEWAY_TYPE) {
					System.out.println("This is not an oneway ticket!");
					return null;
				}
				result = new OnewayTicket(id,
						getStatus(id), 
						getStartingStation(id), 
						getEndingStation(id), 
						getFee(id));
			}
		}
		connection.close();
		return result;
	}
	
	/**
	 * Gets the one-way ticket status.
	 *
	 * @param id the one-way ticket id
	 * @return the one-way ticket status
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	private int getStatus(String id) throws ClassNotFoundException, SQLException {
		Connection connection = ConnectToMySQL.getInformation("travelling_certificate");
		Statement statement = connection.createStatement();
		String sql = "Select * from oneway_ticket WHERE id='" + id + "'";
		ResultSet rs = statement.executeQuery(sql);
		int result = 0;
		if(rs != null) {
			while(rs.next()){
				result = rs.getInt(2);
			}
		}
		connection.close();
		return result;
	}
	
	/**
	 * Gets the starting station.
	 *
	 * @param id the id
	 * @return the starting station
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	private int getStartingStation(String id) throws ClassNotFoundException, SQLException {
		Connection connection = ConnectToMySQL.getInformation("travelling_certificate");
		Statement statement = connection.createStatement();
		String sql = "Select * from oneway_ticket WHERE id='" + id + "'";
		ResultSet rs = statement.executeQuery(sql);
		int result = 0;
		if(rs != null) {
			while(rs.next()){
				result = rs.getInt(3);
			}
		}
		connection.close();
		return result;
	}
	
	/**
	 * Gets the ending station.
	 *
	 * @param id the id
	 * @return the ending station
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	private int getEndingStation(String id) throws ClassNotFoundException, SQLException {
		Connection connection = ConnectToMySQL.getInformation("travelling_certificate");
		Statement statement = connection.createStatement();
		String sql = "Select * from oneway_ticket WHERE id='" + id + "'";
		ResultSet rs = statement.executeQuery(sql);
		int result = 0;
		if(rs != null) {
			while(rs.next()){
				result = rs.getInt(4);
			}
		}
		connection.close();
		return result;
	}
	
	/**
	 * Gets the fee.
	 *
	 * @param id the id
	 * @return the fee
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	private double getFee(String id) throws ClassNotFoundException, SQLException {
		Connection connection = ConnectToMySQL.getInformation("travelling_certificate");
		Statement statement = connection.createStatement();
		String sql = "Select * from oneway_ticket WHERE id='" + id + "'";
		ResultSet rs = statement.executeQuery(sql);
		double result = 0;
		if(rs != null) {
			while(rs.next()){
				result = rs.getDouble(5);
			}
		}
		connection.close();
		return result;
	}
	
}
