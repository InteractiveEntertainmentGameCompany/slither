package wilson.justin.slither.content.items.def;

/**
 * 
 * @author Phantasye, Justin
 *
 */
public class ItemDefinition {
    
    private int id;
    private String name;
    private int value;
    private String description = "No description available.";
    private int tier;
    private boolean sellable = true;
    private boolean tradable = true;
    
    
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
  
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public String getDescription() {
	return description;
    }
    public void setDescription(String description) {
	this.description = description;
    }
	public int getTier() {
		return tier;
	}
	public void setTier(int tier) {
		this.tier = tier;
	}
	public boolean isSellable() {
		return sellable;
	}
	public void setSellable(boolean sellable) {
		this.sellable = sellable;
	}
	public boolean isTradable() {
		return tradable;
	}
	public void setTradable(boolean tradable) {
		this.tradable = tradable;
	}
}
