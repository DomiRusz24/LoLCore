package pl.domirusz24.project.lol.lolcore.lolcore.ability;

import org.bukkit.inventory.ItemStack;
import pl.domirusz24.project.lol.lolcore.lolcore.champion.Champion;
import pl.domirusz24.project.lol.lolcore.lolcore.champion.PlayerChampionInfo;

import java.util.ArrayList;

public interface LoLAbility {
    Champion champion(); // Champion class

    String name(); // Ability name

    ArrayList<String> description(); // Ability desc

    Character bind(); // Ability bind (Q, W, E, R)

    ItemStack icon(); // Ability icon (GUI Soon)

    NumberConfig cooldown(); // Ability active CD (SET NUMBER CONFIG TYPE TO "CoolDown")

    ArrayList<NumberConfig> numberConfig(); // Ability values (DMG, HEAL, STUN etc.)

    void active(PlayerChampionInfo playerChampionInfo); // Ability (Use numberConfig as values)

    int passiveRunnableTick(); // Optional. How often activate passive (Tick) (If none, set it to 0)

    int passiveEvent(); // Optional. Activate passive when event (Event) (If none, set it to null)

    void passive(PlayerChampionInfo playerChampionInfo); // Optional. Passive.

}
