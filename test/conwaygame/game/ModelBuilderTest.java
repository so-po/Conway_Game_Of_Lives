package conwaygame.game;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class ModelBuilderTest {

    @Test
    public void testBuilderCreatureSpawner() throws Exception{
        final int WIDTH = 4;
        final int HEIGHT = 4;
        GameModel model = GameModel.getNewBuilder().setDimensions(WIDTH, HEIGHT)
                .addDefaultCreatureToLocation(0,0)
                .addExplosiveCreatureToLocation(1,0)
                .addScarcityCreatureToLocation(0,1)
                .build();
        assert(model.isCellDefault(0, 0));
        assert(model.isCellExplosive(1, 0));
        assert(model.isCellScarcity(0, 1));
    }

}
