package wilson.justin.slither.content.items.factory;

import wilson.justin.slither.content.items.Item;

/**
 * 
 * @author Phantasye
 *
 */
public interface AbstractItemFactory<T extends Item> {

    T getItem(int id);
    
}
