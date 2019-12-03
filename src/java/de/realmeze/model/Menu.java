package de.realmeze.model;

import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class Menu {

	private String title = "Menu";

	private ArrayList<ItemStack> inventoryContent;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Menu(ArrayList<ItemStack> inventoryContent) {
		this.inventoryContent = inventoryContent;
	}

	public ArrayList<ItemStack> getInventoryContent() {
		return inventoryContent;
	}

	public void setInventoryContent(ArrayList<ItemStack> inventoryContent) {
		this.inventoryContent = inventoryContent;
	}


}
