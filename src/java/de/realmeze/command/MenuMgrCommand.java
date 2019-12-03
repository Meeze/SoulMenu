package de.realmeze.command;

import de.realmeze.manager.MenuManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MenuMgrCommand implements CommandExecutor {

	private MenuManager menuManager;

	public MenuMgrCommand(MenuManager menuManager) {
		this.menuManager = menuManager;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if(!(sender instanceof Player)){
			return false;
		}

		if(command.getName().equalsIgnoreCase("MenuMgr")){
			Player player = (Player) sender;
			menuManager.showToPlayer(player, true);
			return true;
		}
		return false;
	}
}
