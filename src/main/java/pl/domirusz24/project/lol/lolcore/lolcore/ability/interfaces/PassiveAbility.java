package pl.domirusz24.project.lol.lolcore.lolcore.ability.interfaces;

import pl.domirusz24.project.lol.lolcore.lolcore.champion.PlayerChampionInfo;

public interface PassiveAbility {

    int CoolDown();

    int passiveRunnableTick(); // Optional. How often activate passive (Tick) (If none, set it to 0)

    int passiveEvent(); // Optional. Activate passive when event (Event) (If none, set it to null)

    void passive(PlayerChampionInfo playerChampionInfo); // PassiveRun
}
