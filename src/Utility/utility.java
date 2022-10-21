package Utility;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class utility {
    public static String convertCurrentDateTimeToFormatSpecified(String dateFormat) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        String strDate = sdf.format(cal.getTime());
        return strDate;
    }
}
