package conwaygame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameController {

    Grid gridModel;
    GameViewer view;

    public GameController(Grid model, GameViewer view) { //TODO: make GamePanel & Game less tightly coupled? (like w/ an an abstract gameviewer)
        this.gridModel = model;
        this.view = view;

        this.view.addMakeCell1AliveListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gridModel.makeCellAlive(0, 0);
                view.makeCell1Alive();
            }
        });

        this.view.addPlayTurnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gridModel.playTurn();
                if (gridModel.isCellAlive(0, 0)) {
                    view.makeCell1Alive();
                } else {
                    view.makeCell1Dead();
                }
            }
        });
    }

}
