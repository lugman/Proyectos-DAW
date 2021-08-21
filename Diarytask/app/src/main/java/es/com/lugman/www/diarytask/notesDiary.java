/*
 * Created by Lugman Sami 2/06/17 18:522/06/17 18:52
 * Copyright (c) 2017.
 * you the  lugman	don't have right to modifify or alter this app.
 */

package es.com.lugman.www.diarytask;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class notesDiary extends AppCompatActivity {
    DatePicker datePicker;
    TextView textView;
    String day,month,year;
    List<Task> tar,tar2;
    ImageButton imaB;
    Button setDate;
    int note;

    DataBaseSQLite bas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        imaB = (ImageButton) findViewById(R.id.imageButton);
        setDate= (Button) findViewById(R.id.button6);

        textView= (TextView) findViewById( R.id.textView12);
        datePicker=(DatePicker) findViewById(R.id.datePicker);

        tar=new ArrayList<Task>();
        tar2=new ArrayList<Task>();

        bas=new DataBaseSQLite(getApplicationContext());
        note=0;
        tar = bas.getTasks2();
        cambiarHora();
        traerNotas();
        vernotas();
        pasarnotas();
        setDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("No Found notes of this day");
                cambiarHora();
                traerNotas();
                vernotas();
            }
        });






    }
    public void cambiarHora(){
        day = String.valueOf(datePicker.getDayOfMonth());
        month = String.valueOf(datePicker.getMonth() + 1);
        year = String.valueOf(datePicker.getYear());
        Log.d("cambio",year+" "+month+" "+day);


    }
    public void traerNotas(){
        tar2.clear();
        for (int i = 0; i < tar.size(); i++) {

            String a, b, c;
            a = tar.get(i).getYear();
            b = tar.get(i).getMonth();
            c = tar.get(i).getDay();
            Log.d("bucle",a+" "+b+" "+c+ " "+year+" "+month+" "+day);


            if (year.equals(a)) {
                Log.d("a", "va");
                if (month.equals(b)) {
                    Log.d("b", "va");
                    if (day.equals(c)) {
                        tar2.add(tar.get(i));
                        Log.d("c", tar2.get(i).getTask());
                    }
                }
            }
        }

    }

    public  void vernotas(){
        try {
            Task tarea = new Task();
            tarea = tar2.get(0);
            textView.setText(tarea.getTask());

        } catch (IndexOutOfBoundsException a) {
            Toast.makeText(getApplicationContext(), "Don't fonud any Hystory Day", Toast.LENGTH_SHORT).show();
            textView.setText("Don hav Histories for this thay");
        } finally {

        }
    }
    public  void pasarnotas (){
        imaB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tar2.size() > 1) {
                    if (tar2.size() > note + 1) {
                        note++;
                        Task tarea = new Task();
                        tarea = tar2.get(note);
                        textView.setText(tarea.getTask());
                    } else {
                        note = 0;
                        Task tarea = new Task();
                        tarea = tar2.get(note);
                        textView.setText(tarea.getTask());
                    }
                }
            }
        });
    }
}
