package es.esy.reofertas.re_ofertas;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class anuncio_ver extends AppCompatActivity {
    private static String PREFS_KEY = "mispreferencias";
    public  static String Id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anuncio_ver);
        Intent intent = getIntent();



        ver_anuncio anuncio = new ver_anuncio(intent.getStringExtra("AN"),this);
        anuncio.execute();

        CheckBox checkBox =  findViewById(R.id.seleciona);


        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                Log.d("Chceck",String.valueOf(isChecked));
                Log.d("ID",Id);
                if (isChecked){
                    guardarValor(anuncio_ver.this,"ID"+Id,Id);                }
                else {
                    borraValor(anuncio_ver.this,"ID"+Id);
                }
                Log.d("Buscar", "Existe : "+leerValor(anuncio_ver.this,"ID"+Id) );
            }
        });


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

    public static String leerValor(Context context, String keyPref) {
        SharedPreferences preferences = context.getSharedPreferences(PREFS_KEY, MODE_PRIVATE);
        return  preferences.getString(keyPref, "");
    }

    class ver_anuncio extends AsyncTask<String, Void, String> {
        conexion con;
        String id;
        ViewPager viewPager;
        Activity activity;


        public ver_anuncio(String id,Activity activity){
            con= new conexion();
            this.id=id;
            this.activity=activity;
//        Log.d("URL","http://reofertas.esy.es/php/peticiones/anuncios.php?tipo=busqueda&palabras="+pal+"&categorias="+cat+"&ciudades="+cit);
        }

        @Override
        protected String doInBackground(String... strings) {
            String url_anuncio="/php/peticiones/un_anuncio.php?Id="+id;
            String datos = con.DoGet(url_anuncio);
            CargarDatos.index++;
            return datos;
        }

        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        protected void onPostExecute(String res) {
            super.onPostExecute(res);

            try {
                Log.d("RES VERMAS",res);
                    JSONObject parserJSON = new JSONObject(res);

                    Anuncio anuncio = new Anuncio();
                    anuncio.setId(parserJSON.getString("Id"));
                    anuncio.setTitulo(parserJSON.getString("Nombre"));
                    anuncio.setDescripcion(parserJSON.getString("Descripcion"));
                    anuncio.setExtra(parserJSON.getString("Extra"));
                    anuncio.setCiudad(parserJSON.getString("ciudad"));
                    anuncio.setPoblacion(parserJSON.getString("Poblacion"));
                    anuncio.setPrecio(parserJSON.getString("Precio"));
                    anuncio.setFecha(parserJSON.getString("Fecha_modificacion"));
                    anuncio.setImagens(parserJSON.getJSONArray("Fotos"));
                    anuncio.setComentarios(parserJSON.getJSONArray("comentarios"));
                    anuncio.setValoracion(parserJSON.getString("valoracion"));
                    Usuario usuario= new Usuario();
                    usuario.setEmail(parserJSON.getString("Email"));
                    usuario.setNobre(parserJSON.getString("NombreUs"));
                    usuario.setTelefono1(parserJSON.getString("Telf"));
                    usuario.setTelefono2(parserJSON.getString("Telf2"));
                    usuario.setFoto(parserJSON.getString("fotoUs"));
//                    usuario.setVerificado((!parserJSON.getString("verf").equals("NO")?true:false));
                    anuncio.setUsuario(usuario);
                anuncio_ver.Id=anuncio.getId();
                ((TextView) activity.findViewById(R.id.tit)).setText(anuncio.getTitulo());
                ((TextView) activity.findViewById(R.id.desc)).setText(anuncio.getDescripcion());
                ((TextView) activity.findViewById(R.id.extra)).setText((anuncio.getExtra().equals("")?"No tiene datos extra":anuncio.getExtra()));
                float val=0;
                if (!anuncio.getValoracion().equals("null")){
                    val = Float.valueOf(anuncio.getValoracion());
                    val = Math.round(val);
                }

                ((TextView) activity.findViewById(R.id.valoracion)).setText((anuncio.getValoracion().equals("null")?"No tiene Valoraciones":String.valueOf(val)+"/5"));
                ((TextView) activity.findViewById(R.id.fecha)).setText(anuncio.getFecha());
                ((TextView) activity.findViewById(R.id.precio)).setText(anuncio.getPrecio()+"€");
                ((TextView) activity.findViewById(R.id.nombreUs)).setText(anuncio.getUsuario().getNobre());
                ((TextView) activity.findViewById(R.id.telf1)).setText(anuncio.getUsuario().getTelefono1());
                ((TextView) activity.findViewById(R.id.telf2)).setText((anuncio.getUsuario().getTelefono2().equals("")?"No tiene otro teléfono":""));
                ((TextView) activity.findViewById(R.id.emailUs)).setText(anuncio.getUsuario().getEmail());

                if (anuncio.getComentarios().length() > 0){

                    for (int i=0;anuncio.comentarios.length()>i;i++){
                        TextView tv = new TextView(activity);
                        tv.setPadding(0,20,0,0);
                        tv.setTextColor(Color.BLACK);
                        TextView tv2 = new TextView(activity);
//                        tv2.setTextColor(Color.argb());
                        tv2.setPadding(0,10,0,0);

                        JSONObject commm = anuncio.comentarios.getJSONObject(i);
                        tv.setText(commm.get("Fecha")+" "+commm.getString("Email"));
                        tv2.setText(commm.getString("Descripcion"));
                        tv2.setTextSize(18);

                        ((LinearLayout) activity.findViewById(R.id.comments)).addView(tv);
                        ((LinearLayout) activity.findViewById(R.id.comments)).addView(tv2);
                    }


                }else {
                    TextView tv = new TextView(activity);
                    tv.setPadding(0,20,0,0);
                    tv.setTextColor(Color.BLACK);
                    tv.setText("No se han encontrado commentarios para este anuncio.");
                    ((LinearLayout) activity.findViewById(R.id.comments)).addView(tv);

                }



                viewPager = (ViewPager) findViewById(R.id.viewPager);


                String[] arr=new String[anuncio.imagens.length()];

                for(int i = 0; i < anuncio.imagens.length(); i++){
                    arr[i]=anuncio.imagens.getString(i);
                }

                ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(activity,arr);

                viewPager.setAdapter(viewPagerAdapter);
                boolean seleccionado = !leerValor(activity,"ID"+anuncio.getId()).equals("");
                CheckBox checkBox =  activity.findViewById(R.id.seleciona);
                if (seleccionado){
                    checkBox.setChecked(true);
                }

//                ((TextView)findViewById(R.id.ID)).setText(anuncio.toString());


            } catch (Exception e) {
                e.printStackTrace();
                Log.d("RES","¡¡¡Exceptión!!!");
            }
        }


    }
}
