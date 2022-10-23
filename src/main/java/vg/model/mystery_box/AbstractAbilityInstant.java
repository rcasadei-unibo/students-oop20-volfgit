package vg.model.mystery_box;

public abstract class AbstractAbilityInstant extends AbstractAbility {

    public AbstractAbilityInstant(final EAbility idAbility) {
        super(idAbility, ETypeAbility.INSTANT);
    }
}
