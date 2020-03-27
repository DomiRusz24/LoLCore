package pl.domirusz24.project.lol.lolcore.lolcore;

import org.bukkit.plugin.java.JavaPlugin;
import pl.domirusz24.project.lol.lolcore.lolcore.champion.Champion;

public final class LoLCore extends JavaPlugin {

    private static JavaPlugin instance;

    @Override
    public void onEnable() {
        System.out.println("LoLCore has been enabled!");
        instance = this;
        Champion.loadChampionConfigs();
    }

    public static JavaPlugin getInstance() {
        return instance;
    }

}
