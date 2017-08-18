package wilson.justin.slither.content.items.factory.impl;

import java.util.HashMap;
import java.util.Map;

import wilson.justin.slither.content.io.impl.JsonSerializationStrategy;
import wilson.justin.slither.content.items.def.impl.LootBoxDefinition;
import wilson.justin.slither.content.items.factory.AbstractItemFactory;
import wilson.justin.slither.content.items.impl.LootBox;

/**
 * 
 * @author Phantasye
 *
 */
public class LootBoxFactory implements AbstractItemFactory<LootBox> {
    private static final Map<Integer, LootBox> lootboxes = new HashMap<>();

    @Override
    public LootBox getItem(int id) {
	LootBox lootbox = lootboxes.get(id);
	if (lootbox == null) {
	    JsonSerializationStrategy<LootBoxDefinition> json = new JsonSerializationStrategy<LootBoxDefinition>(
		    "./res/items/" + id + ".json", new LootBoxDefinition());
	    lootbox = new LootBox(json.deserialize());
	}
	lootboxes.put(id, lootbox);
	return lootbox;
    }
}
