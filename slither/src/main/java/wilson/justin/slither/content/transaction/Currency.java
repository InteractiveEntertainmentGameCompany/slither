package wilson.justin.slither.content.transaction;

/**
 * 
 * @author Phantasye, Justin
 *
 */
public class Currency {
	
	private int total;
	
	public Currency() {
		
	}
	
	public Currency(int total) {
		this.total = total;
	}
	
	// Coins & Snake Points Currency
	public static enum Type {
		COINS, SP;
		
		@Override
		public String toString() {
			return this.name().toLowerCase().substring(0, 1).toUpperCase() + this.name().toLowerCase().substring(1, this.name().length());
		}
	}
	
	public void add(int amt) {
		this.total += amt;
	}
	
	public void remove(int amt) {
		this.total -= amt;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
}
