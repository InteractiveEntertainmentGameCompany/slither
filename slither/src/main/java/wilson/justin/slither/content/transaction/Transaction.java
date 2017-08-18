package wilson.justin.slither.content.transaction;

import wilson.justin.slither.entity.impl.Player;

public interface Transaction {

    void transact(Player transactor, Currency.Type currency);
    
}
