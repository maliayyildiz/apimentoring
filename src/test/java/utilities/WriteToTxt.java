package utilities;



import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToTxt {

    public static void saveDataInFile(String fileName) {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName,true));
            //writer.append()

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
