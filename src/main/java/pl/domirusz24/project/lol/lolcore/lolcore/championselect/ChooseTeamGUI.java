package pl.domirusz24.project.lol.lolcore.lolcore.championselect;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class ChooseTeamGUI implements InventoryHolder {

    public static ArrayList<ChooseTeamGUI> ArenaTeams = new ArrayList<>();

    public Arena arena;

    public ChooseTeamGUI(Arena arena) {
        this.arena = arena;
        ChooseTeamGUI.ArenaTeams.add(this);
    }


    @Override
    public Inventory getInventory() {
        Inventory inventory = Bukkit.createInventory(this, 5, ChatColor.GOLD + "Choose team");
        inventory.setItem(0, GeneralGUIItems.blankSpace());
        inventory.setItem(1, ChooseTeamGUI.getItemStackTeam(1));
        inventory.setItem(2, GeneralGUIItems.blankSpace());
        inventory.setItem(3, ChooseTeamGUI.getItemStackTeam(2));
        inventory.setItem(4, GeneralGUIItems.blankSpace());



        return null;
    }

    public static ItemStack getItemStackTeam(int team) {
        if(team == 1 || team == 2) {
            ItemStack item = new ItemStack(Material.CONCRETE);
            ItemMeta meta = item.getItemMeta();
            if(team == 1) {
                meta.setDisplayName(ChatColor.BLUE + "Team 1");
                item.setDurability((short) 14);
            } else {
                meta.setDisplayName(ChatColor.RED + "Team 2");
                item.setDurability((short) 3);
            }
            item.setItemMeta(meta);
            return item;
        }
    return null;
    }


}
