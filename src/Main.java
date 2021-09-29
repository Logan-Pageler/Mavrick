import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        System.out.print("{");
        for (int i = 0; i < 100; i++) {
            double val = 1 / (1 + Math.pow(Math.E, (10 - i / 5)));
            System.out.print(val + ", ");
            if (i % 10 == 9) {
                System.out.println();
            }

        }
        System.out.print("};");
    }
}
