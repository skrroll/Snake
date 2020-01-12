import java.util.Random;

public class Grid {

    private boolean isCovered[][]; // true if there is a snake on given location, otherwise false
    private final int width;
    private final int height;
    private int score;

    private Snake snake;
    private Node food;

    public Grid(int w, int h) {
        this.width = w;
        this.height = h;
        this.score = 0;
        isCovered = new boolean[width][height];

        //randomizing starting position in such way that snake can't spawn nearby the borders of the grid
        int x = new Random().nextInt((width-4))+2;
        int y = new Random().nextInt((height-4))+2;
        this.snake = new Snake(x, y);
        isCovered[x][y] = true;

        createFood();
    }

    public boolean isMovePossible(int x, int y) {
        if (x < 0 || y < 0 || x >= width || y >= height) {
            return false;
        } else if (isCovered[x][y]) {
            return false;
        } else {
            isCovered[x][y] = true;
            return true;
        }
    }

    public boolean move(Direction dir) {
        int x = this.snake.getHead().getX();
        int y = this.snake.getHead().getY();

        switch(dir) {
            case UP:
                y--;
                break;
            case DOWN:
                y++;
                break;
            case LEFT:
                x--;
                break;
            case RIGHT:
                x++;
                break;
        }

        if(isMovePossible(x, y)){
            Node newHead = new Node(x, y);
            isCovered[x][y] = true;
            Node tail = snake.update(newHead, food);
            if(tail == null) {
                this.score++;
                createFood();
            } else {
                isCovered[tail.getX()][tail.getY()] = false;
                //System.out.println(snake.getBody().toString());
            }
            return true;
        } else {
            return false;
        }
    }

    public void createFood() {
        int x,y;
        do {
            x = new Random().nextInt(width);
            y = new Random().nextInt(height);
        } while(isCovered[x][y]);
        this.food = new Node(x, y);
    }


    public Snake getSnake() {
        return this.snake;
    }
    public Node getFood() {
        return this.food;
    }
    public int getScore() {
        return this.score;
    }

}
