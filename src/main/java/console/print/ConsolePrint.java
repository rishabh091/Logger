package console.print;

import file.saveLogs.SaveInFile;
import time.Time;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class ConsolePrint {

    private BufferedWriter bufferedWriter;
    private StringBuilder stringBuilder;
    private SaveInFile saveInFile;

    private final String stringClassName="java.lang.String";

    public ConsolePrint() throws IOException {
        bufferedWriter=new BufferedWriter(new OutputStreamWriter(System.out));
        saveInFile=new SaveInFile();
    }

    public void consolePrint(Object[] arr,String logType) throws IOException {
        //will get current Time
        Time time=new Time();
        stringBuilder=new StringBuilder();

        stringBuilder.append(time.getCurrentTime()).append(" ").append(logType).append(" ");

        //logic to replace {} with the next parameter only if the next parameter is not string
        for(int i=0;i<arr.length;i++){
            if(i != arr.length-1){
                if(arr[i].getClass().getName().equals(stringClassName)){
                    if(arr[i].toString().contains("{}") && !arr[i+1].getClass().getName().equals(stringClassName)){
                        arr[i]=arr[i].toString().replace("{}",arr[i+1].toString());
                        arr[i+1]="";
                    }
                }
            }

            stringBuilder.append(arr[i]).append(" ");
        }
        //this will also save logs to the files
        stringBuilder.append(saveInFile.saveData(stringBuilder.toString()));
        stringBuilder.append("\n");

        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.flush();
    }
}
