package pl.domirusz24.project.lol.lolcore.lolcore.ability.enums;

public enum AbilityNumberType {
    Healing,
    Damage,
    CrowdControl(CCEfects.Stun);


    private CCEfects effect;


    AbilityNumberType() {
        effect = null;
    }

    AbilityNumberType(CCEfects effect) {
        this.effect = effect;
    }

    public void setEffect(CCEfects effect) {
        this.effect = effect;
    }

    @Override
    public String toString() {
        if (this.effect == null) {
            return this.name();
        } else {
            return this.effect.name();
        }
    }
}
