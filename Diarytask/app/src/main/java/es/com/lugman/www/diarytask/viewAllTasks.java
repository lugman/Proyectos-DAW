/*
 * Created by Lugman Sami 2/06/17 18:522/06/17 18:52
 * Copyright (c) 2017.
 * you the  lugman	don't have right to modifify or alter this app.
 */

package es.com.lugman.www.diarytask;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class viewAllTasks extends AppCompatActivity {
    ListView lista;
    List<Task> tasks;
    MyListAdapter adater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        DataBaseSQLite BaseDatos = new DataBaseSQLite(getApplicationContext());
        tasks = BaseDatos.getTasks();
        lista= (ListView) findViewById(R.id.listas);
         adater = new MyListAdapter(getApplicationContext(), tasks,"b");
        lista.setAdapter(adater);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (tasks.get(position).getCheck().equals("no")){
                    tasks.get(position).setCheck("yes");
                    DataBaseSQLite tar=new DataBaseSQLite(getApplicationContext());
                    tar.updateTask(tasks.get(position));
                    lista.setAdapter(adater);
                }else{
                    tasks.get(position).setCheck("no");
                    DataBaseSQLite tar=new DataBaseSQLite(getApplicationContext());
                    tar.updateTask(tasks.get(position));
                    lista.setAdapter(adater);
                }


            }
        });
        lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                DataBaseSQLite tar=new DataBaseSQLite(getApplicationContext());
                tar.deleteTasks(tasks.get(position));
                Intent i=new Intent(getApplicationContext(),viewAllTasks.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(),"DELETED",Toast.LENGTH_SHORT).show();
                return true;
            }
        });


    }
}
