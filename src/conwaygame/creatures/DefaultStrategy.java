package conwaygame.creatures;

import java.awt.*;

import static conwaygame.creatures.CreatureType.DEAD;

public class DefaultStrategy extends Strategy {

    int getMinimumNeighbours() { return 2; }

    int getMaxNeighbours() { return 3; }

    int getResurrectionNeighbourCount() { return 3; }


    @Override
    public Color getColor() {
        return Color.GREEN;
    }

    public CreatureType getType() {
        return CreatureType.DEFAULT;
    }

}
