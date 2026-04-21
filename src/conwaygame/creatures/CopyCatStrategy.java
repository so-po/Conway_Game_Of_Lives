package conwaygame.creatures;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import static conwaygame.creatures.CreatureType.*;

public class CopyCatStrategy extends DefaultStrategy {

    @Override
    public CreatureType getType() {
        return null;
    }

    @Override
    public Color getAliveColor() {
        return Color.WHITE;
    }

    @Override
    public Color getDeadColor() {
        return new Color(50, 50, 50);
    }

    @Override
    public CreatureType chooseNewStrategy(List<Creature> creatures) {
        HashMap<CreatureType, Integer> strategyTypeCount = new HashMap<>();
        for (CreatureType creatureType : CreatureType.values()) {
            strategyTypeCount.put(creatureType, countCreaturesOfType(creatures, creatureType));
        }

        CreatureType largestType = DEFAULT;
        int maxCount = strategyTypeCount.get(DEFAULT);
        for(Map.Entry<CreatureType, Integer> strategyCountPair : strategyTypeCount.entrySet()) {
            if (strategyCountPair.getValue() > maxCount) {
                largestType = strategyCountPair.getKey();
                maxCount = strategyCountPair.getValue();
            }
        }

        return largestType;
    }

    private int countCreaturesOfType(java.util.List<Creature> creatures, CreatureType type) {
        int creatureCount = 0;
        for (Creature creature : creatures) {
            if (creature.getType() == type) {
                creatureCount++;
            }
        }
        return creatureCount;
    }
}