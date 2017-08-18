package wilson.justin.slither.content.items.factory;

import wilson.justin.slither.content.items.Item;
import wilson.justin.slither.content.items.factory.impl.ConsumableFactory;
import wilson.justin.slither.content.items.factory.impl.EquippableItemFactory;
import wilson.justin.slither.content.items.factory.impl.ItemFactory;
import wilson.justin.slither.content.items.factory.impl.LootBoxFactory;
import wilson.justin.slither.content.items.factory.impl.SkinFactory;
import wilson.justin.slither.content.items.impl.Consumable;
import wilson.justin.slither.content.items.impl.EquippableItem;
import wilson.justin.slither.content.items.impl.LootBox;
import wilson.justin.slither.content.items.impl.Skin;

/**
 * 
 * @author Phantasye, Justin
 *
 */
public class FactoryConstants {

    public static final AbstractItemFactory<Skin> SKIN_FACTORY = new SkinFactory();
    //public static final AbstractItemFactory<Background> BACKGROUND_FACTORY = new BackgroundFactory();
    public static final AbstractItemFactory<LootBox> LOOTBOX_FACTORY = new LootBoxFactory();
    public static final AbstractItemFactory<Consumable> CONSUMABLE_FACTORY = new ConsumableFactory();
    public static final AbstractItemFactory<Item> ITEM_FACTORY = new ItemFactory();
    public static final AbstractItemFactory<EquippableItem> EQUIPPABLE_FACTORY = new EquippableItemFactory();
   // public static final AbstractEntityFactory<Player> PLAYER_FACTORY = new PlayerFactory();
   // public static final AbstractEntityFactory<Mob> MOB_FACTORY = new MobFactory();
    
}
