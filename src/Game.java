import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game implements KeyListener {
    private Direction dir;
    private Grid grid;
    private GameView gameView;
    //fields used by game loop to control fps
    private final double fps = 10.0;
    private final double ns = 1000000000.0 / fps;
    private double delta = 0;
    private double lastTime = System.nanoTime();

    public Game(GameView gV, Grid grid) {
        dir = Direction.LEFT;
        this.grid = grid;
        this.gameView = gV;
    }

    public void run() {
        boolean playing = true;
        gameView.draw();
        while(playing) {

            double now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1.0) {
                if(grid.move(dir)){
                    gameView.draw();
                } else {
                    playing = false;
                }

                delta--;
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch(keyCode) {
            case KeyEvent.VK_UP:
                if(dir != Direction.DOWN) {
                    this.dir = Direction.UP;
                }
                break;
            case KeyEvent.VK_RIGHT:
                if(dir != Direction.LEFT) {
                    this.dir = Direction.RIGHT;
                }
                break;
            case KeyEvent.VK_DOWN:
                if(dir != Direction.UP) {
                    this.dir = Direction.DOWN;
                }
                break;
            case KeyEvent.VK_LEFT:
                if(dir != Direction.RIGHT) {
                    this.dir = Direction.LEFT;
                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }

}
