package wilson.justin.slither.content.items.impl;

import java.util.Random;

import wilson.justin.slither.content.items.def.impl.LootBoxDefinition;
import wilson.justin.slither.content.loot.Loot;

/**
 * 
 * @author Phantasye
 *
 */
public class LootBox extends Consumable {

	private final LootBoxDefinition definition;

	public LootBox(LootBoxDefinition definition) {
		super(definition);
		this.definition = definition;
	}

	public LootBoxDefinition getDefinition() {
		return definition;
	}

	public Loot open() {
		final Random r = new Random();
		float chance = r.nextFloat();
		final int index = r.nextInt(definition.getLoot().length);
		System.out.println("chance " + chance);
		System.out.println("loot " + definition.getLoot()[index].getChance() * .01);
		if (chance <= (definition.getLoot()[index].getChance() * .01)) {
			return definition.getLoot()[index];
		}
		return open();
	}
}
