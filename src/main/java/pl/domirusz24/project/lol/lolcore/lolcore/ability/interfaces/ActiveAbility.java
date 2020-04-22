package pl.domirusz24.project.lol.lolcore.lolcore.ability.interfaces;

import pl.domirusz24.project.lol.lolcore.lolcore.champion.PlayerChampionInfo;

public interface ActiveAbility {

    int CoolDown();
    void active(PlayerChampionInfo playerChampionInfo); // Ability (Use numberConfig as values)
}
