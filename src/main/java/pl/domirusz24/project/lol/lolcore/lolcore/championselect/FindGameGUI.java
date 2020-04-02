package pl.domirusz24.project.lol.lolcore.lolcore.championselect;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class FindGameGUI implements InventoryHolder {

    @Override
    public Inventory getInventory() {
        Inventory inventory = Bukkit.getServer().createInventory(this, 9, ChatColor.ITALIC + "Find game");
        int y = 0;
        for (int i = 0; i < Arena.avaibleAreans.size(); i++) {
            if(Arena.avaibleAreans.get(i).getArenaItem() != null) {
                inventory.setItem(i-y,Arena.avaibleAreans.get(i).getArenaItem());
            } else {
                y++;
            }
        }

        for (int i = 0; i < inventory.getSize(); i++) {
            if (inventory.getItem(i) == null) {
                inventory.setItem(i, GeneralGUIItems.blankSpace());
            }
        }
        return inventory;
    }





}
