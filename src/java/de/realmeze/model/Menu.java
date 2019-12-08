package de.realmeze.model;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import javax.naming.InvalidNameException;
import java.util.ArrayList;

public class Menu {

	private String title;
	private ArrayList<ItemStack> inventoryContent;
	private Inventory showingInventory;
	private Player currentEditor;

	public Menu(ArrayList<ItemStack> inventoryContent) {
		this.inventoryContent = inventoryContent;
		this.title = "§4Menu";
		this.currentEditor = null;
	}

	public Inventory getShowingInventory() {
		return showingInventory;
	}

	public Player getCurrentEditor(){
		return currentEditor;
	}

	public void setCurrentEditor(Player currentEditor) {
		this.currentEditor = currentEditor;
	}

	public void setShowingInventory(Inventory showingInventory) {
		this.showingInventory = showingInventory;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public ArrayList<ItemStack> getInventoryContent() {
		return inventoryContent;
	}

	public void setInventoryContent(ArrayList<ItemStack> inventoryContent) {
		this.inventoryContent = inventoryContent;
	}


}
