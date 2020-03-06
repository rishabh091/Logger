import console.print.ConsolePrint;
import java.io.IOException;

/**
 * Logger made by Rishabh Malhotra
 * email : rishabhmalhotra091@gmail.com
 *
 * feel free to contact if any bugs are found
 *
 * for saving logs in a file create logger.json file in resources folder
 * sample file =>
 *[
 *   {
 *     "logger.location": "E:\\Java\\Maven Projects\\Logger\\log",
 *     "logger.fileType": "txt"
 *   },
 *   {
 *     "logger.location": "E:\\Java\\Maven Projects\\Logger\\logTest",
 *     "logger.fileType": "html"
 *   }
 * ]
 *
 * use it as a array as it supports multiple logging
 * **/
public class Logger {

    private ConsolePrint consolePrint;
    private static final String logType="log";
    private static final String debugType="debug";
    private static final String errorType="error";

    //initialise all the objects required for every functionality
    public Logger(){
        try{
            consolePrint=new ConsolePrint();
        }
        catch (IOException e){
            System.err.println(e);
        }
    }

    public void log(Object... objects){
        try{
            //calling consolePrintFunction
            consolePrint.consolePrint(objects,logType);
        }
        catch (IOException e){
            System.err.println(e);
        }
    }

    public void debug(Object... objects){
        try{
            consolePrint.consolePrint(objects,debugType);
        }
        catch (IOException e){
            System.err.println(e);
        }
    }

    public void error(Object... objects){
        try{
            consolePrint.consolePrint(objects,errorType);
        }
        catch (IOException e){
            System.err.println(e);
        }
    }
}
