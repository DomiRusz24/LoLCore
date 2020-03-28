package pl.domirusz24.project.lol.lolcore.lolcore.ability;


public class ChampionDamage {
    public double ap;
    public double ad;
    public double trueDMG;
    public double lethality = 0;
    public double armorPEN = 0;
    public double magicPEN = 0;
    public double magciflatPen = 0;

    public ChampionDamage(double ap, double ad, double trueDMG) {
        this.ap = ap;
        this.ad = ad;
        this.trueDMG = trueDMG;
    }
}
