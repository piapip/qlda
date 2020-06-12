package db;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import interactor.TicketUpdater;

public class Hour24TicketUpdater implements TicketUpdater {

	@Override
	public void updateCertificateEnter(String certificateId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCertificateExit(String certificateId, double fee) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}
	
	private static String getActiveTime() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime dateActive = LocalDateTime.now();
		return dtf.format(dateActive);
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println(getActiveTime());
	}

}
