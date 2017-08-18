package wilson.justin.slither.content.items.impl;

import wilson.justin.slither.content.items.Item;
import wilson.justin.slither.content.items.def.impl.ConsumableDefinition;

/**
 * 
 * @author Phantasye
 *
 */
public class Consumable extends Item {

	private final ConsumableDefinition definition;

	public Consumable(ConsumableDefinition definition) {
		super(definition);
		this.definition = definition;
	}

	public ConsumableDefinition getDefinition() {
		return definition;
	}


}
