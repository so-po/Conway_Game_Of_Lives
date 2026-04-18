package conwaygame.creatures;

import java.awt.*;

public class DeadStrategy extends Strategy {


    int getMinimumNeighbours() {
        return 2;
    }

    int getMaxNeighbours() {
        return 3;
    }

    int getResurrectionNeighbourCount() {
        return 3;
    }

    public Color getColor() {
        return Color.RED;
    }

    @Override
    public boolean isDead() {
        return true;
    }
}
