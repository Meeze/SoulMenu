package de.realmeze.manager;

import de.realmeze.model.Menu;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MenuManager {

	private Menu menu;
	private JavaPlugin plugin;

	//loads menu automatically from config
	public MenuManager(JavaPlugin plugin) {
		this.plugin = plugin;
		this.menu = new Menu(loadInventoryFromConfig());
	}

	private Menu getMenu() {
		return menu;
	}

	public JavaPlugin getPlugin() {
		return plugin;
	}

	private ArrayList<ItemStack> getMenuContent() {
		return getMenu().getInventoryContent();
	}

	public void setMenuContent(ArrayList<ItemStack> menuContent){
		getMenu().setInventoryContent(menuContent);
	}

	public String getInventoryTitle(){
		return getMenu().getTitle();
	}

	public void showToPlayer(Player player, boolean editing) {
		Inventory inventory = createInventoryView(editing);
		player.openInventory(inventory);
	}


	public void saveInventoryToConfig() {
		File file = new File(plugin.getDataFolder(), "menu.yml");
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		config.set("inventory", getMenuContent());
		try {
			config.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//loads menu content from file and checks if its null aka air
	private ArrayList<ItemStack> loadInventoryFromConfig() {
		File file = new File(plugin.getDataFolder(), "menu.yml");
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		ArrayList<ItemStack> itemStacks = new ArrayList<>();
			if(config.getList("inventory") != null){
				for(Object itemStackObject : (config.getList("inventory"))){
					if(itemStackObject instanceof ItemStack){
						itemStacks.add((ItemStack) itemStackObject);
					}
					else{
						itemStacks.add(new ItemStack(Material.AIR));
					}
				}
			}
		return itemStacks;
	}

	private Inventory createInventoryView(boolean editing) {
		Inventory showingInventory;
		if (editing) {
			showingInventory = Bukkit.createInventory(null, 54, getInventoryTitle() + " EDIT");
		} else {
			showingInventory = Bukkit.createInventory(null, 54, getInventoryTitle());
		}
		showingInventory.setContents(getMenuContentAsArray());
		return showingInventory;
	}

	private ItemStack[] getMenuContentAsArray(){
		ItemStack[] invContent = new ItemStack[getMenuContent().size()];
		invContent = getMenuContent().toArray(invContent);
		return invContent;
	}

}
