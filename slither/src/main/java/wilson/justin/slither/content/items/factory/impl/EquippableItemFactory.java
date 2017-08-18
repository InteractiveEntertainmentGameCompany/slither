package wilson.justin.slither.content.items.factory.impl;

import java.util.HashMap;
import java.util.Map;

import wilson.justin.slither.content.io.impl.JsonSerializationStrategy;
import wilson.justin.slither.content.items.def.impl.EquippableDefinition;
import wilson.justin.slither.content.items.factory.AbstractItemFactory;
import wilson.justin.slither.content.items.impl.EquippableItem;

/**
 * 
 * @author Phantasye
 *
 */
public class EquippableItemFactory implements AbstractItemFactory<EquippableItem> {

    private static final Map<Integer, EquippableItem> equippables = new HashMap<>();

    @Override
    public EquippableItem getItem(int id) {
	EquippableItem equippable = equippables.get(id);
	if (equippable == null) {
		JsonSerializationStrategy<EquippableDefinition> json = new JsonSerializationStrategy<EquippableDefinition>(
			"./res/items/" + id + ".json", new EquippableDefinition());
		equippable = new EquippableItem(json.deserialize());
	}
	equippables.put(id, equippable);
	return equippable;
    }

}
