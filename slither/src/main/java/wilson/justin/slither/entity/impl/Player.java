package wilson.justin.slither.entity.impl;

import wilson.justin.slither.content.items.containers.impl.Equipment;
import wilson.justin.slither.content.items.containers.impl.Inventory;
import wilson.justin.slither.content.items.factory.FactoryConstants;
import wilson.justin.slither.content.items.impl.Armor;
import wilson.justin.slither.content.items.impl.EquippableItem;
import wilson.justin.slither.content.transaction.Currency;
import wilson.justin.slither.content.transaction.Transaction;
import wilson.justin.slither.entity.Entity;
import wilson.justin.slither.entity.player.Equippable;
import wilson.justin.slither.entity.player.PlayerProperties;

public class Player extends Entity implements Equippable {

	private final PlayerProperties properties;
	private long commandCooldown;

	public static enum Skill {
		OFFENCE, COLLECTOR, EVASION, SLITHERING; 
	}

	public Player(long id, PlayerProperties playerProperties) {
		super(playerProperties);
		this.properties = playerProperties;
		properties.setUserId(id);
	}

	// What happens when a player dies?
	@Override
	protected void die() {
		//TODO: totalScore += sessionScore
		//TODO: Send Death Message/Append popup score screen
		System.out.println("Player died.");
		this.setDead(false);
	}

	// Save Player data
	/*public void save() {
		new JsonSerializationStrategy<PlayerProperties>("./res/users/" + properties.getUserId() + ".json", properties)
				.serialize();
	}*/

	// Creates a Transaction
	public void createTransaction(Transaction transaction, Currency.Type currency) {
		try {
			transaction.transact(this, currency);
		} catch (NullPointerException e) {
			properties.getCurrencies().put(currency, new Currency());
			transaction.transact(this, currency);
		}
	}

	/*@Override
	public EquippableItem getEquipment(int slot) {
		return this.getEquipment().getSlot(slot) == -1 ? null
				: FactoryConstants.EQUIPPABLE_FACTORY.getItem(this.getEquipment().getSlot(slot));
	}*/

	//TODO configure for skill level not attribute level
	/*@Override
	public boolean canEquip(int item) {
		try {
			final EquippableItem equipment = FactoryConstants.EQUIPPABLE_FACTORY.getItem(item);
			final int offence = this.getAttributes().getOffence();
			final int requiredOffence = equipment.getDefinition().getRequirements().getOffence();
			final int dexterity = this.getAttributes().getDexterity();
			final int requiredDexterity = equipment.getDefinition().getRequirements().getDexterity();
			final int vitality = this.getAttributes().getVitality();
			final int requiredVitality = equipment.getDefinition().getRequirements().getVitality();
			final int defense = this.getAttributes().getDefense();
			final int requiredDefense = equipment.getDefinition().getRequirements().getDefense();
			final boolean canWear = defense >= requiredDefense ? offence >= requiredOffence
					? dexterity >= requiredDexterity ? vitality >= requiredVitality : false : false : false;
			if (!canWear) {
				System.out.println("You do not have the stats required to wear that. You need at least "
						+ requiredOffence + " Offence " + requiredDexterity + " Dexterity " + requiredVitality
						+ " Vitality " + requiredDefense + " Defense");
				return false;
			}
		} catch (NullPointerException e) {
			this.sendMessage("You can't equip that.");
			return false;
		}
		return true;
	}*/

	/*@Override
	public void equip(EquippableItem equipment) {
		final int slot = equipment.getDefinition().getSlot();
		final int itemId = equipment.getDefinition().getId();

		this.getInventory().remove(itemId, 1);
		if (this.getEquipment().getSlot(slot) != -1) {
			this.getInventory().add(this.getEquipment(slot).getDefinition().getId(), 1);
			this.getEquipment().remove(this.getEquipment(slot).getDefinition().getId(), 1);
		}
		this.getEquipment().add(itemId, 1);
		switch (slot) {
		case 0:
			final boolean twoHand = FactoryConstants.WEAPON_FACTORY.getItem(itemId).getDefinition().isTwoHanded();
			final Weapon offhand = this.getWeapon(Equipment.OFF_HAND);
			if (twoHand && offhand != null) {
				this.getInventory().add(offhand.getDefinition().getId(), 1);
				this.getEquipment().remove(offhand.getDefinition().getId(), 1);
			}
			break;
		case 1:
			final Weapon mainhand = this.getWeapon(Equipment.MAIN_HAND);
			if (mainhand != null && mainhand.getDefinition().isTwoHanded()) {
				this.getInventory().add(mainhand.getDefinition().getId(), 1);
				this.getEquipment().remove(mainhand.getDefinition().getId(), 1);
			}
			break;
		}

	}*/

	/*@Override
	public void unequip(int id) {
		this.getEquipment().remove(id, 1);
		this.getInventory().add(id, 1);
	}*/

	public void reset() {
		properties.setXp(0);
		properties.setLevel(1);
		//TODO: reset skills to level 1
		for (int itemId : this.getEquipment().getContents()) {
			this.unequip(itemId);
		}
	}

	public void addXp(int amount) {
		int nextLevelXp = xpToLevel();
		int remainder = amount - nextLevelXp;
		int newXp = properties.getXp() + amount;
		properties.setXp(newXp);
		if (newXp >= this.xpToLevel(this.getLevel()) + nextLevelXp) {
			this.levelUp();
			this.addXp(remainder);
		}
	}

	public void levelUp() {
		properties.setLevel(this.getLevel() + 1);
		//TODO: Add Level Up Message through chat
		System.out.println("Add level up message here.");
	}

	public int xpToLevel() {
		int lvl = this.getLevel();
		return (int) Math.floor(lvl + 400 * Math.pow(2, lvl / 7.0));
	}

	public int xpToLevel(int lvl) {
		int amt = 0;
		for (int i = 0; i < lvl; i++) {
			amt += (int) Math.floor(i + 400 * Math.pow(2, i / 7.0));
		}
		return amt;
	}

	public boolean isUpdated() {
		return properties.isUpdate();
	}

	public int getBalance() {
		return this.getCurrency(Currency.Type.COINS).getTotal();
	}

	public long getUserId() {
		return properties.getUserId();
	}

	public int getCurrentXp() {
		return properties.getXp();
	}

	public Inventory getInventory() {
		return properties.getInventory();
	}

	public Equipment getEquipment() {
		return properties.getEquipment();
	}

	public void setLevel(int lvl) {
		this.addXp(xpToLevel(lvl));
	}

	public long getCommandCooldown() {
		return commandCooldown;
	}

	public void setCommandCooldown(int seconds) {
		this.commandCooldown = seconds * 1000;
	}

	public int getLevel(Player.Skill skill) {
		return properties.getSkills().get(skill).getLevel();
	}

	public void addXp(Player.Skill skill, int amount) {
		int lvl = this.getLevel(skill);
		int nextLevelXp = (int) Math.floor(lvl + 400 * Math.pow(2, lvl / 7.0));
		int remainder = amount - nextLevelXp;
		int newXp = properties.getSkills().get(skill).getCurrentXp() + amount;
		properties.getSkills().get(skill).setCurrentXp(newXp);
		if (newXp >= this.xpToLevel(this.getLevel(skill)) + nextLevelXp) {
			this.levelUpSkill(skill);
			this.addXp(remainder);
		}
	}

	public void levelUpSkill(Player.Skill skill) {
		properties.getSkills().get(skill).setLevel(this.getLevel(skill) + 1);
		//TODO: Add chatbox level up skill message
		System.out.println("You've leveled up " + skill + " you are now level " + this.getLevel(skill));
	}

	public Currency getCurrency(Currency.Type currency) {
		return properties.getCurrencies().get(currency);
	}

	@Override
	public String hit(Entity target) {
		return null;
	}

	@Override
	public Armor getArmor(int slot) {
		return null;
	}

	@Override
	public EquippableItem getEquipment(int slot) {
		return null;
	}

	@Override
	public int getDamage(int slot) {
		return 0;
	}

	@Override
	public int getDefense(int slot) {
		return 0;
	}

	@Override
	public int getHitpoints(int slot) {
		return 0;
	}

	@Override
	public boolean canEquip(int item) {
		return false;
	}

	@Override
	public void equip(EquippableItem equipment) {
		
	}

	@Override
	public void unequip(int id) {
		
	}

}
