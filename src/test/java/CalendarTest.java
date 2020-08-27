import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalendarTest {
    public static void main(String[] args) throws ParseException {
        Long tempTime = 1000l*60*60*24*30*4;
        Date nowTime = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date start_date = dateFormat.parse("2006-01-01");
        Date end_date= dateFormat.parse("2026-05-01");
        System.out.println(dateFormat.format(start_date));
        start_date.setTime(start_date.getTime()+tempTime);
        System.out.println(dateFormat.format(start_date));
        System.out.println(dateFormat.format(nowTime));
        System.out.println(nowTime.after(end_date));
    }
}
