package pl.domirusz24.project.lol.lolcore.lolcore.championselect;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;

public class Arena {
    public static ArrayList<Arena> avaibleAreans;
    public static int latestArenaNumber = -1;
    private int ArenaNumber;
    public Location team1spawn;
    public Location team2spawn;
    public ArrayList<Player> team1;
    public ArrayList<Player> team2;

    public Arena() {
        Arena.latestArenaNumber++;
        ArenaNumber = Arena.latestArenaNumber;
        Arena.avaibleAreans.add(Arena.latestArenaNumber, this);
    }

    public int getArenaNumber() {
        return ArenaNumber;
    }

    public int getPlayerCount() {
        return team1.size() + team2.size();
    }

    public ItemStack getArenaItem() {
        if (team1spawn != null && team2spawn != null) {
            ItemStack item = new ItemStack(Material.CONCRETE);
            ItemMeta meta = item.getItemMeta();
            if (getPlayerCount() <= 7) {
                item.setDurability((short) 5);
                meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Arena " + getArenaNumber());
                meta.setLore(Arrays.asList(ChatColor.GREEN + "" + ChatColor.BOLD + "Click to join", getPlayerCount() + " / 10"));
            } else if (getPlayerCount() > 7 && getPlayerCount() != 10) {
                item.setDurability((short) 1);
                meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Arena " + getArenaNumber());
                meta.setLore(Arrays.asList(ChatColor.GREEN + "" + ChatColor.BOLD + "Click to join", getPlayerCount() + " / 10"));
            } else {
                item.setDurability((short) 14);
                meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Arena " + getArenaNumber() + " : FULL");
                meta.setLore(Arrays.asList(getPlayerCount() + " / 10"));
            }
            item.setItemMeta(meta);
            return item;
        }
    return null;
    }

    public void addPlayer(int Team, Player player) {
        if(Team == 1) {
            if(team1.size() != 5) {
                this.team1.add(player);
            }
        } else {
            if(team2.size() != 5) {
                this.team2.add(player);
            }
        }
        if(this.getPlayerCount() == 10) {
            startChampSelect();
        }
    }
    public void startChampSelect() {

    }

}
