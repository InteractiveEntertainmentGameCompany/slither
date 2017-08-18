package wilson.justin.slither.content.transaction;

/**
 * 
 * @author Phantasye
 *
 */
public abstract class AbstractTransaction implements Transaction {

	private int amount;
	
	protected AbstractTransaction(int amount) {
		this.setAmount(amount);
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}
