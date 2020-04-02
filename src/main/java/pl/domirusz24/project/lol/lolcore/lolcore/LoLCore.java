package pl.domirusz24.project.lol.lolcore.lolcore;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import pl.domirusz24.project.lol.lolcore.lolcore.ability.AbilityListener;
import pl.domirusz24.project.lol.lolcore.lolcore.champion.Champion;
import pl.domirusz24.project.lol.lolcore.lolcore.championselect.CreateHolders;
import pl.domirusz24.project.lol.lolcore.lolcore.championselect.GUIListener;
import pl.domirusz24.project.lol.lolcore.lolcore.championselect.createArena;

public final class LoLCore extends JavaPlugin {

    private static JavaPlugin instance;

    @Override
    public void onEnable() {
        System.out.println("LoLCore has been enabled!");
        instance = this;
        Bukkit.getPluginManager().registerEvents(new AbilityListener(), this);
        Bukkit.getPluginManager().registerEvents(new GUIListener(), this);
        this.getCommand("LOLarena").setExecutor(new createArena());
        Champion.loadChampionConfigs();
        getConfig().options().copyDefaults(true);
        saveConfig();
        CreateHolders.createInventoryHolders();
    }

    public static JavaPlugin getInstance() {
        return instance;
    }

}
