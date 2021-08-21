/*
 * Copyright (c) © 2018 Lugman Sami Ahmad Masnilla.
 * El poseedor del Copyright tiene los siguientes derechos:
 * DERECHOS DE AUTOR.
 * Todos los contenidos de este Sitio (Incluyendo, pero no limitado a, texto, logotipos, contenido, fotografías, audio, botones, nombres comerciales y vídeo) están sujetos a derechos de propiedad por las leyes de Derechos de Autor y demás Leyes relativas Internacionales a Majo Mexa Producciones Ceamic i de terceros titulares de los mismos que han autorizado debidamente su inclusión.
 *
 */

package es.com.lugman.appfinal2;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Lugman on 02/02/2018.
 */

public class Adaptador extends BaseAdapter {
    ArrayList<Monedas> list;
    Context context;
    global obj;

    public Adaptador(ArrayList<Monedas> list, Context context, global obj) {
        this.list = list;
        this.context = context;
        this.obj = obj;
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewH;
        if (convertView == null) {
            viewH = new ViewHolder();
            LayoutInflater inf = LayoutInflater.from(context);
            convertView = inf.inflate(R.layout.item, null);
            viewH.imagen = convertView.findViewById(R.id.imageView);
            viewH.Nombre = convertView.findViewById(R.id.textView);
            viewH.Valor = convertView.findViewById(R.id.textView2);
            viewH.Volumen = convertView.findViewById(R.id.textView3);
            viewH.num = convertView.findViewById(R.id.textView17);
//            viewH.rank = convertView.findViewById(R.id.textView19);
            convertView.setTag(viewH);

        } else {
            viewH = (ViewHolder) convertView.getTag();


        }
        viewH.imagen.setImageBitmap(list.get(position).getImage());

        viewH.Nombre.setText(list.get(position).getName() + "(" + list.get(position).getSymbol() + ")");
        viewH.Valor.setText(list.get(position).getPrice_usd() + "$");
        viewH.num.setText(list.get(position).getRank());
        double por = Double.parseDouble(list.get(position).getPercent_change_24h());
        if (por == 0) {
            viewH.Volumen.setTextColor(Color.BLUE);
        } else if (por > 0) {
            viewH.Volumen.setTextColor(Color.GREEN);
        } else {
            viewH.Volumen.setTextColor(Color.RED);
        }
        viewH.Volumen.setText(list.get(position).getPercent_change_24h() + "%");
//        viewH.rank.setText(list.get(position).getRank());


        return convertView;
    }

    private class ViewHolder {
        ImageView imagen;
        TextView Nombre;
        TextView Valor;
        TextView Volumen;
        TextView num;
        TextView rank;
    }

}
