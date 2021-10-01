public class Network {
    Node[][] layers;
    double[][] values;
    double[] inputs;

    public Network(int[] size) {
        layers = new Node[size.length - 1][];
        values = new double[size.length - 1][];

        // Create input layer
        values[0] = new double[size[1]];
        inputs = new double[size[0]];
        layers[0] = create_layer(inputs, size[1]);

        // Create rest of layers
        for (int i = 1; i < layers.length; i++) {
            values[i] = new double[size[i + 1]];
            layers[i] = create_layer(values[i - 1], size[i + 1]);
        }
    }

    //load from save
    public Network(String string) {

        String[] layers = string.split("\n");

        String[][] nodes = new String[layers.length - 1][];
        for (int i = 0; i < layers.length - 1; i++) {
            nodes[i] = layers[i + 1].substring(2, layers[i + 1].length() - 3).split("\\}, \\{");
        }

        this.layers = new Node[nodes.length][];
        values = new double[nodes.length][];

        //create input layer
        values[0] = new double[nodes[0].length];
        inputs = new double[Integer.parseInt(layers[0].substring(layers[0].indexOf(":") + 1))];
        this.layers[0] = create_layer(inputs, nodes[0]);

        //create rest of layers
        for (int i = 1; i < values.length; i++) {
            values[i] = new double[nodes[i].length];
            this.layers[i] = create_layer(values[i - 1], nodes[i]);
        }
    }

    public double[] calc_output(double[] in) {
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

    public void learn(double[] expected) {
        int index = layers.length - 1;
        double[] errors = new double[layers[index - 1].length];

        // output layer
        for (int i = 0; i < layers[index].length; i++) {
            double[] arr = layers[index][i].learn(expected[i] - values[index][i]);
            add_errors(errors, arr);
        }

        // hidden layers
        for (int i = layers.length - 2; i > 0; i--) {
            double[] new_errors = new double[layers[i - 1].length];
            for (int j = 0; j < layers[i].length; j++) {
                double[] arr = layers[i][j].learn(errors[j]);
                add_errors(new_errors, arr);
            }
            errors = new_errors;
        }

        // 1st layer
        for (int i = 0; i < layers[0].length; i++) {
            layers[0][i].learn(errors[i]);
        }
    }

    private void add_errors(double[] errors, double[] arr) {
        for (int j = 0; j < arr.length; j++)
            errors[j] += arr[j];
    }

    public Node[] create_layer(double[] values, int size) {
        Node[] layer = new Node[size];
        for (int j = 0; j < size; j++) {
            layer[j] = new Node(values);
        }
        return layer;
    }

    public Node[] create_layer(double[] values, String[] nodes) {
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


}
