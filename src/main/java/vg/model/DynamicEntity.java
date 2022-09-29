package vg.model;

import vg.utils.Direction;
import vg.utils.Position;
import vg.utils.Speed;

public abstract class DynamicEntity extends AbstractEntity{
    private Speed speed;

    DynamicEntity(final Position position, final Speed speed) {
        super(position);
        this.speed = speed;
    }

    public void move(final Direction dir){
        Position updatedPos = new Position(dir.getX()*this.speed.getX(), dir.getY()*this.speed.getY());
        this.getPosition().sumPosition(updatedPos);
    }

    public Speed getSpeed() {
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
    public void afterCollisionAction(){
        this.bounces();
    }

    private void bounces() {
        //TODO invertire Direction
    }
}
