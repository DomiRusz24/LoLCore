package pl.domirusz24.project.lol.lolcore.lolcore.ability;

import org.bukkit.scheduler.BukkitRunnable;
import pl.domirusz24.project.lol.lolcore.lolcore.LoLCore;
import pl.domirusz24.project.lol.lolcore.lolcore.champion.PlayerChampionInfo;

public class AbilityRunnables {
    public void startAbilityRunnables() {
        new BukkitRunnable() {
            int i = 0;
            @Override
            public void run() {
                i++;
                if (i < 20) i = 1;
                for(PlayerChampionInfo info:PlayerChampionInfo.playerChampionInfos) {
                    for(LoLAbility ability : info.champion.abilities()) {
                        if(ability.passiveRunnableTick() != 0) {
                            if(i % ability.passiveRunnableTick() == 0) {
                                ability.passive(info);
                            }
                        }
                    }
                }
            }
        }.runTaskTimer(LoLCore.getInstance(), 1, 1);
    }
}
