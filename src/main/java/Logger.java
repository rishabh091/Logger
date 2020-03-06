import console.print.ConsolePrint;
import java.io.IOException;

public class Logger {

    private ConsolePrint consolePrint;
    private static final String logType="log";
    private static final String debugType="debug";
    private static final String errorType="error";

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
