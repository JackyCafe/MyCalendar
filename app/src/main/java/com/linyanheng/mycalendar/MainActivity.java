package com.linyanheng.mycalendar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;
import android.widget.ListAdapter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    GridView gv;
    private GridViewAdapter adapter;
    private List<String> data = new ArrayList<>();
    private int [] days_of_month = new int[] {31,28,31,30,31,30,31,31,30,31,30,31};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gv = (GridView) findViewById(R.id.gv);
        calendar();
        adapter = new GridViewAdapter(this,data);
        gv.setAdapter(adapter);
    }


     public void calendar(){
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        c.set(year,month,01);
        Calendar baseCalendar = Calendar.getInstance();
        baseCalendar.set(1752,9,1);
        Date date1 = c.getTime();
        Date baseDate = baseCalendar.getTime();
        int diffDate = (int) ((date1.getTime()-baseDate.getTime())/(24*60*60*1000));
        if(isLeapYear(year))
        {
              days_of_month[1]=29;
        }
        int weekindex = diffDate % 7 +1;
        for(int j = 0;j <weekindex;j++)
            data.add(" ");

        int days = days_of_month[month];
        for (int j = 1;j<days;j++)
            data.add(" "+j);


     }

    public  boolean isLeapYear(int year) {

        boolean isLeap = false;
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    isLeap = true;
                } else {
                    isLeap = false;
                }
            } else {
                isLeap = true;
            }

        } else {
            isLeap = false;
        }
        return isLeap;
    }
}
