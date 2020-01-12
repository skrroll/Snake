import javax.swing.*;
import java.awt.*;

public class GameView {
    private JPanel canvas;
    private int node_size;
    private Grid grid;

    public GameView(Grid grid, int node_size) {
        this.node_size = node_size;
        this.grid = grid;
        init();
    }

    private void init() {
        canvas = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                g.setColor(Color.WHITE);
                g.fillRect(0,0,400,400);
                for (Node node : grid.getSnake().getBody()) {
                    g.setColor(Color.GREEN);
                    g.fillRect(node.getX() * node_size, node.getY() * node_size, node_size, node_size);
                }
                g.setColor(Color.RED);
                Node food = grid.getFood();
                g.fillRect(food.getX() * node_size, food.getY() * node_size, node_size, node_size);
            }
        };
    }

    public void draw() {
        canvas.repaint();
    }

    public JPanel getCanvas() {
        return canvas;
    }

}
