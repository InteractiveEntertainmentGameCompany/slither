package wilson.justin.slither.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import wilson.justin.slither.content.items.Item;
import wilson.justin.slither.content.items.ItemComponent;
import wilson.justin.slither.content.items.factory.FactoryConstants;
import wilson.justin.slither.content.loot.Loot;

/**
 * 
 * @author Phantasye
 *
 */
public class LootUtils {

	public static Loot[] getPreDefinedLoot() {
		final int totalItems = new File("./res/items/").listFiles().length;
		final List<Loot> loot = new ArrayList<>();
		
		for (int i = 0; i < totalItems; i++) {
			Item item = FactoryConstants.ITEM_FACTORY.getItem(i);
			if(item.getDefinition().getTier() == 1) {
				loot.add(new Loot(new ItemComponent(i, 1), 75));
			} else if(item.getDefinition().getTier() == 2) {
				loot.add(new Loot(new ItemComponent(i, 1), 20));
			} else if(item.getDefinition().getTier() == 3) {
				loot.add(new Loot(new ItemComponent(i, 1), 5));
			}
		}
		
		return loot.toArray(new Loot[loot.size()]);
	}
}
