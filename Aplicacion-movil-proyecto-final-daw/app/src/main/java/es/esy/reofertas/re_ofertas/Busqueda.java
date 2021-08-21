package es.esy.reofertas.re_ofertas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Busqueda extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.busqueda);
        CargarDatos  cargarDatos = new CargarDatos(this);


        Intent intent = getIntent();
        String Tipo = intent.getStringExtra("Tipo");
        if (Tipo.equals("BUSQUEDA")){
            String ciudad = intent.getStringExtra("CIT");
            String categoria = intent.getStringExtra("CAT");
            String palabras = intent.getStringExtra("PAL");

            cargarDatos.anuncios1(categoria,ciudad,palabras);

        }else if(Tipo.equals("CATEGORIA")){

            String categoria = intent.getStringExtra("CAT");
            cargarDatos.anuncios2(categoria);


        }


        RotateAnimation rotate = new RotateAnimation(0, 180,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);

        rotate.setDuration(1500);
        rotate.setRepeatCount(Animation.INFINITE);

        ImageView image= (ImageView) findViewById(R.id.loader);

        image.startAnimation(rotate);








    }
}
