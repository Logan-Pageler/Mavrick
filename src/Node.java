import java.util.Random;

public class Node {

    public static double learing_rate = 0.05;

    public double[] weights, previous;
    public double bias, value;

    // Previous is the values of previous nodes and the array should be kept alive
    // elsewear
    public Node(double[] previous) {
        Random rn = new Random();
        this.previous = previous;
        bias = rn.nextDouble() - 0.5;
        weights = new double[previous.length];

        for (int i = 0; i < previous.length; i++) {
            weights[i] = rn.nextDouble() - 0.5;
        }

    }

    // Returns value of node
    public double calc_value() {

        value = Utils.sigmoid(Utils.sum(previous, weights) + bias);
        return value;
    }

    // Returns errors for previous row of nodes
    public double[] calc_prev_errors(double delta) {

        double[] errors = new double[weights.length];
        for (int i = 0; i < errors.length; i++) {
            errors[i] = weights[i] * delta;
        }
        return errors;
    }

    // Returns errors for previous row of nodes and adjusts weights
    public double[] learn(double error) {
        double delta = error * Utils.transfer_derivative(value);

        for (int i = 0; i < weights.length; i++) {
            weights[i] += learing_rate * delta * previous[i];
        }

        bias += learing_rate * delta;

        return calc_prev_errors(delta);

    }

    public void learn_base(double error) {
        double delta = error * Utils.transfer_derivative(value);

        for (int i = 0; i < weights.length; i++) {
            weights[i] += learing_rate * delta * previous[i];
        }
        bias += learing_rate * delta;
    }

    public String toString() {
        String output = "{'value': " + value + ", 'weights': [";
        for (double weight : weights) {
            output += weight + ", ";
        }
        output += bias + "]}";
        return output;
    }

}
