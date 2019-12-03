package de.realmeze.command;

import de.realmeze.manager.MenuManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MenuCommand implements CommandExecutor {

	private MenuManager menuManager;

	public MenuCommand(MenuManager menuManager) {
		this.menuManager = menuManager;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if(!(sender instanceof Player)){
			return false;
		}

		if(command.getName().equalsIgnoreCase("Menu")){
			Player player = (Player) sender;
			menuManager.showToPlayer(player, false);
			return true;
		}
		return false;
	}
}
