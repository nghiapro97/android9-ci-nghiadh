package game.enemies;

import game.models.GameRect;


public class HorizontalMoveBehavior extends MoveBehavior {
    private int dx;
    private int dy;

    public HorizontalMoveBehavior(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    @Override
    public void move(GameRect gameRect){
        gameRect.move(dx,dy);
    }
}
