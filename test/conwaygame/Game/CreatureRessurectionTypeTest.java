package conwaygame.Game;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;


public class CreatureRessurectionTypeTest {

    @Test
    public void testDefaultBirth() throws Exception{
        Grid grid = new Grid(3, 3);
        grid.toggleCellState(2, 2, "DEFAULT");
        grid.toggleCellState(1, 2, "DEFAULT");
        grid.toggleCellState(2, 1, "EXPLOSIVE");
        grid.playTurn(); //cell(1,1) should turn into an alive default cell after turn is played
        assert(grid.isCellAlive(1, 1));
        assert(grid.isCellDefault(1, 1));
    }

    @Test
    public void testCopyCatToExplosiveBirth() throws Exception{
        Grid grid = new Grid(3, 3);
        grid.toggleCellState(2, 2, "EXPLOSIVE");
        grid.toggleCellState(1, 2, "EXPLOSIVE");
        grid.toggleCellState(2, 1, "DEFAULT");
        grid.toggleCellState(1, 1, "COPYCAT");
        grid.toggleCellState(1, 1, "COPYCAT"); //make dead
        grid.playTurn(); //cell(1,1) should turn into an explosive cell after turn is played
        assert(grid.isCellAlive(1, 1));
        assert(grid.isCellExplosive(1, 1));
    }
}
