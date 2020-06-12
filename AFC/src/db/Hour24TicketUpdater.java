package db;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

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
	
	private static String getExpiredTime() {
		Calendar expTime = Calendar.getInstance();
		SimpleDateFormat dtf  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		expTime.add(Calendar.DAY_OF_MONTH, 1);
		Date dateExpired = (Date) expTime.getTime();
		return dtf.format(dateExpired.getTime()); 
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println(getExpiredTime());
		System.out.println(getActiveTime().compareTo(getExpiredTime()));
	}

}
