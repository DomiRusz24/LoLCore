package pl.domirusz24.project.lol.lolcore.lolcore.championselect;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class MainMenuGUI implements InventoryHolder {
    public static List<String> mainmenupages;






    @Override
    public Inventory getInventory() {
        Inventory menu = Bukkit.getServer().createInventory(this, 9, ChatColor.YELLOW + "Main Menu");
        menu.setItem(0, GeneralGUIItems.back());
        menu.setItem(1, GeneralGUIItems.blankSpace());
        menu.setItem(2, GeneralGUIItems.blankSpace());
        menu.setItem(3, GeneralGUIItems.blankSpace());
        menu.setItem(4, MainMenuGUI.findGame());
        menu.setItem(5, GeneralGUIItems.blankSpace());
        menu.setItem(6, GeneralGUIItems.blankSpace());
        menu.setItem(7, GeneralGUIItems.blankSpace());
        menu.setItem(8, GeneralGUIItems.blankSpace());
        return menu;
    }

    public static ItemStack findGame() {
        ItemStack item = new ItemStack(Material.COMPASS);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.ITALIC + "Find game");
        return item;
    }



}
