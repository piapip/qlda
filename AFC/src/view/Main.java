package view;

import java.sql.SQLException;
import java.util.Scanner;

import hust.soict.se.customexception.InvalidIDException;
import hust.soict.se.gate.Gate;
import hust.soict.se.recognizer.TicketRecognizer;
import hust.soict.se.scanner.CardScanner;

public class Main {
	public static void main(String[] args) throws ClassNotFoundException, SQLException, InvalidIDException, InterruptedException {
		int stationId;
		int scanOption;
		int enterOrExit;
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);
		Gate gate = Gate.getInstance();
		do {
			do {
				System.out.println("Station ID: ");
				stationId = reader.nextInt();
				reader.nextLine();
			} while(stationId > 9 || stationId < 1);
			
			do {
				System.out.println("Enter or Exit?:\n1. Enter\n2. Exit ");
				enterOrExit = reader.nextInt();
				reader.nextLine();
			} while(enterOrExit > 2 || enterOrExit < 1);
			
			do {
				System.out.println("What are you using?:\n1. Card\n2. Ticket");
				scanOption = reader.nextInt();
				reader.nextLine();
			} while(scanOption > 2 || scanOption < 1);
			
			System.out.println("Please enter your barcode: ");
			String barCode = reader.nextLine();
			
			TicketRecognizer ticketRecognizer = TicketRecognizer.getInstance();
			CardScanner cardScanner = CardScanner.getInstance();
			
			String certificateId;
			if(scanOption == 1) {
				certificateId = cardScanner.process(barCode);
			} else {
				certificateId = ticketRecognizer.process(barCode);
			}
			
			System.out.println(certificateId);
			gate.open();
			Thread.sleep(2000);
			gate.close();
			
		} while(true);
	}
}
