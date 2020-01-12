import javax.swing.*;
import java.awt.*;

public class GameClient {

    public static void main(String args[]) {
        int width = 20;
        int height = 20;
        int node_size = 20;

        JFrame window = new JFrame("Snake Game");
        Grid grid = new Grid(width, height);
        GameView gameView = new GameView(grid, node_size);
        Game game = new Game(gameView, grid);
        Container contentPane = window.getContentPane();
        gameView.getCanvas().setPreferredSize(new Dimension(width * node_size, height * node_size));
        contentPane.add(gameView.getCanvas(), BorderLayout.CENTER);
        window.pack();
        window.setResizable(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.addKeyListener(game);
        game.run();
    }
}
