package vn.framgia.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by FRAMGIA\duong.van.tien on 17/03/2017.
 */
public class testDate {

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String startDate  = "2017/02/23";
        try {
            Date start = sdf.parse(startDate);
            System.out.println(start);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
