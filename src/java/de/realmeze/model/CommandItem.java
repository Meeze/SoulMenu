package de.realmeze.model;

import org.bukkit.inventory.ItemStack;

public class CommandItem {

	private ItemStack itemStack;
	private String hiddenCommand;

	public CommandItem(ItemStack itemStack) {
		this.itemStack = itemStack;
	}

	public String getHiddenCommand() {
		return hiddenCommand;
	}

	public ItemStack getItem() {
		return itemStack;
	}

	public void setHiddenCommand(String parsedHiddenCommand) {
		this.hiddenCommand = parsedHiddenCommand;
	}
}
