package myUtility;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil
{
    public static String getTodayDate()
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(new Date());
    }

  }
