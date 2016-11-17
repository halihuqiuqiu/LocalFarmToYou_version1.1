package edu.iit.cs445.usecases;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by YongYang on 11/17/16.
 */
public class HelperDate {
    public static String getTodayDateyyyyMMdd(){
        String DATE_FORMAT="yyyyMMdd";
        SimpleDateFormat sdf= new SimpleDateFormat(DATE_FORMAT);
        Calendar c1 =Calendar.getInstance();
        return sdf.format(c1.getTime());

    }
    public static String getTomorrowDateyyyyMMdd(){
        String DATE_FORMAT="yyyyMMdd";
        SimpleDateFormat sdf= new SimpleDateFormat(DATE_FORMAT);
        Calendar c1 =Calendar.getInstance();
        c1.add(Calendar.DATE, 1);
        return sdf.format(c1.getTime());

    }
}
