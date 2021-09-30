public class Network {
    Node[][] layers;
    double [][] values;
    double [] inputs;

    
    public Network(int[] size) {
        layers = new Node[size.length - 1][];
        values = new double[size.length - 1][];

        //Create input layer
        layers[0] = new Node[size[1]];
        inputs = new double[size[0]];
        layers[0] = create_layer(inputs);

        //Create rest of layers
        for(int i = 1; i < layers.length; i++) {

            layers[i] = new Node[size[i + 1]];
            values[i] = new double[size[i + 1]];
            layers[i] = create_layer(values[i]);
        }
    }

    public double[] calc_output(double[] in) {
        for(int i = 0; i < in.length; i++) {
            inputs[i] = in[i];
        }
        
        for(int i = 1; i < layers.length; i++) {
            for(int j = 0; j < layers[i].length; j++) {
                values[i][j] = layers[i][j].calc_value();
            }
        }
        
        return values[values.length - 1];
    }

    public void learn(double[] expected) { 
        int index = layers.length - 1;
        double[] errors = new double[layers[index - 1].length];

        //output layer
        for(int i = 0; i < layers[index].length; i++) {
            double[] arr = layers[index][i].learn(expected[i] - values[index][i]);
            add_errors(errors, arr);       
        }

        //hidden layers
        for(int i = layers.length - 2; i > 0; i--) {
            double[] new_errors = new double[layers[i-1].length];
            for(int j = 0; j < layers[i].length; j++) {
                double[] arr = layers[i][j].learn(errors[j]);
                add_errors(new_errors, arr);
            }
            errors = new_errors;
        }

        //1st layer
        for(int i = 0; i < layers[0].length; i++) {
            layers[0][i].learn(errors[i]);      
        }
    }

    private void add_errors(double[] errors, double[] arr){ 
        for(int j = 0; j < arr.length; j++)
            errors[j] += arr[j];
    }

    public Node[] create_layer(double[] values) {
        Node[] layer = new Node[values.length];
        for(int j = 0; j < values.length; j++) {
            layer[j] = new Node(values);
        }
        return layer;
    }

    public String toString() {
        String output = "";
        for(Node[] layer : layers) {
            output += "[";
            for(Node node : layer) {
                output += node + ", ";
            }
            output += "]\n";
        }
        return output;
    }

}
