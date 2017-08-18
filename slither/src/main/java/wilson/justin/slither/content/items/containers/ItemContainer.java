package wilson.justin.slither.content.items.containers;

import java.util.Collection;

/**
 * 
 * @author Phantasye
 *
 */
public interface ItemContainer {

    void add(int id, int amount);
   
    void remove(int id, int amount);
   
   int get(int id);
   int getSlot(int slot);
   
   void empty();
   
   boolean containsItem(int id);
   
   Collection<Integer> getContents();
   
   int replace(int id);
   
}
