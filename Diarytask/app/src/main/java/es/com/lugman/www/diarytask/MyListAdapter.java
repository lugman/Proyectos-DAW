/*
 * Created by Lugman Sami 2/06/17 18:522/06/17 18:52
 * Copyright (c) 2017.
 * you the  lugman	don't have right to modifify or alter this app.
 */

package es.com.lugman.www.diarytask;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by lugman on 28/05/17.
 */

class MyListAdapter extends BaseAdapter {
    String tipe;
    Context context;
    List<Task> tasks;
    public MyListAdapter(Context context,List<Task> tasks) {
        this.context=context;
        this.tasks=tasks;
        tipe="a";

    }
    public MyListAdapter(Context context,List<Task> tasks,String tipe) {
        this.context=context;
        this.tasks=tasks;
        this.tipe=tipe;

    }


    @Override
    public int getCount() {
        return tasks.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(tipe.equals("a")) {
            if (convertView == null) {
                convertView = LayoutInflater.from(context).inflate(R.layout.listask, parent, false);
            }
            TextView text1 = (TextView) convertView.findViewById(R.id.textView7);
//        Log.d("minute"," "+tasks.get(position).minute);
            if ((Integer.parseInt(tasks.get(position).getMinute()) >= 0) && (Integer.parseInt(tasks.get(position).getMinute()) <= 9)) {
                text1.setText(tasks.get(position).getHour() + ":0" + tasks.get(position).getMinute());
            } else {
                text1.setText(tasks.get(position).getHour() + ":" + tasks.get(position).getMinute());
            }

            TextView text = (TextView) convertView.findViewById(R.id.textView2);
            String textito = (String) tasks.get(position).getTask();
            text.setText(textito);
            ImageView img = (ImageView) convertView.findViewById(R.id.imageView2);
            if (tasks.get(position).getImportance().equals("0")) {
                img.setImageResource(R.drawable.alta);
            } else if (tasks.get(position).getImportance().equals("1")) {
                img.setImageResource(R.drawable.media);
            } else {
                img.setImageResource(R.drawable.baja);
            }
            ImageView img2 = (ImageView) convertView.findViewById(R.id.imageView3);

            LinearLayout lay = (LinearLayout) convertView.findViewById(R.id.lay);
            if (tasks.get(position).getCheck().equals("yes")) {
                img2.setImageResource(R.drawable.check1);
            } else {
                img2.setImageResource(R.drawable.nocheck);
            }
        }else {
            if (convertView == null) {
                convertView = LayoutInflater.from(context).inflate(R.layout.listask, parent, false);
            }
            TextView text1 = (TextView) convertView.findViewById(R.id.textView7);
            text1.setText(tasks.get(position).getDay() + "-" + tasks.get(position).getMonth()+ "-" + tasks.get(position).getYear()+ "  ");
//        Log.d("minute"," "+tasks.get(position).minute);
            if ((Integer.parseInt(tasks.get(position).getMinute()) >= 0) && (Integer.parseInt(tasks.get(position).getMinute()) <= 9)) {
                text1.append(tasks.get(position).getHour() + ":0" + tasks.get(position).getMinute());
            } else {
                text1.append(tasks.get(position).getHour() + ":" + tasks.get(position).getMinute());
            }
            text1.setTextSize(12);

            TextView text = (TextView) convertView.findViewById(R.id.textView2);
            String textito = (String) tasks.get(position).getTask();
            text.setText(textito);
            ImageView img = (ImageView) convertView.findViewById(R.id.imageView2);
            if (tasks.get(position).getImportance().equals("0")) {
                img.setImageResource(R.drawable.alta);
            } else if (tasks.get(position).getImportance().equals("1")) {
                img.setImageResource(R.drawable.media);
            } else {
                img.setImageResource(R.drawable.baja);
            }
            ImageView img2 = (ImageView) convertView.findViewById(R.id.imageView3);

            LinearLayout lay = (LinearLayout) convertView.findViewById(R.id.lay);
            if (tasks.get(position).getCheck().equals("yes")) {
                img2.setImageResource(R.drawable.check1);
            } else {
                img2.setImageResource(R.drawable.nocheck);
            }
        }

        return convertView;

    }
}
