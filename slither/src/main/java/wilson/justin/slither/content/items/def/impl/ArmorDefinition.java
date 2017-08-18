package wilson.justin.slither.content.items.def.impl;

/**
 * 
 * @author Phantasye
 *
 */
public class ArmorDefinition extends EquippableDefinition {
    
    
    private int defense;
    private int hitpoints;
    private int shields;
    private int armor;

    public int getDefense() {
        return defense;
    }
    public void setDefense(int defense) {
        this.defense = defense;
    }
    public int getHitpoints() {
        return hitpoints;
    }
    public void setHitpoints(int hitpoints) {
        this.hitpoints = hitpoints;
    }
    public int getShields() {
        return shields;
    }
    public void setShields(int shields) {
        this.shields = shields;
    }
    public int getArmor() {
        return armor;
    }
    public void setArmor(int armor) {
        this.armor = armor;
    }

}
