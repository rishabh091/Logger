package file.saveLogs;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;

public class SaveInFile {

    private ArrayList<String> location;
    private ArrayList<String> fileType;

    public SaveInFile() throws IOException {
        location=new ArrayList<>();
        fileType=new ArrayList<>();

        getLocationFromUser();
    }

    public String saveData(String data) throws IOException{
        String result="";

        //reading every location and then appending the files present there
        for(int i = 0; i<this.location.size(); i++){
            FileWriter fileWriter=new FileWriter(this.location.get(i)+"."+this.fileType.get(i),true);
            BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);

            if(this.fileType.get(i).equals("txt")){
                result=saveDataAsTxtOrDocOrDocx(bufferedWriter,data);
            }
            else{
                result=saveDataAsHTML(bufferedWriter,data);
            }
        }

        return result;
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

    //a simple function to get logger.json created in resources folder
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

        JSONArray jsonArray=new JSONArray(stringBuilder.toString());
        for(int i=0;i<jsonArray.length();i++){
            JSONObject jsonObject=jsonArray.getJSONObject(i);

            this.location.add(jsonObject.getString(configLocation));
            this.fileType.add(jsonObject.getString(typeString));
        }
    }
}
