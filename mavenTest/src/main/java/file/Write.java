package file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Write {
    public static void main(String[] args) throws IOException {
        File file = new File("test_"+System.nanoTime()+".json");
        if(!file.exists()){
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file.getName(), true);
        fileWriter.write("content");
        fileWriter.close();

        System.out.println("finish");
    }
}
