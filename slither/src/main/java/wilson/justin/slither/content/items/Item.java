package wilson.justin.slither.content.items;

import wilson.justin.slither.content.items.def.ItemDefinition;

/**
 * 
 * @author Phantasye
 *
 */
public class Item {

    private final ItemDefinition definition;
    
    
    public Item(ItemDefinition definition) {
    	this.definition = definition;
    }


    public ItemDefinition getDefinition() {
    	return definition;
    }
   
}
