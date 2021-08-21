/*
 * Created by Lugman Sami 2/06/17 18:522/06/17 18:52
 * Copyright (c) 2017.
 * you the  lugman	don't have right to modifify or alter this app.
 */

package es.com.lugman.www.diarytask;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class diaryWriter extends AppCompatActivity {
    CalendarView cal;
    Calendar calendarNow;
    int monthDay,month,year;
    Task tar;
    DataBaseSQLite base;
    Button btn1,btn2;
    EditText editText;
    Intent intent1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        cal= (CalendarView) findViewById(R.id.calendarView4);
        btn1=(Button) findViewById(R.id.button3);
        btn2=(Button) findViewById(R.id.button4);
        tar=new Task();
        editText=(EditText)findViewById(R.id.editText2);
        base=new DataBaseSQLite(getApplicationContext());
        intent1=new Intent(getApplicationContext(),MainActivity.class);

        calendarNow = new GregorianCalendar(TimeZone.getTimeZone("Europe/Madrid"));
        monthDay = calendarNow.get(Calendar.DAY_OF_MONTH);
        month = calendarNow.get(Calendar.MONTH) + 1;
        year = calendarNow.get(Calendar.YEAR);

        cal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year1, int month1, int dayOfMonth1) {
                monthDay = dayOfMonth1;
                month=month1+1;
                year=year1;

            }
        });

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tar.setDay(String.valueOf(monthDay));
                    tar.setMonth(String.valueOf(month));
                    tar.setYear(String.valueOf(year));

                    tar.setTask(editText.getText().toString());
                    base.addtask2(tar);
                    startActivity(intent1);

                }
            });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent1);
            }
        });





    }
}
