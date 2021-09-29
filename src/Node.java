import java.util.Random;

public class Node {
    public int value;
    public double[] weights;
    public Node[] previous;

    public Node(Node[] previous) {
        Random rn = new Random();
        this.previous = previous;
        weights = new double[previous.length];

        for (int i = 0; i < previous.length; i++) {
            weights[i] = rn.nextDouble();
        }

    }

}
