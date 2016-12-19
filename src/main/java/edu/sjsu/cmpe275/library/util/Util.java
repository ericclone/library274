package edu.sjsu.cmpe275.library.util;

import org.json.JSONArray;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by aa001 on 12/18/16.
 */
public class Util {
    static int daysAhead = 0;
    public static Date getDate() {
        return getDateAfter(0);
    }
    public void moveAhead(int days) {
        daysAhead += days;
    }
    public int getDaysAhead() {
        return daysAhead;
    }
    public void setDaysAhead(int days) {
        daysAhead = days;
    }
    public static Date getDateAfter(int days) {
        Date currentDate = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);
        c.add(Calendar.DATE, daysAhead + days);
        return c.getTime();
    }
    public static String jsonArrayToString(JSONArray jsonArray) {
        int arraySize = jsonArray.length();
        String[] stringArray = new String[arraySize];

        for(int i=0; i<arraySize; i++) {
            stringArray[i] = (String) jsonArray.get(i);
        }

        return String.join(", ", stringArray);
    }
}
