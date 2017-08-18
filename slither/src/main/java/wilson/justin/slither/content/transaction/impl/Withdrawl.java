package wilson.justin.slither.content.transaction.impl;

import wilson.justin.slither.content.transaction.AbstractTransaction;
import wilson.justin.slither.content.transaction.Currency;
import wilson.justin.slither.entity.player.Player;

/**
 * 
 * @author Phantasye
 *
 */
public class Withdrawl extends AbstractTransaction {

	public Withdrawl(int amount) {
		super(amount);
	}

	@Override
	public void transact(Player transactor, Currency.Type currency) {
		if (transactor.getCurrency(currency).getTotal() >= this.getAmount()) {
			transactor.getCurrency(currency).remove(this.getAmount());
			//TODO send chat message
			System.out.println(this.getAmount() + " " + currency + " removed from your balance. New balance: "
					+ transactor.getCurrency(currency).getTotal());
		} else {
			throw new NullPointerException("Insufficient funds. " + this.getAmount() + " " + currency + " needed.");
		}
	}

}