package Components;

import Utils.Save_File;

public class Network {
    Node[][] layers;
    float[][] values;
    float[] inputs;

    public Network(int[] size) {
        layers = new Node[size.length - 1][];
        values = new float[size.length - 1][];

        // Create input layer
        values[0] = new float[size[1]];
        inputs = new float[size[0]];
        layers[0] = create_layer(inputs, size[1]);

        // Create rest of layers
        for (int i = 1; i < layers.length; i++) {
            values[i] = new float[size[i + 1]];
            layers[i] = create_layer(values[i - 1], size[i + 1]);
        }
    }

    // load from save
    public Network(String string) {

        String[] layers = string.split("\n");

        String[][] nodes = new String[layers.length - 1][];
        for (int i = 0; i < layers.length - 1; i++) {
            nodes[i] = layers[i + 1].substring(2, layers[i + 1].length() - 3).split("\\}, \\{");
        }

        this.layers = new Node[nodes.length][];
        values = new float[nodes.length][];

        // create input layer
        values[0] = new float[nodes[0].length];
        inputs = new float[Integer.parseInt(layers[0].substring(layers[0].indexOf(":") + 1))];
        this.layers[0] = create_layer(inputs, nodes[0]);

        // create rest of layers
        for (int i = 1; i < values.length; i++) {
            values[i] = new float[nodes[i].length];
            this.layers[i] = create_layer(values[i - 1], nodes[i]);
        }
    }

    public float[] calc_output(float[] in) {
        for (int i = 0; i < in.length; i++) {

            inputs[i] = in[i];
        }

        for (int i = 0; i < layers.length; i++) {
            for (int j = 0; j < layers[i].length; j++) {
                values[i][j] = layers[i][j].calc_value();
            }
        }

        return values[values.length - 1];
    }

    public void learn(float[] expected) {
        int index = layers.length - 1;
        float[] errors = new float[layers[index - 1].length];

        // output layer
        for (int i = 0; i < layers[index].length; i++) {
            float[] arr = layers[index][i].learn(expected[i] - values[index][i]);
            add_errors(errors, arr);
        }

        // hidden layers
        for (int i = layers.length - 2; i > 0; i--) {
            float[] new_errors = new float[layers[i - 1].length];
            for (int j = 0; j < layers[i].length; j++) {
                float[] arr = layers[i][j].learn(errors[j]);
                add_errors(new_errors, arr);
            }
            errors = new_errors;
        }

        // 1st layer
        for (int i = 0; i < layers[0].length; i++) {
            layers[0][i].learn(errors[i]);
        }
    }

    private void add_errors(float[] errors, float[] arr) {
        for (int j = 0; j < arr.length; j++)
            errors[j] += arr[j];
    }

    public Node[] create_layer(float[] values, int size) {
        Node[] layer = new Node[size];
        for (int j = 0; j < size; j++) {
            layer[j] = new Node(values);
        }
        return layer;
    }

    public Node[] create_layer(float[] values, String[] nodes) {
        Node[] layer = new Node[nodes.length];
        for (int j = 0; j < nodes.length; j++) {
            layer[j] = new Node(values, nodes[j]);
        }
        return layer;
    }

    public String toString() {

        String output = "Inputs:" + inputs.length + "\n";
        for (Node[] layer : layers) {
            output += "[";
            for (Node node : layer) {
                output += node + ", ";
            }
            output += "]\n";
        }
        return output;
    }

    public void save(String file_name) {
        while (!Save_File.save(file_name, toString()))
            ;
    }

    public static Network load(String file_name) {
        String load = Save_File.load(file_name);
        if (load == null) {
            return null;
        }
        System.out.println(load);
        return new Network(load);

    }

}
