package pl.domirusz24.project.lol.lolcore.lolcore.champion;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import pl.domirusz24.project.lol.lolcore.lolcore.LoLCore;
import pl.domirusz24.project.lol.lolcore.lolcore.ability.ChampionDamage;
import pl.domirusz24.project.lol.lolcore.lolcore.ability.LoLAbility;
import pl.domirusz24.project.lol.lolcore.lolcore.ability.NumberConfig;

import java.util.ArrayList;

public abstract class Champion {
    public static ArrayList<Champion> avaibleChampions = new ArrayList<>();

    public abstract String Name(); // Champion name

    public abstract String Description(); // Champion description

    public abstract Material icon(); // icon (GUI Soon)

    public abstract LoLAbility[] abilities();  // Abilities (Q, W, E, R)

    public abstract LoLAbility passive(); // Ability with passive only

    public abstract boolean isRanged(); // Ranged champion

    public abstract ChampionStats[] stats(); // Champion stats for every level

    public void playerSetChampion(Player player) {
        new PlayerChampionInfo(player, this);
        player.getInventory().setItem(0, passive().icon());
        for(LoLAbility ability : abilities()) {
            switch (ability.bind().toString().toUpperCase()) {
                case "Q":
                    player.getInventory().setItem(1, ability.icon());
                    break;
                case "W":
                    player.getInventory().setItem(2, ability.icon());
                    break;
                case "E":
                    player.getInventory().setItem(3, ability.icon());
                    break;
                case "R":
                    player.getInventory().setItem(4, ability.icon());
                    break;

            }
        }
    }









    public static void loadChampionConfigs() {
        for(Champion champion : avaibleChampions) {
            FileConfiguration config = LoLCore.getInstance().getConfig();
            for(int i = 0; i < champion.stats().length; i++) {
                config.addDefault("Champion." + champion.Name() + ".stats.level." + (i+1) + ".AD", champion.stats()[i].ADDeafult);
                config.addDefault("Champion." + champion.Name() + ".stats.level." + (i+1) + ".AP", champion.stats()[i].APDeafult );
                config.addDefault("Champion." + champion.Name() + ".stats.level." + (i+1) + ".HP", champion.stats()[i].HPDeafult);
                config.addDefault("Champion." + champion.Name() + ".stats.level." + (i+1) + ".Armor", champion.stats()[i].ArmorDeafult);
                config.addDefault("Champion." + champion.Name() + ".stats.level." + (i+1) + ".MR", champion.stats()[i].MRDeafult);
            }
            for(LoLAbility ability : champion.abilities()) {
                for(NumberConfig number : ability.numberConfig()) {
                    for (int i = 0; i < number.levelAmount.length; i++) {
                        ChampionDamage amount = number.levelAmount[i];
                        config.addDefault(number.configPath + "level." + (i+1) + ".AD", amount.ad);
                        config.addDefault(number.configPath + "level." + (i+1) + ".AP", amount.ap);
                        config.addDefault(number.configPath + "level." + (i+1) + ".TrueDMG", amount.trueDMG);
                    }
                    config.addDefault(number.configPath + "scaling.ADScaling.", number.abilityScaling.ADScalingDeafult);
                    config.addDefault(number.configPath + "scaling.APScaling.", number.abilityScaling.APScalingDeafult);
                    config.addDefault(number.configPath + "scaling.HPScaling.", number.abilityScaling.HPScalingDeafult);
                    config.addDefault(number.configPath + "scaling.ArmorScaling.", number.abilityScaling.ArmorScalingDeafult);
                    config.addDefault(number.configPath + "scaling.MRScaling.", number.abilityScaling.MRScalingDeafult);
                }
            }
        }
    }
}
