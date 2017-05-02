package game.enemies;

import game.Collider;
import game.PlayerController;
import game.controllers.CollisionManager;
import game.controllers.Controller;
import game.models.GameRect;
import game.views.ImageRenderer;

import java.awt.*;

public class EnemyBullet extends Controller implements Collider {
    private ImageRenderer imageRenderer;
    int damage = 1;
    private boolean hasTouched;

    public EnemyBullet(int x, int y, Image image) {
        super(new GameRect(x +(60/2 - image.getWidth(null) / 2), y + 70, 10, 10),
                new ImageRenderer(image));
        CollisionManager.instance.add(this);

    }

    @Override
    public String getName() {
        return "EnemyBullet";
    }

    @Override
    public void onCollide(Collider other) {
        if(other instanceof PlayerController){
            ((PlayerController) other).getHit(damage);
        }
    }

    public boolean hasTouched() {
        return hasTouched;
    }

    public void setTouched(boolean hasTouched) {
        this.hasTouched = hasTouched;
    }

    public void update() {
        gameRect.move(0,5);
    }
}
