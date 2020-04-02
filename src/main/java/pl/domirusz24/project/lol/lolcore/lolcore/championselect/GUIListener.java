package pl.domirusz24.project.lol.lolcore.lolcore.championselect;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GUIListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        ItemStack item = new ItemStack(Material.SAND);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Super duper hiper fajny piasek");
        item.setItemMeta(meta);
        event.getPlayer().getInventory().addItem(item);
    }

    @EventHandler
    public void onRightClick(PlayerInteractEvent event) {
        if (event.getAction().equals(Action.RIGHT_CLICK_AIR)) {
            if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("Super duper hiper fajny piasek")) {
                event.getPlayer().openInventory(new MainMenuGUI().getInventory());
            }
        }
    }


    @EventHandler
    public void onInteract(InventoryClickEvent event) {
        if (event.getWhoClicked() instanceof Player) {
            Player player = (Player) event.getWhoClicked();
            ItemStack item = event.getCursor();
            ItemMeta meta = item.getItemMeta();
            for (String string : MainMenuGUI.mainmenupages) {
                if (event.getClickedInventory().getName().equals(string)) {
                    if (item.getItemMeta() == GeneralGUIItems.blankSpace().getItemMeta()) {
                        event.setCancelled(true);
                        return;
                    }
                }
                if (string.equals(ChatColor.YELLOW + "Main Menu")) {
                    if (item.getItemMeta() == MainMenuGUI.findGame().getItemMeta()) {
                        player.openInventory(new FindGameGUI().getInventory());
                        event.setCancelled(true);
                        return;
                    }
                } else if (string.equals(ChatColor.ITALIC + "Find game")) {
                    for (Arena arena : Arena.avaibleAreans) {
                        if (item.getItemMeta().equals(arena.getArenaItem().getItemMeta())) {
                            if (arena.getPlayerCount() <= 9) {
                                player.openInventory(new ChooseTeamGUI(arena).getInventory());
                                event.setCancelled(true);
                                return;
                            }
                        }
                    }
                } else if (string.equals(ChatColor.GOLD + "Choose team")) {
                    for (ChooseTeamGUI team : ChooseTeamGUI.ArenaTeams) {
                        if (event.getClickedInventory().getHolder().equals(team)) {
                            if (meta.equals(ChooseTeamGUI.getItemStackTeam(1).getItemMeta())) {
                                event.setCancelled(true);
                                team.arena.addPlayer(1, player);
                            } else if (meta.equals(ChooseTeamGUI.getItemStackTeam(2).getItemMeta())) {
                                event.setCancelled(true);
                                team.arena.addPlayer(2, player);
                            }
                        }
                    }
                }
            }
        }
    }
}




