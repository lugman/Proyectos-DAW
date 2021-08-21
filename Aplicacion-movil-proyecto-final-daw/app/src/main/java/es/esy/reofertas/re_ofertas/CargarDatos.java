package es.esy.reofertas.re_ofertas;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class CargarDatos {
    Activity parent;
    static Activity parentS;
    View layoutCargar;
    ListView listView;
    static ArrayList<Anuncio> anuncios;
    static ArrayList<String> vermas;
    static int index= 0;
    static Adapter adaptador;

    CargarDatos(Activity parent){
        this.parent=parent;
        this.parentS=parent;
    }

    public void anuncios1(String cat,String cit,String pal){
        Log.d("CAT",cat);
        Log.d("CIT",cit);
        Log.d("PAL",pal);
        traer_anuncios anuncios= new traer_anuncios(parent,cat,cit,pal,1);
        anuncios.execute();
    }
    public void anuncios2(String cat){
        Log.d("CAT",cat);
        traer_anuncios anuncios= new traer_anuncios(parent,cat,"","",2);
        anuncios.execute();
    }


    public static void vermas() {
        vermas_anuncios verM= new vermas_anuncios();
        verM.execute();
    }
}
class traer_anuncios extends AsyncTask<String, Void, String[]> {
    conexion con;
    Activity activity;
    CargarDatos cargar;
    String Datos;
    String verMas;
    String cat,cit,pal;
    int tipo;

    public traer_anuncios(Activity context,String cat,String cit,String pal,int tipo){
        activity=context;
        con= new conexion();

        this.cat=cat;
        this.cit=cit;
        this.pal=pal;
        this.tipo=tipo;
//        Log.d("URL","http://reofertas.esy.es/php/peticiones/anuncios.php?tipo=busqueda&palabras="+pal+"&categorias="+cat+"&ciudades="+cit);
    }

    @Override
    protected String[] doInBackground(String... strings) {
        verMas="";
        if (tipo==1){
            Datos = con.DoGet("/php/peticiones/anuncios.php?tipo=busqueda&palabras="+pal+"&categorias="+cat+"&ciudades="+cit);

            String vermas="/php/peticiones/anuncios.php?" +
                    "max=1000000&min=1&ordenar=Fecha_modificacion&categoria="+(cat.equals("NO")?"":cat)+
                    "&caracteristicas=&ciudad="+cit+"&poblacion=&fecha1=&fecha2=" +
                    "&palabras="+pal+"&tipo=vermas1";

            verMas = con.DoGet(vermas);

        }else if(tipo==2){

            Datos = con.DoGet("/php/peticiones/anuncios.php?tipo=busqueda_cat&categorias="+cat);
            String vermas="/php/peticiones/anuncios.php?" +
                    "max=1000000&min=1&ordenar=Fecha_modificacion&categoria="+cat+
                    "&caracteristicas=&ciudad=&poblacion=&fecha1=&fecha2=" +
                    "&palabras=&tipo=vermas1";
            verMas = con.DoGet(vermas);

        }
//        Datos ="php/peticiones/anuncios.php?tipo=busqueda&palabras="+pal+"&categorias="+cat+"&ciudades="+cit;
        return new String[]{Datos,verMas};

    }

    @Override
    protected void onPostExecute(String[] res) {
        super.onPostExecute(res);


        try {
            JSONArray parser = new JSONArray(res[0]);
            JSONArray vermas = new JSONArray(res[1]);

            Log.d("RES O: ",res[0]);
            Log.d("RES 1: ",res[1]);

            ArrayList<String> listaMAs= new ArrayList<>();
            for (int i =1;i < vermas.length();i++){
                String itemMAS = "";
                for (int i2 =0;i2 < ((JSONArray)vermas.get(i)).length();i2++){
                    if (i2==0){
                        itemMAS+=((JSONArray)vermas.get(i)).get(i2).toString();
                    }else {
                        itemMAS+=","+((JSONArray)vermas.get(i)).get(i2).toString();
                    }
                    Log.d("item",((JSONArray)vermas.get(i)).get(i2).toString());

                }
                Log.d("item S",itemMAS);
                listaMAs.add(itemMAS);
            }
            CargarDatos.index=0;
            CargarDatos.vermas=listaMAs;




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
                View footerView = ((LayoutInflater) activity.getSystemService(activity.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.more, null, false);
                ((ListView)activity.findViewById(R.id.listaAnuncios)).addFooterView(footerView);

                footerView.findViewById(R.id.verm).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        CargarDatos.vermas();
                    }
                });
                if (listaMAs.size()==0){
                    footerView.setVisibility(View.GONE);
                }
            }else {
                ((TextView)activity.findViewById(R.id.noFound)).setVisibility(View.VISIBLE);
            }



        } catch (Exception e) {
            e.printStackTrace();
            Log.d("RES","¡¡¡Exceptión!!!");
        }


    }


}
class vermas_anuncios extends AsyncTask<String, Void, String> {
    conexion con;
    Activity activity;
    CargarDatos cargar;
    String Datos;
    String verMas;
    String cat,cit,pal;
    int tipo;

    public vermas_anuncios( ){
        activity=CargarDatos.parentS;
        con= new conexion();

//        Log.d("URL","http://reofertas.esy.es/php/peticiones/anuncios.php?tipo=busqueda&palabras="+pal+"&categorias="+cat+"&ciudades="+cit);
    }

    @Override
    protected String doInBackground(String... strings) {
        verMas="";


        String ides = CargarDatos.vermas.get(CargarDatos.index);
        String vermas="ides="+ides+"&tipo=vermas2&ordenar=Fecha_modificacion";
        Datos = con.DoGet("/php/peticiones/anuncios.php?"+vermas);
        CargarDatos.index++;




//        Datos ="php/peticiones/anuncios.php?tipo=busqueda&palabras="+pal+"&categorias="+cat+"&ciudades="+cit;
        return Datos;

    }

    @Override
    protected void onPostExecute(String res) {
        super.onPostExecute(res);

        try {
            Log.d("RES VERMAS",res);
            JSONArray parser = new JSONArray(res);
//            JSONArray vermas = new JSONArray(res[1]);

            if (CargarDatos.vermas.size()<=CargarDatos.index){
                ((Button) activity.findViewById(R.id.verm)).setVisibility(View.GONE);
            }



//            Log.d("RES Parse", vermas);

            ArrayList<Anuncio> listaAnuncios = new ArrayList<Anuncio>();

//            RotateAnimation animation = (RotateAnimation) ((ImageView) activity.findViewById(R.id.loader)).getAnimation();
//            animation.cancel();
//            ((ImageView) activity.findViewById(R.id.loader)).setVisibility(View.GONE);
//            ((ImageView) activity.findViewById(R.id.loader)).setVisibility(View.INVISIBLE);

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
                    CargarDatos.anuncios.add(anuncio);
//                    listaAnuncios.add(anuncio);

                }
            CargarDatos.adaptador.notify();


        } catch (Exception e) {
            e.printStackTrace();
            Log.d("RES","¡¡¡Exceptión!!!");
        }


    }


}