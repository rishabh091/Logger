package console.print;

import time.Time;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class ConsolePrint {

    private BufferedWriter bufferedWriter;
    private StringBuilder stringBuilder;

    private final String stringClassName="java.lang.String";

    public ConsolePrint(){
        bufferedWriter=new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public void consolePrint(Object[] arr,String logType) throws IOException {
        //getTime
        Time time=new Time();
        stringBuilder=new StringBuilder();

        stringBuilder.append(time.getCurrentTime()).append(" ").append(logType).append(" ");

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
        stringBuilder.append("\n");

        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.flush();
    }
}
