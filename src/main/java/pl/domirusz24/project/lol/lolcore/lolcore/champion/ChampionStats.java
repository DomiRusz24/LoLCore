package pl.domirusz24.project.lol.lolcore.lolcore.champion;

import org.bukkit.configuration.file.FileConfiguration;
import pl.domirusz24.project.lol.lolcore.lolcore.LoLCore;
import pl.domirusz24.project.lol.lolcore.lolcore.ability.NumberConfig;

public class ChampionStats {
    Champion champion;
    String configPath;
    FileConfiguration config = LoLCore.getInstance().getConfig();
    public double getAD = config.getDouble(configPath + "AD");
    public double APDeafult = 0;
    public double getAP = config.getDouble(configPath + "AP");
    public double ADDeafult = 0;
    public double getHP = config.getDouble(configPath + "HP");
    public double HPDeafult = 0;
    public double getArmor = config.getDouble(configPath + "Armor");
    public double ArmorDeafult = 0;
    public double getMR = config.getDouble(configPath + "MR");
    public double MRDeafult = 0;
    public ChampionStats(Champion champion) {
        this.champion = champion;
        configPath = "Champions." + champion.Name() + ".basestats.";
    }
}
