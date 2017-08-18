package wilson.justin.slither.content.items;

/**
 * 
 * @author Phantasye
 *
 */
public class ItemComponent {

	// The item id value
	private int id;
	
	// The item amount value
	private int amount;
	
	public ItemComponent(int id, int amount) {
		this.id= id;
		this.amount = amount;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}
