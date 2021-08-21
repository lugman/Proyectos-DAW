package es.esy.reofertas.re_ofertas;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class MiAdaptador extends BaseAdapter{
    ArrayList<Anuncio> listaAnuncios;
    Context context;
    private static String PREFS_KEY = "mispreferencias";


    public MiAdaptador(ArrayList<Anuncio> listaAnuncios, Context context) {
        Log.d("Entro","Cost MiAdap Count: "+String.valueOf(listaAnuncios.size()));

        this.listaAnuncios = listaAnuncios;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listaAnuncios.size();
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
        Log.d("Entro"," getView ");
        ViewHolder viewHolder;


        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.anuncio_layout, parent, false);

            viewHolder.ciudad = (TextView) convertView.findViewById(R.id.ciudad);
            viewHolder.hora = (TextView) convertView.findViewById(R.id.hora);
            viewHolder.imagen = (ImageView) convertView.findViewById(R.id.imagen);
            viewHolder.titulo = (TextView) convertView.findViewById(R.id.Tit);
            viewHolder.desc = (TextView) convertView.findViewById(R.id.Desc);
            viewHolder.precio = (TextView) convertView.findViewById(R.id.Precio);
            viewHolder.FotoUs = (ImageView) convertView.findViewById(R.id.fotoUs);
            viewHolder.Verificado = (TextView) convertView.findViewById(R.id.verificao);
            viewHolder.Usuario = (TextView) convertView.findViewById(R.id.NombreUs);
            viewHolder.Seleccion = (CheckBox) convertView.findViewById(R.id.lista);
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            convertView=convertView;
        }

        viewHolder.ciudad.setText(listaAnuncios.get(position).getCiudad()+"("+listaAnuncios.get(position).getPoblacion()+")");
        viewHolder.titulo.setText(listaAnuncios.get(position).getCiudad());
        final int pos= position;
        viewHolder.Seleccion.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked){
                    guardarValor(context,"ID"+listaAnuncios.get(pos).getId(),listaAnuncios.get(pos).getId());                }
                else {
                    borraValor(context,"ID"+listaAnuncios.get(pos).getId());
                }
                Log.d("Buscar", "Existe : "+leerValor(context,"ID"+listaAnuncios.get(pos).getId()) );
            }
        });
        Log.d("IDE",leerValor(context,listaAnuncios.get(position).getId()));
        boolean seleccionado = leerValor(context,"ID"+listaAnuncios.get(position).getId()).equals("");
        Log.d("ID",leerValor(context,"ID"+listaAnuncios.get(position).getId()));
        Log.d("Selec",leerValor(context, String.valueOf(seleccionado)));
        if (seleccionado){
            viewHolder.Seleccion.setChecked(false);
        }else {
            viewHolder.Seleccion.setChecked(true);
        }

        if (listaAnuncios.get(position).getDescripcion().length()>80){

            viewHolder.desc.setText(listaAnuncios.get(position).getDescripcion().substring(0,79)+"...");
        }else {

            viewHolder.desc.setText(listaAnuncios.get(position).getDescripcion());
        }

        viewHolder.Usuario.setText(listaAnuncios.get(position).getUsuario().getNobre());
        viewHolder.hora.setText(listaAnuncios.get(position).getFecha());


        if (listaAnuncios.get(position).getUsuario().isVerificado()){
            viewHolder.Verificado.setText("Verificado");
            viewHolder.Verificado.setTextColor(Color.GREEN);
        }else {
            viewHolder.Verificado.setText("No Verifivado");
            viewHolder.Verificado.setTextColor(Color.RED);
        }
        String imagen;
        String imagenUs;
        if (listaAnuncios.get(position).getImagen().equals("")){
            imagen = "http://reofertas.esy.es/assets/images/default.jpg";
        }else {
            imagen = "http://reofertas.esy.es/uploads/anuncios/"+listaAnuncios.get(position).getImagen();
        }
        String FototUS= listaAnuncios.get(position).getUsuario().getFoto();
        if (FototUS.equals("")){
            FototUS = "http://reofertas.esy.es/assets/images/default-user.png";
        }else {
            FototUS = "http://reofertas.esy.es/uploads/usuarios/"+FototUS;
        }

        Picasso.get().load(imagen).into(viewHolder.imagen);
        viewHolder.imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, anuncio_ver.class);
                intent.putExtra("AN", listaAnuncios.get(pos).getId());
                context.startActivity(intent);
            }
        });
        Picasso.get().load(FototUS).into(viewHolder.FotoUs);


        viewHolder.precio.setText(listaAnuncios.get(position).getPrecio()+"€");


        return convertView;
    }

    private static class ViewHolder {
        TextView ciudad;
        TextView hora;
        TextView titulo;
        ImageView imagen;
        TextView desc;
        TextView precio;
        TextView Usuario;
        TextView Verificado;
        ImageView FotoUs;
        CheckBox Seleccion;

    }
    public static String leerValor(Context context, String keyPref) {
        SharedPreferences preferences = context.getSharedPreferences(PREFS_KEY, MODE_PRIVATE);
        return  preferences.getString(keyPref, "");
    }
    public static void guardarValor(Context context, String keyPref, String valor) {
        SharedPreferences settings = context.getSharedPreferences(PREFS_KEY, MODE_PRIVATE);
        SharedPreferences.Editor editor;
        editor = settings.edit();
        editor.putString(keyPref, valor);
        editor.commit();

    }
    public static void borraValor(Context context,String valor) {
        SharedPreferences settings = context.getSharedPreferences(PREFS_KEY, MODE_PRIVATE);
        settings.edit().remove(valor).commit();
    }

}
