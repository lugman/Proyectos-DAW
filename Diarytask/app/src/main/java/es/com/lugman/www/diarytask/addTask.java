/*
 * Created by Lugman Sami 2/06/17 18:522/06/17 18:52
 * Copyright (c) 2017.
 * you the  lugman	don't have right to modifify or alter this app.
 */

package es.com.lugman.www.diarytask;

import android.annotation.TargetApi;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.ArrayList;

public class addTask extends AppCompatActivity {
    TextView textView;
    Spinner spinner;
    EditText editText;
    TimePicker timePicker;
    Button acept,cancel;
    String year_get,month_get,day_get;

    DataBaseSQLite baseD;
    Task tarea=new Task();
    ArrayList<String> prio;
    private static final int NOTIF_ALERTA_ID = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        editText=(EditText)findViewById(R.id.editText);
        timePicker=(TimePicker) findViewById(R.id.timePicker2);
        acept=(Button) findViewById(R.id.button);
        cancel=(Button) findViewById(R.id.button2);

        final Intent intent = getIntent();
        year_get = intent.getStringExtra("year");
        month_get = intent.getStringExtra("month");
        day_get = intent.getStringExtra("day");
        baseD= new DataBaseSQLite(getApplicationContext());

        textView= (TextView) findViewById(R.id.text2T);
        textView.append(" "+day_get+"-"+month_get+"-"+year_get);

        spinner= (Spinner) findViewById(R.id.spinner);
        prio=new ArrayList<>();
        prio.add("Important");
        prio.add("Normal");
        prio.add("Not Important");
        ArrayAdapter<String> adapt=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,prio);
        spinner.setAdapter(adapt);




        acept.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {


                Editable editext=editText.getText();
                String variable=editext.toString();
                tarea.setTask(variable);
                tarea.setImportance(String.valueOf(spinner.getSelectedItemId()));

                tarea.setYear(year_get.toString());
                tarea.setMonth(month_get.toString());
                tarea.setDay(day_get.toString());

                Log.d("Añadir tarea",year_get+tarea.getMonth()+tarea.getDay());


                String a=String.valueOf(timePicker.getHour());
                tarea.setHour(a);
                a=String.valueOf(timePicker.getMinute());
                tarea.setMinute(a);

                baseD.addtask(tarea);
                MediaPlayer mp = MediaPlayer.create(getApplicationContext(),R.raw.addtask);
                mp.start();
                Intent intent1=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent1);



            }


        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent1);
            }
        });
//        baseD.addtask();



    }
}