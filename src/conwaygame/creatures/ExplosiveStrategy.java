package conwaygame.creatures;

import java.awt.*;

public class ExplosiveStrategy extends Strategy {


    int getMinimumNeighbours() {
        return 0;
    }

    int getMaxNeighbours() {
        return 5;
    }

    int getResurrectionNeighbourCount() {
        return 1;
    }

    public Color getColor() {
        return Color.YELLOW;
    }

    public CreatureType getType() {
        return CreatureType.EXPLOSIVE;
    }


}
