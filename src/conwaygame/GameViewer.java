package conwaygame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GameViewer extends JFrame {

    GamePanel gamePanel;
    JButton makeCell1AliveButton = new JButton("make cell 1 alive");
    JButton playTurnButton = new JButton("play a turn");

    public GameViewer() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("Conway's Game of Life");

        JPanel mainPanel = new JPanel();
        gamePanel = new GamePanel();
        mainPanel.add(gamePanel);
        mainPanel.add(makeCell1AliveButton);
        mainPanel.add(playTurnButton);
        this.add(mainPanel);
        this.pack();

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void addMakeCell1AliveListener(ActionListener actionListener){
        makeCell1AliveButton.addActionListener(actionListener);
    }

    public void addPlayTurnListener(ActionListener actionListener) {
        playTurnButton.addActionListener(actionListener);
    }

    public void makeCell1Alive() {
        this.gamePanel.cell1Alive = true;
        this.repaint();
    }

    public void makeCell1Dead() {
        this.gamePanel.cell1Alive = false;
        this.repaint();
    }


    public class GamePanel extends JPanel{

        //SCREEN SETTINGS
        final int originalTileSize = 16; //16x16 sprite size
        final int scale = 3;

        final int tileSize = originalTileSize * scale;
        final int maxScreenCol = 16;
        final int maxScreenRow = 12;
        final int screenWidth = tileSize * maxScreenCol;
        final int screenHeight = tileSize * maxScreenRow;
        boolean cell1Alive = false;

        Thread gameThread;

        public GamePanel(){
            this.setPreferredSize(new Dimension(screenWidth, screenHeight));
            this.setBackground(Color.black);
            this.setDoubleBuffered(true);
        }

        public void update(){

        }

        public void paintComponent(Graphics g){
            super.paintComponent(g);

            int origin = 100;
            Graphics g2 = (Graphics2D)g;

            g2.setColor(Color.red);

            if (cell1Alive) {
                g2.setColor(Color.green);
            }

            g2.fillRect(origin,origin,tileSize, tileSize);

            g2.setColor(Color.red);

            g2.fillRect(origin+tileSize,origin,tileSize, tileSize);

            g2.fillRect(origin,origin+tileSize,tileSize, tileSize);

            g2.fillRect(origin+tileSize,origin+tileSize,tileSize, tileSize);

            g2.dispose();
        }


    }


}