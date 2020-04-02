package pl.domirusz24.project.lol.lolcore.lolcore.ability;

import org.bukkit.configuration.file.FileConfiguration;
import pl.domirusz24.project.lol.lolcore.lolcore.LoLCore;
import pl.domirusz24.project.lol.lolcore.lolcore.champion.PlayerChampionInfo;

public class NumberConfig {
    public ChampionDamage[] levelAmount; // DMG amount every lvl
    public LoLAbility ability; // Ability
    public String configPath;
    public AbilityScaling abilityScaling; // Ability Scaling
    public String type; // Ability type (HEAL, DMG, STUN etc.)
    public NumberConfig(LoLAbility ability, ChampionDamage[] levels, String type) {
        this.ability = ability;
        this.levelAmount = levels;
        this.type = type;
        configPath = "Champions." + ability.champion().Name() + ".ability." + ability.bind().toString().toUpperCase() + "." + type + ".";
        abilityScaling = new AbilityScaling(this);
    }


    ChampionDamage getValue(PlayerChampionInfo player) {
        FileConfiguration config = LoLCore.getInstance().getConfig();
        ChampionDamage abilityDMG;
        int playerlvl;
        String DMGConfigPath;
        double apDMG;
        double adDMG;
        double trueDMG;
        switch (ability.bind().toString().toUpperCase()) {
            case "Q":
                playerlvl = player.QLevel;
                DMGConfigPath = configPath + "level." + (playerlvl+1) +  ".";
                abilityDMG = new ChampionDamage(config.getDouble(DMGConfigPath + "AP"), config.getDouble(DMGConfigPath + "AD"), config.getDouble(DMGConfigPath + "TrueDMG"));
                apDMG = abilityDMG.ap * abilityScaling.getAPScaling * abilityScaling.getArmorScaling;
                adDMG = abilityDMG.ad * abilityScaling.getADScaling  * abilityScaling.getMRScaling;
                trueDMG = abilityDMG.trueDMG;
                break;
            case "W":
                playerlvl = player.WLevel;
                DMGConfigPath = configPath + "level." + (playerlvl+1) +  ".";
                abilityDMG = new ChampionDamage(config.getDouble(DMGConfigPath + "AP"), config.getDouble(DMGConfigPath + "AD"), config.getDouble(DMGConfigPath + "TrueDMG"));
                apDMG = abilityDMG.ap * abilityScaling.getAPScaling * abilityScaling.getArmorScaling;
                adDMG = abilityDMG.ad * abilityScaling.getADScaling  * abilityScaling.getMRScaling;
                trueDMG = abilityDMG.trueDMG;
                break;
            case "E":
                playerlvl = player.ELevel;
                DMGConfigPath = configPath + "level." + (playerlvl+1) +  ".";
                abilityDMG = new ChampionDamage(config.getDouble(DMGConfigPath + "AP"), config.getDouble(DMGConfigPath + "AD"), config.getDouble(DMGConfigPath + "TrueDMG"));
                apDMG = abilityDMG.ap * abilityScaling.getAPScaling * abilityScaling.getArmorScaling;
                adDMG = abilityDMG.ad * abilityScaling.getADScaling  * abilityScaling.getMRScaling;
                trueDMG = abilityDMG.trueDMG;
                break;
            case "R":
                playerlvl = player.RLevel;
                DMGConfigPath = configPath + "level." + (playerlvl+1) +  ".";
                abilityDMG = new ChampionDamage(config.getDouble(DMGConfigPath + "AP"), config.getDouble(DMGConfigPath + "AD"), config.getDouble(DMGConfigPath + "TrueDMG"));
                apDMG = abilityDMG.ap * abilityScaling.getAPScaling * abilityScaling.getArmorScaling;
                adDMG = abilityDMG.ad * abilityScaling.getADScaling  * abilityScaling.getMRScaling;
                trueDMG = abilityDMG.trueDMG;
                break;
            default:
                return null;
        }
        ChampionDamage DMG = new ChampionDamage(apDMG, adDMG, trueDMG);
        DMG.armorPEN = player.armorpen;
        DMG.magicPEN = player.magicpen;
        DMG.lethality = player.lethality;
        DMG.magciflatPen = player.magicpenflat;
        return DMG;
    }

}
