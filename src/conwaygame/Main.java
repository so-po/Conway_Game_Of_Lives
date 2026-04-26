package conwaygame;
import conwaygame.game.ConwayGame;
import conwaygame.game.GameModel;

public class Main {

    public static void main(String[] args) throws Exception {

        //ConwayGame conwayGame = new ConwayGame(9, 9);

        final int WIDTH = 9;
        final int HEIGHT = 9;
        GameModel model = GameModel.getNewBuilder().setDimensions(WIDTH, HEIGHT)
                .addDefaultCreatureToLocation(0,0)
                .addDefaultCreatureToLocation(1,0)
                .addDefaultCreatureToLocation(1,1)
                .build();
        ConwayGame conwayGame = new ConwayGame(model);

    }
}
