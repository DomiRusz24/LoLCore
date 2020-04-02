package pl.domirusz24.project.lol.lolcore.lolcore.ability;

import org.bukkit.configuration.file.FileConfiguration;
import pl.domirusz24.project.lol.lolcore.lolcore.LoLCore;

public class AbilityScaling {
    NumberConfig value;
    String configPath;
    FileConfiguration config = LoLCore.getInstance().getConfig();
    public double getAPScaling;
    public double APScalingDeafult = 0;
    public double getADScaling;
    public double ADScalingDeafult = 0;
    public double getHPScaling;
    public double HPScalingDeafult = 0;
    public double getArmorScaling;
    public double ArmorScalingDeafult = 0;
    public double getMRScaling;
    public double MRScalingDeafult = 0;
    public AbilityScaling(NumberConfig value) {
        this.value = value;
        configPath = "Champions." + value.ability.champion().Name() + "." + value.ability.bind().toString().toUpperCase() + "." + value.type + ".";
        getAPScaling = config.getDouble(configPath + "scaling." + "AP");
        getADScaling = config.getDouble(configPath + "scaling." + "AD");
        getHPScaling = config.getDouble(configPath + "scaling." + "HP");
        getArmorScaling = config.getDouble(configPath + "scaling." + "Armor");
        getMRScaling = config.getDouble(configPath + "scaling." + "MR");
    }

}
