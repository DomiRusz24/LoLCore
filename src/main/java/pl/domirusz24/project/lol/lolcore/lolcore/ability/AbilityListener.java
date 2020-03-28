package pl.domirusz24.project.lol.lolcore.lolcore.ability;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import pl.domirusz24.project.lol.lolcore.lolcore.champion.PlayerChampionInfo;

public class AbilityListener implements Listener {
    @EventHandler
    public void onItemUse(PlayerInteractEvent event) {
        for (PlayerChampionInfo info : PlayerChampionInfo.playerChampionInfos) {
            if (!info.inAbility) {
                if (info.player.equals(event.getPlayer())) {
                    for (LoLAbility ability : info.champion.abilities()) {
                        if (event.getPlayer().getInventory().getItemInMainHand().equals(ability.icon())) {
                            switch (ability.bind().toString().toUpperCase()) {
                                case "Q":
                                    if (info.QLevel != 0) {
                                        ability.active(info);
                                        info.inAbility = true;
                                    }
                                    break;
                                case "W":
                                    if (info.WLevel != 0) {
                                        ability.active(info);
                                        info.inAbility = true;
                                    }
                                    break;
                                case "E":
                                    if (info.ELevel != 0) {
                                        ability.active(info);
                                        info.inAbility = true;
                                    }
                                    break;
                                case "R":
                                    if (info.RLevel != 0) {
                                        ability.active(info);
                                        info.inAbility = true;
                                    }
                                    break;
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void onItemDrop(PlayerDropItemEvent event) {
        for (PlayerChampionInfo player : PlayerChampionInfo.playerChampionInfos) {
            if (player.player.equals(event.getPlayer())) {
                for (LoLAbility ability : player.champion.abilities()) {
                    if (event.getItemDrop().getItemStack().equals(ability.icon())) {
                        event.setCancelled(true);
                        if(player.avaibleLevelUps > 0) {
                            switch (ability.bind().toString().toUpperCase()) {
                                case "Q":
                                    if(player.QLevel < 5) {
                                        player.QLevel++;
                                        player.avaibleLevelUps--;
                                    }
                                    break;
                                case "W":
                                    if(player.WLevel < 5) {
                                        player.WLevel++;
                                        player.avaibleLevelUps--;
                                    }
                                    break;
                                case "E":
                                    if(player.ELevel < 5) {
                                        player.ELevel++;
                                        player.avaibleLevelUps--;
                                    }
                                    break;
                                case "R":
                                    if(player.RLevel < 5) {
                                        player.RLevel++;
                                        player.avaibleLevelUps--;
                                    }
                                    break;
                            }
                        }
                    }
                }
            }
        }
    }




}

