package file.saveLogs;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SaveInFile {

    private final String location;

    public SaveInFile(String location){
        this.location=location;
    }

    public String saveDataAsTxt(String str) throws IOException {
        FileWriter fileWriter=new FileWriter(location);
        BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);

        bufferedWriter.append(str);
        bufferedWriter.flush();

        return " Logs stored in "+location;
    }
}
