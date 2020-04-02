package pl.domirusz24.project.lol.lolcore.lolcore.championselect;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GeneralGUIItems {
    public static ItemStack blankSpace() {
        ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE);
        item.setAmount(1);
        item.setDurability((short) 11);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("");
        item.setItemMeta(meta);
        return item;
    }
    public static ItemStack back() {
        ItemStack item = new ItemStack(Material.CONCRETE);
        item.setAmount(1);
        item.setDurability((short) 13);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Go back");
        item.setItemMeta(meta);
        return item;
    }
}
