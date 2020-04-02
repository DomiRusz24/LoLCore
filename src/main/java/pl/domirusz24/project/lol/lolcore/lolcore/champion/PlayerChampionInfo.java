package pl.domirusz24.project.lol.lolcore.lolcore.champion;

import org.bukkit.entity.Player;
import pl.domirusz24.project.lol.lolcore.lolcore.ability.ChampionDamage;

import java.util.ArrayList;

public class PlayerChampionInfo {
    public static ArrayList<PlayerChampionInfo> playerChampionInfos = new ArrayList<>();
    public Player player;
    public Champion champion;
    int level = 1;
    public int avaibleLevelUps = 1;
    public boolean inAbility = false;
    public boolean dead = false;
    public int CDR = 0;
    public int EXP = 0;
    public int QLevel = 0;
    public int WLevel = 0;
    public int ELevel = 0;
    public int RLevel = 0;
    public double ad = 0;
    public double ap = 0;
    public double hp = 0;
    public double maxhp = 0;
    public double armor = 0;
    public double mr = 0;
    public double armorpen = 0;
    public double magicpen = 0;
    public double lethality = 0;
    public double magicpenflat = 0;

    public PlayerChampionInfo(Player player, Champion champion) {
        this.player = player;
        this.champion = champion;
        ad = ad + champion.stats()[level - 1].getAD;
        ap = ap + champion.stats()[level - 1].getAP;
        maxhp = maxhp + champion.stats()[level - 1].getHP;
        hp = hp + champion.stats()[level - 1].getHP;
        armor = armor + champion.stats()[level - 1].getArmor;
        mr = mr + champion.stats()[level - 1].getMR;
        playerChampionInfos.add(this);
    }
    public void PlayerLevelUp(PlayerChampionInfo player) {
        level++;
        ad = ad + champion.stats()[level - 1].getAD;
        ap = ap + champion.stats()[level - 1].getAP;
        hp = hp + champion.stats()[level - 1].getHP;
        armor = armor + champion.stats()[level - 1].getArmor;
        mr = mr + champion.stats()[level - 1].getMR;
    }
    public int getLevel() {
        return level;
    }

    public void damagePlayer(ChampionDamage damage, PlayerChampionInfo player) {
        double adDMG = 100*(damage.ad) / (100+this.armor-(this.armor * damage.armorPEN)- damage.lethality);
        double apDMG = 100*(damage.ap) / (100+this.mr-(this.mr * damage.magicPEN)- damage.magciflatPen);
        this.hp = hp - adDMG - apDMG - damage.trueDMG;
        if(this.hp < 0) {
            this.player.kickPlayer("Zginales noobie");
        }
    }
}
