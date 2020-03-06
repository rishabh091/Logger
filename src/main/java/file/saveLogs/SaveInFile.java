package file.saveLogs;

import org.json.JSONObject;

import java.io.*;

public class SaveInFile {

    private final String location;

    public SaveInFile() throws IOException {
        this.location=getLocationFromUser();
    }

    public String saveDataAsTxt(String str) throws IOException {
        FileWriter fileWriter=new FileWriter(location,true);
        BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);

        bufferedWriter.newLine();
        bufferedWriter.append(str);
        bufferedWriter.flush();

        return " Logs stored in "+location;
    }

    private String getLocationFromUser() throws IOException {
        final String configFile = "/logger.json";
        final String configLocation = "logger.location";

        InputStream inputStream= SaveInFile.class.getResourceAsStream(configFile);
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder=new StringBuilder();
        String line;

        while((line=bufferedReader.readLine()) != null){
            stringBuilder.append(line);
        }

        JSONObject jsonObject=new JSONObject(stringBuilder.toString());

        return jsonObject.getString(configLocation);
    }
}
