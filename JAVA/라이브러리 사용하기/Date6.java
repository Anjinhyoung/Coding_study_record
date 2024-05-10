import java.util.Calendar;
import java.util.Date;

public class Date6 {
public static void main(String[] args) {
	//Calendar -> Date
	Calendar calendar = Calendar.getInstance();
	Date date=calendar.getTime();
	System.out.println(date);
	
	//Date->Calendar
	calendar.setTime(date);
	
	//Calendar->long
	long time=calendar.getTimeInMillis();
	System.out.println(time);
	
	//long->Calendar
	calendar.setTimeInMillis(time);
}
}

