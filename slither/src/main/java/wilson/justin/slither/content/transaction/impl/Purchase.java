package wilson.justin.slither.content.transaction.impl;

import wilson.justin.slither.content.transaction.Currency.Type;
import wilson.justin.slither.content.transaction.Transaction;
import wilson.justin.slither.entity.player.Player;

/**
 * 
 * @author Phantasye
 *
 */
public class Purchase implements Transaction {
	
	private final long productCode;
	private final int amount;
	private final int unitPrice;
	
	public Purchase(long productCode, int amount, int unitPrice) {
		this.productCode = productCode;
		this.amount = amount;
		this.unitPrice = unitPrice;
	}

	@Override
	public void transact(Player transactor, Type currency) {
		transactor.getCurrency(currency).remove(amount * unitPrice);
	}

	public long getProductCode() {
		return productCode;
	}

	public int getAmount() {
		return amount;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

}
