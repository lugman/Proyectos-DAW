/*
 * Created by Lugman Sami 2/06/17 18:522/06/17 18:52
 * Copyright (c) 2017.
 * you the  lugman	don't have right to modifify or alter this app.
 */

package es.com.lugman.www.diarytask;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

import static android.media.RingtoneManager.getDefaultUri;

/**
 * Created by lugman on 28/05/17.
 */

public class MyService extends Service {
    private static final String TAG="Myservice";
    String tarea,hora,minuto;
    List<Task> task;
    DataBaseSQLite baseDatos;
    boolean aviso;
    Notification.Builder builder;


    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG,"INICIO SERVICIO");
        baseDatos=new DataBaseSQLite(getApplicationContext());
        aviso=false;
        builder = new Notification.Builder(getApplicationContext());

    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        new Thread(new Runnable() {
            @Override
            public void run() {

                while(true) {

                    try {
                        Thread.sleep(60000);
                        task=baseDatos.getTasks();
                        Calendar cal=new GregorianCalendar(TimeZone.getTimeZone("Europe/Madrid"));
                        Date a=cal.getTime();
                        int year=cal.get(Calendar.YEAR);
                        int month=cal.get(Calendar.MONTH)+1;
                        int day=cal.get(Calendar.DAY_OF_MONTH);
                        int hour=a.getHours();
                        int minutes=a.getMinutes();

                        String year1=String.valueOf(year);
                        String month1=String.valueOf(month);
                        String day1=String.valueOf(day);
                        String hour1=String.valueOf(hour);
                        String minute1=String.valueOf(minutes);

                        for (int i=0;i<task.size();i++){
                            if (task.get(i).getYear().equals(year1)){
                                if (task.get(i).getMonth().equals(month1)){
                                    if (task.get(i).getDay().equals(day1)){
                                        if (task.get(i).getHour().equals(hour1)){
                                            if (task.get(i).getMinute().equals(minute1)){
                                                if (task.get(i).getCheck().equals("no")) {
                                                    aviso = true;
                                                    tarea = task.get(i).getTask();
                                                    hora = task.get(i).getHour();
                                                    minuto = task.get(i).getMinute();

                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }


                        if (aviso) {

                            NotificationManager nManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

                            Uri soundUri = getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                            NotificationCompat.Builder builder = new NotificationCompat.Builder(
                                    getBaseContext())
                                    .setSmallIcon(R.drawable.iapp)
                                    .setContentTitle(tarea)
                                    .setContentText(hora+":"+minuto)
                                    .setAutoCancel(true)
                                    .setSound(soundUri)
                                    .setWhen(System.currentTimeMillis());



                            nManager.notify(12345, builder.build());


                        }else {
                            Log.d("Prueva fecha","Don't is the time");
                        }


                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    aviso=false;

                }


            }

        }).start();

//		this.stopSelf();
        return super.onStartCommand(intent, flags, startId);
    }
//
//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        Log.d(TAG,"STOP SERVICIO");
//    }
}

