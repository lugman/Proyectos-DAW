package es.esy.reofertas.re_ofertas;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public  class Traer {
    Activity act;
    static ArrayList<String> CiudadesId;
    static ArrayList<String> CategoriasId;

    public Traer(Activity act) {
        this.act = act;
        CiudadesId = new ArrayList<>();
        CategoriasId = new ArrayList<>();
    }

    public  void categorias(){
        cargar_categorias cargarAnuncios =  new cargar_categorias(act);
        cargarAnuncios.execute();
    }
    public  void ciudades(){
        cargar_ciudades cargarCiudades =  new cargar_ciudades(act);
        cargarCiudades.execute();
    }
}
 class cargar_categorias extends AsyncTask<String, Void, String> {
    conexion con;
    Activity activity;
    CargarDatos cargar;
    String Datos;

    public cargar_categorias(Activity context){
        activity=context;
        con= new conexion();
    }

    @Override
    protected String doInBackground(String... strings) {
        Datos = con.DoGet("/php/peticiones/funciones.php?funcion=categorias");
        return Datos;
    }

     @Override
     protected void onPostExecute(String res) {
         super.onPostExecute(res);
         try {
             ArrayList<String> listCategorias = new ArrayList<>();
             ArrayList<String> listCategoriasId = new ArrayList<>();

             listCategorias.add("Todas las categorías");
             listCategoriasId.add("NO");

             JSONArray parser = new JSONArray(res);
             for (int i = 0; i < parser.length(); i++) {
                 JSONObject Item = parser.getJSONObject(i);
                 listCategorias.add(Item.getString("Nombre"));
                 listCategoriasId.add(Item.getString("Id"));

                 Log.d("Element",Item.toString());

             }

             Traer.CategoriasId = listCategoriasId;

             ArrayAdapter<String> adapter = new ArrayAdapter<String>(activity, R.layout.spinner_item, listCategorias);
             Spinner spinner = activity.findViewById(R.id.categorias);

             spinner.setAdapter(adapter);


         } catch (Exception e) {
             e.printStackTrace();
         }


//        Log.d("RES",Datos);
     }


}
class cargar_ciudades extends AsyncTask<String, Void, String> {
    conexion con;
    Activity activity;
    CargarDatos cargar;
    String Datos;

    public cargar_ciudades(Activity context){
        activity=context;
        con= new conexion();
    }

    @Override
    protected String doInBackground(String... strings) {
        Datos = con.DoGet("/php/peticiones/funciones.php?funcion=ciudades");
        return Datos;

    }

    @Override
    protected void onPostExecute(String res) {
        super.onPostExecute(res);
        try {
            ArrayList<String> listCiudades = new ArrayList<>();
            ArrayList<String> listCiudadesId = new ArrayList<>();

            listCiudades.add("Todas las ciudades");
            listCiudadesId.add("");

            JSONArray parser = new JSONArray(res);
            for (int i = 0; i < parser.length(); i++) {
                JSONObject Item = parser.getJSONObject(i);
                listCiudades.add(Item.getString("Nombre"));
                listCiudadesId.add(Item.getString("Id"));

                Log.d("Element",Item.toString());

            }
            Traer.CiudadesId = listCiudadesId;
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(activity, R.layout.spinner_item, listCiudades);
            Spinner spinner = activity.findViewById(R.id.ciudades);

            spinner.setAdapter(adapter);


        } catch (Exception e) {
            e.printStackTrace();
        }


//        Log.d("RES",Datos);
    }


}