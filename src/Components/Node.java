package Components;

import java.util.Random;

import Utils.Utils;

public class Node {

    public static float learing_rate = 0.05f;

    public float[] weights, previous;
    public float bias, value;

    // Previous is the values of previous nodes and the array should be kept alive
    // elsewear
    public Node(float[] previous) {
        Random rn = new Random();
        this.previous = previous;
        bias = rn.nextFloat() - 0.5f;
        weights = new float[previous.length];

        for (int i = 0; i < previous.length; i++) {
            weights[i] = rn.nextFloat() - 0.5f;
        }

    }

    public Node(float[] values, String string) {
        this.previous = values;
        String[] weights = string.substring(string.lastIndexOf(":") + 3, string.length() - 2).split(", ");
        this.weights = new float[weights.length - 1];

        for (int i = 0; i < weights.length - 1; i++) {
            this.weights[i] = Float.parseFloat(weights[i]);
        }

        this.bias = Float.parseFloat(weights[weights.length - 1]);

    }

    // Returns value of node
    public float calc_value() {

        value = Utils.sigmoid(Utils.sum(previous, weights) + bias);
        return value;
    }

    // Returns errors for previous row of nodes
    public float[] calc_prev_errors(float delta) {

        float[] errors = new float[weights.length];
        for (int i = 0; i < errors.length; i++) {
            errors[i] = weights[i] * delta;
        }
        return errors;
    }

    // Returns errors for previous row of nodes and adjusts weights
    public float[] learn(float error) {
        float delta = error * Utils.transfer_derivative(value);

        for (int i = 0; i < weights.length; i++) {
            weights[i] += learing_rate * delta * previous[i];
        }

        bias += learing_rate * delta;

        return calc_prev_errors(delta);

    }

    public void learn_base(float error) {
        float delta = error * Utils.transfer_derivative(value);

        for (int i = 0; i < weights.length; i++) {
            weights[i] += learing_rate * delta * previous[i];
        }
        bias += learing_rate * delta;
    }

    public String toString() {
        String output = "{'value': " + value + ", 'weights': [";
        for (float weight : weights) {
            output += weight + ", ";
        }
        output += bias + "]}";
        return output;
    }

}
