package time;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {

    private final SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    public String getCurrentTime(){
        Date date=new Date();

        return simpleDateFormat.format(date);
    }
}
