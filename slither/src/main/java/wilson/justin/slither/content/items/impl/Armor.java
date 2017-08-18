package wilson.justin.slither.content.items.impl;

import wilson.justin.slither.content.items.def.impl.ArmorDefinition;

/**
 * 
 * @author Phantasye
 *
 */
public class Armor extends EquippableItem {
    
    private final ArmorDefinition definition;

    public Armor(ArmorDefinition definition) {
	super(definition);
	this.definition = definition;
    }

    public ArmorDefinition getDefinition() {
	return definition;
    }

}
