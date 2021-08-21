/*
 * Created by Lugman Sami 2/06/17 18:522/06/17 18:52
 * Copyright (c) 2017.
 * you the  lugman	don't have right to modifify or alter this app.
 */

package es.com.lugman.www.diarytask;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {
    CalendarView calendarView;
    Context context;
    ListView listView;
    ImageView checkBox;
    List<Task> tarea, tarea_now;
    AlertDialog.Builder dialogo1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialogo1 = new AlertDialog.Builder(this);
        dialogo1.setTitle("Important");
        dialogo1.setMessage("¿Are you sure you want to delete this task ?");
        dialogo1.setCancelable(false);
        dialogo1.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {

            }
        });
        dialogo1.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {

            }
        });


        startService(new Intent(MainActivity.this,MyService.class));

        context = getApplicationContext();

        calendarView = (CalendarView) findViewById(R.id.calendarView);
        listView = (ListView) findViewById(R.id.listView);







        final DataBaseSQLite BaseDatos = new DataBaseSQLite(getApplicationContext());

        tarea = new ArrayList<Task>();
        tarea_now = new ArrayList<Task>();
        tarea = BaseDatos.getTasks();

        Calendar calendarNow = new GregorianCalendar(TimeZone.getTimeZone("Europe/Madrid"));
        int monthDay = calendarNow.get(Calendar.DAY_OF_MONTH);
        int month = calendarNow.get(Calendar.MONTH) + 1;
        int year = calendarNow.get(Calendar.YEAR);

        String year_now = String.valueOf(year);
        String month_now = String.valueOf(month);
        String day_now = String.valueOf(monthDay);

//        Log.d("Fecha acual",day_now+" "+month_now+" "+year_now);

        for (int i = 0; i < tarea.size(); i++) {
            String a, b, c;
            a = tarea.get(i).getYear();
            b = tarea.get(i).getMonth();
            c = tarea.get(i).getDay();
//            Log.d("TEST ", a + " " + b + " " + c + "  " + year_now + "  " + month_now + "  " + day_now);

            if (year_now.equals(a)) {
                if (month_now.equals(b)) {
                    if (day_now.equals(c)) {
                        tarea_now.add(tarea.get(i));
                    }
                }
            }
        }


        final MyListAdapter adater = new MyListAdapter(getApplicationContext(), tarea_now);
        listView.setAdapter(adater);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                Intent intent = new Intent(getApplicationContext(), addTask.class);
                String year1 = String.valueOf(year);
                String month1 = String.valueOf(month + 1);
                String day1 = String.valueOf(dayOfMonth);
                intent.putExtra("year", year1);
                intent.putExtra("month", month1);
                intent.putExtra("day", day1);
                startActivity(intent);


            }
        });


        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View inf = inflater.inflate(R.layout.listask, null);
        checkBox= (ImageView) inf.findViewById(R.id.imageView3);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"CLICK",Toast.LENGTH_SHORT).show();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (tarea_now.get(position).getCheck().equals("no")){
                    tarea_now.get(position).setCheck("yes");
                    DataBaseSQLite tar=new DataBaseSQLite(context);
                    tar.updateTask(tarea_now.get(position));
                    listView.setAdapter(adater);
                }else{
                    tarea_now.get(position).setCheck("no");
                    DataBaseSQLite tar=new DataBaseSQLite(context);
                    tar.updateTask(tarea_now.get(position));
                    listView.setAdapter(adater);
                }


            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                DataBaseSQLite tar=new DataBaseSQLite(context);
                tar.deleteTasks(tarea_now.get(position));
                Intent i=new Intent(context,MainActivity.class);
                startActivity(i);
                Toast.makeText(context,"DELETED",Toast.LENGTH_SHORT).show();
                return true;
            }
        });





    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case R.id.addNote:
                Intent in=new Intent(context,diaryWriter.class);
                startActivity(in);
                break;
            case R.id.viewAllTasks:
                in=new Intent(context,viewAllTasks.class);
                startActivity(in);
                break;
            case R.id.notesDiary:
                 in=new Intent(context,notesDiary.class);
                startActivity(in);
                break;
            case R.id.About_us:
                in=new Intent(context,About_us.class);
                startActivity(in);
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}
