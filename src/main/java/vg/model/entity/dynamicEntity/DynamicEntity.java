package vg.model.entity.dynamicEntity;

import vg.model.entity.ShapedEntity;
import vg.utils.Direction;
import vg.utils.MassTier;
import vg.utils.Shape;
import vg.utils.V2D;

public abstract class DynamicEntity extends ShapedEntity {
    /**
     * Entity movement speed.
     * */
    private V2D speed;

    public DynamicEntity(final V2D position, final V2D speed, final int radius, final Shape shape, final MassTier massTier) {
        super(position, radius, shape, massTier);
        this.speed = speed;
    }

    public void move(final Direction dir) {
        V2D curPos = this.getPosition();
        V2D updatedPos = new V2D(dir.getX() * this.speed.getX(), dir.getY() * this.speed.getY());
        this.setPosition(curPos.sum(updatedPos));
    }

    /**
     * Return vector that represent current entity speed.
     * @return current entity speed
     */
    public V2D getSpeed() {
        return this.speed;
    }

    /*
    * Di questa funzione ogni tipologia di Entità farà il suo
    * ovverride e la funzione verrà chiamata solo nel caso in
    * cui l'entità rimbalzi, nell'altro caso in cui l'entità
    * deve attraversare o venir distrutta non c'è bisogno di
    * chiamare la funzione. La teniamo comunque chiamata così
    * perché potrebbero venire creati altri casi oltre a questi
    * e a quel punto potrebbe aver senso mettere un parametro.
    */
    public void afterCollisionAction() {
        this.bounces();
    }

    private void bounces() {
        //TODO invertire speed
    }
}
