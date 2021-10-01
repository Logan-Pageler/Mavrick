package Utils;

import java.io.*;

public class Save_File {
    public static boolean save(String file_name, String payload) {
        try {
            FileWriter myWriter = new FileWriter(file_name);
            myWriter.write(payload);
            myWriter.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public static String load(String file_name) {
        String output = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(file_name));
            String line;
            while ((line = br.readLine()) != null) {
                output += line + "\n";
            }
            br.close();
        } catch (IOException e) {
            return null;
        }
        return output;
    }

}
