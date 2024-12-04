package TurtleInterpreter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TurtleProgramParser {
    public TurtleProgramParser(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
