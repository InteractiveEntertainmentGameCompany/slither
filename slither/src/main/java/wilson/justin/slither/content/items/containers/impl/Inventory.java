package wilson.justin.slither.content.items.containers.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import wilson.justin.slither.content.items.containers.ItemContainer;

/**
 * 
 * @author Phantasye
 *
 */
public class Inventory implements ItemContainer {

	private final Map<Integer, Integer> contents = new HashMap<>(10);

	public Inventory() {
	}

	@Override
	public void add(int id, int amount) {
		if (!contents.containsKey(id))
			contents.put(id, amount);
		else
			contents.computeIfPresent(id, (key, oldVal) -> oldVal += amount);
	}

	@Override
	public void remove(int id, int amount) {
		if (contents.get(id) != null) {
			if (contents.get(id) == amount) {
				contents.remove(id);
			} else {
				contents.computeIfPresent(id, (key, oldVal) -> oldVal -= amount);
			}
		} else {
			throw new NullPointerException("You do not have that item.");
		}
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
		return contents.keySet().stream().anyMatch(value -> value == id);
	}

	@Override
	public Collection<Integer> getContents() {
		return contents.keySet();
	}

	@Override
	public int replace(int id) {
		return containsItem(id) ? contents.keySet().stream().filter(value -> value == id).findFirst().get() : 0;
	}

	@Override
	public int getSlot(int slot) {
		for (int i = 0; i < contents.keySet().size(); i++) {
			if(i == slot)
				return contents.get(i);
		}
		return 0;
	}

}
