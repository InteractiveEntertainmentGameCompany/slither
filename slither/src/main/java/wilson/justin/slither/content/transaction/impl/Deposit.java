package wilson.justin.slither.content.transaction.impl;

import wilson.justin.slither.content.transaction.AbstractTransaction;
import wilson.justin.slither.content.transaction.Currency;
import wilson.justin.slither.entity.player.Player;

/**
 * 
 * @author Phantasye
 *
 */
public class Deposit extends AbstractTransaction {

	public Deposit(int amount) {
		super(amount);
	}

	@Override
	public void transact(Player transactor, Currency.Type currency) {
		transactor.getCurrency(currency).add(this.getAmount());
		System.out.println(this.getAmount() + " " + currency + " added to your balance. New balance: "
				+ transactor.getCurrency(currency).getTotal());
	}

}