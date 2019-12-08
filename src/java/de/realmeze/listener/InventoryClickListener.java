package de.realmeze.listener;

import de.realmeze.controller.CommandItemController;
import de.realmeze.manager.MenuManager;
import de.realmeze.model.CommandItem;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClickListener implements Listener {

	private MenuManager menuManager;

	public InventoryClickListener(MenuManager menuManager) {
		this.menuManager = menuManager;
	}

	private MenuManager getMenuManager() {
		return menuManager;
	}

	//if last lore starts with "§K" the rest of string will be dispatched as command
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		if (event.getInventory().getTitle().equals(getMenuManager().getInventoryView().getTitle())) {
			if (getMenuManager().getEditor() != null) {
				return;
			}

			if (event.getClickedInventory().getHolder() == event.getWhoClicked()) {
				event.setCancelled(true);
				return;
			}
			CommandItem commandItem = new CommandItem(event.getCurrentItem());
			CommandItemController commandItemController = new CommandItemController(commandItem);
			commandItemController.dispatchHiddenCommand((Player) event.getWhoClicked());
			event.setCancelled(true);
		}


	}
}
