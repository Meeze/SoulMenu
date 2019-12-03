package de.realmeze.main;

import de.realmeze.command.MenuCommand;
import de.realmeze.command.MenuMgrCommand;
import de.realmeze.manager.MenuManager;
import de.realmeze.listener.InventoryClickListener;
import de.realmeze.listener.InventoryCloseListener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	private MenuManager menuManager;

	@Override
	public void onEnable() {
		this.menuManager = new MenuManager(this);
		this.getCommand("Menu").setExecutor(new MenuCommand(getMenuManager()));
		this.getCommand("MenuMgr").setExecutor(new MenuMgrCommand(getMenuManager()));
		this.getServer().getPluginManager().registerEvents(new InventoryCloseListener(getMenuManager()), this);
		this.getServer().getPluginManager().registerEvents(new InventoryClickListener(getMenuManager()), this);
	}

	private MenuManager getMenuManager() {
		return menuManager;
	}

}
