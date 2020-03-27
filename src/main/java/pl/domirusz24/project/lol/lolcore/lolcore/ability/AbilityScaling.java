package pl.domirusz24.project.lol.lolcore.lolcore.ability;

import org.bukkit.configuration.file.FileConfiguration;
import pl.domirusz24.project.lol.lolcore.lolcore.LoLCore;

public class AbilityScaling {
    NumberConfig value;
    String configPath;
    FileConfiguration config = LoLCore.getInstance().getConfig();
    public double getAPScaling = config.getDouble(configPath + "scaling." + "AP");
    public double APScalingDeafult = 0;
    public double getADScaling = config.getDouble(configPath + "scaling." + "AD");
    public double ADScalingDeafult = 0;
    public double getHPScaling = config.getDouble(configPath + "scaling." + "HP");
    public double HPScalingDeafult = 0;
    public double getArmorScaling = config.getDouble(configPath + "scaling." + "Armor");
    public double ArmorScalingDeafult = 0;
    public double getMRScaling = config.getDouble(configPath + "scaling." + "MR");
    public double MRScalingDeafult = 0;
    public AbilityScaling(NumberConfig value) {
        this.value = value;
        configPath = "Champions." + value.ability.champion().Name() + "." + value.ability.bind().toString().toUpperCase() + "." + value.type + ".";
    }

}
