package wilson.justin.slither.content.items.containers.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import wilson.justin.slither.content.items.containers.ItemContainer;
import wilson.justin.slither.content.items.factory.FactoryConstants;

/**
 * 
 * @author Phantasye
 *
 */
public class Equipment implements ItemContainer {
	
	public static final int SKIN = 0;
	public static final int FACE = 1;
	public static final int TAIL = 2;

    private final Map<Integer, Integer> contents = new HashMap<>(2);

    @Override
    public void add(int id, int amount) {
	if (contents.containsKey(id)) {
	    contents.replace(id, amount);
	} else {
	    contents.putIfAbsent(id, amount);
	}

    }

    @Override
    public void remove(int id, int amount) {
	if (contents.get(id) > amount)
	    contents.replace(id, amount);
	else
	    contents.remove(id);
    }

    @Override
    public int get(int id) {
	return contents.containsKey(id) ? contents.get(id) : 0;
    }

    @Override
    public void empty() {
	contents.clear();
    }

    @Override
    public boolean containsItem(int id) {
	int slot = FactoryConstants.EQUIPPABLE_FACTORY.getItem(id).getDefinition().getSlot();
	return contents.keySet().stream()
		.anyMatch(item -> FactoryConstants.EQUIPPABLE_FACTORY.getItem(item).getDefinition().getSlot() == slot);
    }

    @Override
    public Collection<Integer> getContents() {
	return contents.keySet();
    }

    @Override
    public int replace(int id) {
	int slot = FactoryConstants.EQUIPPABLE_FACTORY.getItem(id).getDefinition().getSlot();
	 return containsItem(id) ? contents.keySet().stream()
		.filter(item -> FactoryConstants.EQUIPPABLE_FACTORY.getItem(item).getDefinition().getSlot() == slot)
		.findFirst().get() : 0;
    }
    
    @Override
    public int getSlot(int slot) {
	return contents.keySet().stream()
		.filter(item -> FactoryConstants.EQUIPPABLE_FACTORY.getItem(item).getDefinition().getSlot() == slot)
		.findAny().orElse(-1);
    }

}
