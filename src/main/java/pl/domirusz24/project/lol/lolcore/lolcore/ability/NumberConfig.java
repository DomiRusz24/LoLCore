package pl.domirusz24.project.lol.lolcore.lolcore.ability;

import pl.domirusz24.project.lol.lolcore.lolcore.LoLCore;
import pl.domirusz24.project.lol.lolcore.lolcore.champion.PlayerChampionInfo;

import java.util.ArrayList;
import java.util.Objects;

public class NumberConfig {
    public Double[] levelAmount;
    public LoLAbility ability;
    public String configPath;
    public AbilityScaling abilityScaling;
    public String type;
    public NumberConfig(LoLAbility ability, Double[] levels, String type) {
        this.ability = ability;
        this.levelAmount = levels;
        this.type = type;
        configPath = "Champions." + ability.champion().Name() + ".ability." + ability.bind().toString().toUpperCase() + "." + type + ".";
        abilityScaling = new AbilityScaling(this);
    }
    double getValue(PlayerChampionInfo player) {
        double playerStatsModifier = player.ad * abilityScaling.getADScaling + player.ap * abilityScaling.getAPScaling + player.hp * abilityScaling.getHPScaling + player.armor * abilityScaling.getArmorScaling + player.mr * abilityScaling.getMRScaling;
        switch (ability.bind().toString().toUpperCase()) {
            case "Q":
                return levelAmount[player.QLevel - 1] + playerStatsModifier;
            case "W":
                return levelAmount[player.WLevel - 1] + playerStatsModifier;
            case "E":
                return levelAmount[player.ELevel - 1] + playerStatsModifier;
            case "R":
                return levelAmount[player.RLevel - 1] + playerStatsModifier;
            default:
                return 0;
        }

    }

}
