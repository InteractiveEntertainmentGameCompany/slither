package wilson.justin.slither.content.items.impl;

import wilson.justin.slither.content.items.Item;
import wilson.justin.slither.content.items.def.impl.EquippableDefinition;

/**
 * 
 * @author Phantasye
 *
 */
public class EquippableItem extends Item {

	private final EquippableDefinition definition;

	public EquippableItem(EquippableDefinition definition) {
		super(definition);
		this.definition = definition;
	}

	public EquippableDefinition getDefinition() {
		return definition;
	}

}
