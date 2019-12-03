package de.realmeze.controller;

import de.realmeze.model.CommandItem;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.List;

public class CommandItemController {

	private CommandItem commandItem;

	//tries to parse hidden command at last lore index, if no command is found it will be ""
	public CommandItemController(CommandItem commandItem) {
		this.commandItem = commandItem;
		getCommandItem().setHiddenCommand(parsedHiddenCommand());
	}

	private CommandItem getCommandItem() {
		return commandItem;
	}

	public void dispatchHiddenCommand(Player player){
		if(!commandItem.getHiddenCommand().equals("")) {
			Bukkit.getServer().dispatchCommand(player, commandItem.getHiddenCommand());
		}
	}

	//strips the "§K" at last lore index of item and return command or ""
	private String parsedHiddenCommand() {
		if (!validateCommandItem()) {
			return "";
		}
		List<String> lore = getCommandItem().getItem().getItemMeta().getLore();
		String hiddenCommand = lore.get(lore.size() - 1);

		if (!hiddenCommand.startsWith("§k")) {
			return "";
		}
		return hiddenCommand.replaceFirst("§k", "");
	}

	//checks if item could have a command
	private boolean validateCommandItem(){
		if(!isActualItem()){
			return false;
		}
		if (!hasItemMeta()){
			return false;
		}
		return hasLore();
	}

	private boolean isActualItem() {
		return getCommandItem().getItem() != null;
	}

	private boolean hasItemMeta() {
		return getCommandItem().getItem().hasItemMeta();
	}

	private boolean hasLore() {
		return getCommandItem().getItem().getItemMeta().hasLore();
	}



}
