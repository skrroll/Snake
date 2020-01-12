public class Node {
    private int x;
    private int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public boolean equals(Node n) {
        if(this.x == n.getX() && this.y == n.getY()) {
            return true;
        } else {
            return false;
        }
    }
}
