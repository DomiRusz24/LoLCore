package pl.domirusz24.project.lol.lolcore.lolcore.ability;

import org.bukkit.inventory.ItemStack;
import pl.domirusz24.project.lol.lolcore.lolcore.ability.interfaces.ActiveAbility;
import pl.domirusz24.project.lol.lolcore.lolcore.ability.interfaces.PassiveAbility;
import pl.domirusz24.project.lol.lolcore.lolcore.champion.Champion;
import pl.domirusz24.project.lol.lolcore.lolcore.champion.PlayerChampionInfo;

import java.util.ArrayList;

public abstract class LoLAbility {

    public static ArrayList<ActiveAbility> activeAbilites = new ArrayList<>();
    public static ArrayList<PassiveAbility> passiveAbilities = new ArrayList<>();

    public LoLAbility() {
        if(this instanceof PassiveAbility) {
            LoLAbility.passiveAbilities.add((PassiveAbility) this);
        }
        if(this instanceof ActiveAbility) {
            LoLAbility.activeAbilites.add((ActiveAbility) this);
        }
    }

    public abstract Champion champion(); // Champion class

    public abstract String name(); // Ability name

    public abstract ArrayList<String> description(); // Ability desc

    public abstract Character bind(); // Ability bind (Q, W, E, R)

    public abstract ItemStack icon(); // Ability icon (GUI Soon)

    public abstract ArrayList<NumberConfig> numberConfig(); // Ability values (DMG, HEAL, STUN etc.)

    public abstract PassiveAbility[] passives();

    public void runActiveAbility(PlayerChampionInfo playerChampionInfo) {
        if(this instanceof ActiveAbility) {
            ((ActiveAbility) this).active(playerChampionInfo);
        }
    }

    public void runPassiveAbility(PlayerChampionInfo playerChampionInfo) {
        if(this instanceof PassiveAbility) {
            ((PassiveAbility) this).passive(playerChampionInfo);
        }

    }

}
