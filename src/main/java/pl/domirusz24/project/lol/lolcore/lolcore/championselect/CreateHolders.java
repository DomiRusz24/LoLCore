package pl.domirusz24.project.lol.lolcore.lolcore.championselect;

import org.bukkit.ChatColor;

public class CreateHolders {
    public static void createInventoryHolders() {
        MainMenuGUI.mainmenupages.add(ChatColor.YELLOW + "Main Menu");
        MainMenuGUI.mainmenupages.add(ChatColor.ITALIC + "Find game");
        MainMenuGUI.mainmenupages.add(ChatColor.GOLD + "Choose team");
    }
}
