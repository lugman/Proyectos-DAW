package es.esy.reofertas.re_ofertas;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    View layoutCargar;
    ArrayList<Anuncio> anuncios;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setLogo(R.drawable.logomovil);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        setContentView(R.layout.principal);

        final Traer traer = new Traer(this);
        traer.categorias();
        traer.ciudades();

        final Spinner ciudadesView = findViewById(R.id.ciudades);
        final Spinner categoriasView = findViewById(R.id.categorias);
        final EditText palabrasView = findViewById(R.id.palabras);
        Button buscarBtn = findViewById(R.id.buscarBtn);
        Button miSeleccion = findViewById(R.id.miSeleccion);

        buscarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ciudad =    traer.CiudadesId.get(ciudadesView.getSelectedItemPosition());
                String categoria = traer.CategoriasId.get(categoriasView.getSelectedItemPosition());
                String palabras = palabrasView.getText().toString();

                Intent intent = new Intent(MainActivity.this, Busqueda.class);

                intent.putExtra("Tipo", "BUSQUEDA");
                intent.putExtra("CIT", ciudad);
                intent.putExtra("CAT", categoria);
                intent.putExtra("PAL", palabras);
                startActivity(intent);

            }
        });
        miSeleccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, MiSeleccion.class);
                startActivity(intent);

            }
        });

        View.OnClickListener catClick =new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Busqueda.class);
                Log.d("RES Parse", "CLICK");
                Log.d("RES Parse", String.valueOf(v.getId()));


                intent.putExtra("Tipo", "CATEGORIA");


                switch (v.getId()){
                    case R.id.cat_2:
                        intent.putExtra("CAT", "2");
                        startActivity(intent);
                        break;
                    case R.id.cat_4:
                        intent.putExtra("CAT", "4");
                        startActivity(intent);
                        break;
                    case R.id.cat_5:
                        intent.putExtra("CAT", "5");
                        startActivity(intent);
                        break;
                    case R.id.cat_6:
                        intent.putExtra("CAT", "5");
                        startActivity(intent);
                        break;
                    case R.id.cat_7:
                        intent.putExtra("CAT", "7");
                        startActivity(intent);
                        break;
                    case R.id.cat_11:
                        intent.putExtra("CAT", "11");
                        startActivity(intent);
                        break;
                    case R.id.cat_12:
                        intent.putExtra("CAT", "12");
                        startActivity(intent);
                        break;
                    case R.id.cat_14:
                        intent.putExtra("CAT", "14");
                        startActivity(intent);
                        break;
                    case R.id.cat_148:
                        intent.putExtra("CAT", "148");
                        startActivity(intent);
                        break;

                }

            }
        };
        (findViewById(R.id.cat_2)).setOnClickListener(catClick);
        (findViewById(R.id.cat_4)).setOnClickListener(catClick);
        (findViewById(R.id.cat_5)).setOnClickListener(catClick);
        (findViewById(R.id.cat_6)).setOnClickListener(catClick);
        (findViewById(R.id.cat_7)).setOnClickListener(catClick);
        (findViewById(R.id.cat_11)).setOnClickListener(catClick);
        (findViewById(R.id.cat_12)).setOnClickListener(catClick);
        (findViewById(R.id.cat_14)).setOnClickListener(catClick);
        (findViewById(R.id.cat_148)).setOnClickListener(catClick);
//        (findViewById(R.id.cat_2)).setOnClickListener(catClick);




    }




}

//  ciudades.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//@Override
//public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
//        Log.d("ACCION", String.valueOf(traer.CiudadesId.get((int) id)));
//        }
//
//@Override
//public void onNothingSelected(AdapterView<?> parentView) {
//        Log.d("ACCION","No");
//
//        }
//
//        });