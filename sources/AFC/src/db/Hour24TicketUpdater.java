package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import interactor.TicketUpdater;

/**
 * The Class Hour24TicketUpdater.
 */
public class Hour24TicketUpdater implements TicketUpdater {

	/**
	 * Update 24-hour ticket status to "enter".
	 *
	 * @param certificateId the certificate id
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	@Override
	public void updateCertificateEnter(String certificateId) throws ClassNotFoundException, SQLException {
		Connection connection = ConnectToMySQL.getInformation("travelling_certificate");
		Statement statement = connection.createStatement();
		String sql1 = "UPDATE hour24_ticket SET status=\"" + Config.PENDING +  "\" WHERE id=\"" + certificateId+ "\"";
		statement.executeUpdate(sql1);
		String sql2 = "Select activeTime from hour24_ticket WHERE id='" + certificateId + "'";
		ResultSet rs = statement.executeQuery(sql2);
		if (rs != null) {
			while(rs.next()){
				String activeTime = rs.getString(1);
				if (activeTime == null) {
					String sql3 = "UPDATE hour24_ticket SET activeTime=\"" + getActiveTime()+   "\" WHERE id=\"" + certificateId + "\"";
					String sql4 = "UPDATE hour24_ticket SET expiredTime=\"" + getExpiredTime()+   "\" WHERE id=\"" + certificateId + "\"";
					statement.executeUpdate(sql3);
					statement.executeUpdate(sql4);
				}
			}
		}
		connection.close();
	}

	/**
	 * Update 24-hour ticket status to "exit".
	 *
	 * @param certificateId the certificate id
	 * @param fee 24-hour ticket fee
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	@Override
	public void updateCertificateExit(String certificateId, double fee) throws ClassNotFoundException, SQLException {
		Connection connection = ConnectToMySQL.getInformation("travelling_certificate");
		Statement statement = connection.createStatement();
		String sql1 = "UPDATE hour24_ticket SET status=\"" + Config.SUCCESSFUL +  "\" WHERE id=\"" + certificateId + "\"";
		statement.executeUpdate(sql1);
		connection.close();

	}
	
	/**
	 * Gets the active time.
	 *
	 * @return the active time
	 */
	private static String getActiveTime() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime dateActive = LocalDateTime.now();
		return dtf.format(dateActive);
	}
	
	/**
	 * Gets the expired time.
	 *
	 * @return the expired time
	 */
	private static String getExpiredTime() {
		Calendar expTime = Calendar.getInstance();
		SimpleDateFormat dtf  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		expTime.add(Calendar.DAY_OF_MONTH, 1);
		Date dateExpired = (Date) expTime.getTime();
		return dtf.format(dateExpired.getTime()); 
	}
}
