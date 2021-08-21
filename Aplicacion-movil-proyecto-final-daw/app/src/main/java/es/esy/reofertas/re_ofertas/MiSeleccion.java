package es.esy.reofertas.re_ofertas;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;

public class MiSeleccion extends AppCompatActivity {
    private static String PREFS_KEY = "mispreferencias";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_seleccion);

        RotateAnimation rotate = new RotateAnimation(0, 180,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);


        rotate.setDuration(1500);
        rotate.setRepeatCount(Animation.INFINITE);

        ImageView image= (ImageView) findViewById(R.id.loader);

        image.startAnimation(rotate);


        String ides =leerValor(this);

        Log.d("IDES MI ",2+ides+2);
        if (!ides.equals("")){
            traer_anuncios_mios trae_mios = new traer_anuncios_mios(this,ides);
            trae_mios.execute();

        }else {

            rotate.cancel();
            image.setVisibility(View.INVISIBLE);
            ((TextView)findViewById(R.id.noFound)).setVisibility(View.VISIBLE);

        }
        Button buton = findViewById(R.id.limpiar);
        buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPrefs = MiSeleccion.this.getSharedPreferences(PREFS_KEY, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPrefs.edit();
                editor.clear();
                editor.commit();
                ((TextView)findViewById(R.id.noFound)).setVisibility(View.VISIBLE);
                ((TextView)findViewById(R.id.noFound)).setText("Lista Vacia");
                ((ListView)findViewById(R.id.listaAnuncios)).setVisibility(View.INVISIBLE);


            }
        });

    }

    public static String leerValor(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(PREFS_KEY, MODE_PRIVATE);

        Map<String,?> todas = preferences.getAll();

        String Ids = "";
        int count=0;

        for(Map.Entry<String,?> entry : todas.entrySet()){
            Log.d("map values",entry.getKey() + ": " +
                    entry.getValue().toString());
            if (count==0){
                Ids+=entry.getValue().toString();
            }else {
                Ids+=","+entry.getValue().toString();
            }
            count++;
        }
        return Ids;
    }


    class traer_anuncios_mios extends AsyncTask<String, Void, String[]> {
        conexion con;
        Activity activity;
        CargarDatos cargar;
        String Datos;

        String IDS;
        int tipo;

        public traer_anuncios_mios(Activity context,String IDS){
            activity=context;
            con= new conexion();
            this.IDS=IDS;
            Log.d("IDS",IDS);
        }


        @Override
        protected String[] doInBackground(String... strings) {
            String mios_url="/php/peticiones/anuncios.php?favs="+IDS+"&order=Fecha_modificacion&tipo=favoritos";

            Datos = con.DoGet(mios_url);



            return new String[]{Datos};
        }

        @Override
        protected void onPostExecute(String[] res) {
            super.onPostExecute(res);

            try {
                JSONArray parser = new JSONArray(res[0]);




//            Log.d("RES Parse", vermas);

                ArrayList<Anuncio> listaAnuncios = new ArrayList<Anuncio>();
                RotateAnimation animation = (RotateAnimation) ((ImageView) activity.findViewById(R.id.loader)).getAnimation();
                animation.cancel();
                ((ImageView) activity.findViewById(R.id.loader)).setVisibility(View.GONE);
                ((ImageView) activity.findViewById(R.id.loader)).setVisibility(View.INVISIBLE);


                if (parser.length() > 0) {
                    for (int i = 0; i < parser.length(); i++) {
                        JSONObject Item = parser.getJSONObject(i);
                        Anuncio anuncio = new Anuncio();
                        anuncio.setId(Item.getString("Id"));
                        anuncio.setTitulo(Item.getString("Nombre"));
                        anuncio.setDescripcion(Item.getString("Descripcion"));
                        anuncio.setCiudad(Item.getString("ciudad"));
                        anuncio.setPoblacion(Item.getString("Poblacion"));
                        anuncio.setPrecio(Item.getString("Precio"));
                        anuncio.setFecha(Item.getString("Fecha_modificacion"));
                        anuncio.setImagen(Item.getString("foto"));
                        Usuario usuario= new Usuario();
                        usuario.setNobre(Item.getString("NombreUs"));
                        usuario.setFoto(Item.getString("fotoUs"));
                        usuario.setVerificado((!Item.getString("verf").equals("NO")?true:false));
                        anuncio.setUsuario(usuario);
                        listaAnuncios.add(anuncio);

                    }
                    CargarDatos.anuncios=listaAnuncios;
                    CargarDatos.adaptador = new MiAdaptador(CargarDatos.anuncios,activity);
                    ((ListView)activity.findViewById(R.id.listaAnuncios)).setAdapter((ListAdapter) CargarDatos.adaptador);

                }else {
                    ((TextView)activity.findViewById(R.id.noFound)).setVisibility(View.VISIBLE);
                }



            } catch (Exception e) {
                e.printStackTrace();
                Log.d("RES","¡¡¡Exceptión!!!");
            }


        }


    }
}
