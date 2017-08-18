package wilson.justin.slither.content.items.factory.impl;

import java.util.HashMap;
import java.util.Map;

import wilson.justin.slither.content.io.impl.JsonSerializationStrategy;
import wilson.justin.slither.content.items.Item;
import wilson.justin.slither.content.items.def.ItemDefinition;
import wilson.justin.slither.content.items.factory.AbstractItemFactory;

/**
 * 
 * @author Phantasye
 *
 */
public class ItemFactory implements AbstractItemFactory<Item> {

    private static final Map<Integer, Item> items = new HashMap<>();

	@Override
	public Item getItem(int id) {
		Item item = items.get(id);
		if (item == null) {
			JsonSerializationStrategy<ItemDefinition> json = new JsonSerializationStrategy<ItemDefinition>(
					"./res/items/" + id + ".json", new ItemDefinition());
			item = new Item(json.deserialize());
		}
		items.put(id, item);
		return item;
	}

}
