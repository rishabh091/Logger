package file.saveLogs;

import org.json.JSONObject;

import java.io.*;

public class SaveInFile {

    private String location;
    private String fileType;

    public SaveInFile() throws IOException {
        getLocationFromUser();
    }

    public String saveData(String data) throws IOException{
        FileWriter fileWriter=new FileWriter(location+"."+fileType,true);
        BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);

        if(this.fileType.equals("txt")
        || this.fileType.equals("doc")
        || this.fileType.equals("docx")){
            return saveDataAsTxtOrDocOrDocx(bufferedWriter,data);
        }
        else{
            return saveDataAsHTML(bufferedWriter,data);
        }
    }

    private String saveDataAsHTML(BufferedWriter bufferedWriter,String data) throws IOException{
        bufferedWriter.append("<p>");
        bufferedWriter.append(data);
        bufferedWriter.append("</p>");

        bufferedWriter.flush();

        return "Logs stored in "+location;
    }

    private String saveDataAsTxtOrDocOrDocx(BufferedWriter bufferedWriter,String data) throws IOException {
        bufferedWriter.newLine();
        bufferedWriter.append(data);
        bufferedWriter.flush();

        return " Logs stored in "+location;
    }

    private void getLocationFromUser() throws IOException {
        final String configFile = "/logger.json";
        final String configLocation = "logger.location";
        final String typeString="logger.fileType";

        InputStream inputStream= SaveInFile.class.getResourceAsStream(configFile);
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder=new StringBuilder();
        String line;

        while((line=bufferedReader.readLine()) != null){
            stringBuilder.append(line);
        }

        JSONObject jsonObject=new JSONObject(stringBuilder.toString());
        this.fileType=jsonObject.getString(typeString);
        this.location=jsonObject.getString(configLocation);
    }
}
