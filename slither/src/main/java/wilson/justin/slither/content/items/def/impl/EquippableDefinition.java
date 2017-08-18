package wilson.justin.slither.content.items.def.impl;

import wilson.justin.slither.content.items.def.ItemDefinition;

/**
 * 
 * @author Phantasye
 *
 */
public class EquippableDefinition extends ItemDefinition {

	// The slot id of the equippable item type
    private int slot;
    
    private int quality;
    
    public int getSlot() {
        return slot;
    }
    public void setSlot(int slot) {
        this.slot = slot;
    }

	public int getQuality() {
		return quality;
	}
	public void setQuality(int quality) {
		this.quality = quality;
	}
}
