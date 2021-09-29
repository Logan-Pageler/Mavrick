import java.util.Random;

public class Node {
    public int value;
    public double[] weights, previous;
    public double bias, shift;

    public Node(double[] previous) {
        Random rn = new Random();
        this.previous = previous;
        bias = rn.nextDouble();
        shift = rn.nextDouble();
        weights = new double[previous.length];

        for (int i = 0; i < previous.length; i++) {
            weights[i] = rn.nextDouble();
        }

    }

    public double calc_value() {
        return Utils.sigmoid(Utils.sum(previous, weights) * bias + shift);
    }

}
