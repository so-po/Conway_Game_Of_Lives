package conwaygame.game;

public class ConwayGame { //Facade for Game MVC

    public ConwayGame(int width, int height) throws Exception {
        GameViewer gameViewer = new GameViewer(width, height);

        GameModel grid = GameModel.getNewBuilder().setDimensions(width, height).build();
        GameController game = new GameController(grid, gameViewer);

        gameViewer.setVisible(true);
    }

    public ConwayGame(GameModel injectedGrid) throws Exception {
        GameModel grid = injectedGrid;
        GameViewer gameViewer = new GameViewer(grid.getWidth(), grid.getHeight());
        GameController game = new GameController(grid, gameViewer);
        gameViewer.setVisible(true);
    }

}
