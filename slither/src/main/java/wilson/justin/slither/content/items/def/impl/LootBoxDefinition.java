package wilson.justin.slither.content.items.def.impl;

import wilson.justin.slither.content.loot.Loot;
import wilson.justin.slither.util.LootUtils;

/**
 * 
 * @author Phantasye
 *
 */
public class LootBoxDefinition extends ConsumableDefinition {

	private Loot[] loot = LootUtils.getPreDefinedLoot();

	public Loot[] getLoot() {
		return loot;
	}

	public void setLoot(Loot[] loot) {
		this.loot = loot;
	}

}
