package wilson.justin.slither.content.items.factory.impl;

import java.util.HashMap;
import java.util.Map;

import wilson.justin.slither.content.io.impl.JsonSerializationStrategy;
import wilson.justin.slither.content.items.def.impl.ConsumableDefinition;
import wilson.justin.slither.content.items.factory.AbstractItemFactory;
import wilson.justin.slither.content.items.impl.Consumable;

public class ConsumableFactory implements AbstractItemFactory<Consumable> {

    private static final Map<Integer, Consumable> consumables = new HashMap<>();

    @Override
    public Consumable getItem(int id) {
	Consumable consumable = consumables.get(id);
	if (consumable == null) {
	    JsonSerializationStrategy<ConsumableDefinition> json = new JsonSerializationStrategy<ConsumableDefinition>(
		    "./res/items/" + id + ".json", new ConsumableDefinition());
	    consumable = new Consumable(json.deserialize());
	}
	consumables.put(id, consumable);
	return consumable;
    }

}