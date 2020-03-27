package pl.domirusz24.project.lol.lolcore.lolcore.ability;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;
import pl.domirusz24.project.lol.lolcore.lolcore.champion.Champion;
import pl.domirusz24.project.lol.lolcore.lolcore.champion.PlayerChampionInfo;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class LoLAbility {
    public abstract Champion champion(); // Champion class

    public abstract String name(); // Ability name

    public abstract ArrayList<String> description(); // Ability desc

    public abstract Character bind(); // Ability bind (Q, W, E, R)

    public abstract ItemStack icon(); // Ability icon (GUI Soon)

    public abstract NumberConfig cooldown(); // Ability active CD (SET NUMBER CONFIG TYPE TO "CoolDown"

    public abstract ArrayList<NumberConfig> numberConfig(); // Ability values (DMG, HEAL, STUN etc.)

    public abstract void active(PlayerChampionInfo playerChampionInfo); // Ability (Use numberConfig as values)

    public abstract int passiveRunnableTick(); // Optional. How often activate passive (Tick) (If none, set it to 0)

    public abstract void passive(PlayerChampionInfo playerChampionInfo, Event event); // Optional. Passive.

}
