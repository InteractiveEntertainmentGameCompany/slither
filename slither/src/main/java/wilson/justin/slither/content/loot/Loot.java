package wilson.justin.slither.content.loot;

import wilson.justin.slither.content.items.ItemComponent;

public class Loot {

    private ItemComponent item;
    private int chance;
    
    public Loot(ItemComponent item, int chance) {
	this.item = item;
	this.chance = chance;
    }
    
    public ItemComponent getItem() {
	return item;
    }
    public void setItem(ItemComponent item) {
	this.item = item;
    }
    public int getChance() {
	return chance;
    }
    public void setChance(int chance) {
	this.chance = chance;
    }
    
}
