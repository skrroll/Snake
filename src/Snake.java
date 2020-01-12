import java.util.LinkedList;

public class Snake {
    private int length;
    private LinkedList <Node> body;

    public Snake (int x, int y) {
        this.length = 1;
        this.body = new LinkedList<>();
        Node n = new Node(x, y);
        this.body.addFirst(n);
    }

    public Node update(Node newHead, Node food) {
        this.body.addFirst(newHead);

        // checking if snake ran into the food. If it did, we don't remove the last node, otherwise we remove it
        if (food.equals(newHead)) {
            return null;
        } else {
            return this.body.removeLast();
        }
    }

    public Node getHead() {
        return this.body.getFirst();
    }

    public LinkedList<Node> getBody() {
        return this.body;
    }
}
