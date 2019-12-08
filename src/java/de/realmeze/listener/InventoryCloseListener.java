package de.realmeze.listener;

import de.realmeze.manager.MenuManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class InventoryCloseListener implements Listener {

	private MenuManager menuManager;

	public InventoryCloseListener(MenuManager menuManager){
		this.menuManager = menuManager;
	}

	public MenuManager getMenuManager() {
		return menuManager;
	}

	//if player closes the /menumgr inventory it will be saved to config and model
	@EventHandler
	public void onInventoryClose(InventoryCloseEvent event){
		if(event.getInventory().getTitle().equals( getMenuManager().getInventoryView().getTitle())){
			if(getMenuManager().getEditor() == null){
				return;
			}
			if(getMenuManager().getEditor() == event.getPlayer()){
				ArrayList<ItemStack> contentToSave = new ArrayList<>();
				for (ItemStack item : event.getInventory().getContents()) {
					if(item != null){
						contentToSave.add(item);
					}
					else{
						contentToSave.add(new ItemStack(Material.AIR));
					}
				}
				menuManager.setMenuEditor(null);
				menuManager.setMenuContent(contentToSave);
				menuManager.saveInventoryToConfig();
			}
		}
	}
}
