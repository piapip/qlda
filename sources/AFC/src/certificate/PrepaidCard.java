package certificate;

/**
 * The Class PrepaidCard.
 */
public class PrepaidCard extends Certificate{

	/** The balance. */
	private double balance;
	
	/**
	 * Instantiates a new prepaid card.
	 *
	 * @param id the id
	 * @param balance the balance
	 */
	public PrepaidCard(String id, double balance) {
		super(id, Config.PREPAID_TYPE);
		this.balance = balance;
	}

	/**
	 * Gets the balance.
	 *
	 * @return the balance
	 */
	public double getBalance() {
		return this.balance;
	}
}

