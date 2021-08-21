package es.esy.reofertas.re_ofertas;

import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class conexion {

    public String DoGet(String dir){
        final String USER_AGENT = "Mozilla/5.0";
        try {
            URL obj = new URL("http://reofertas.esy.es"+dir);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", USER_AGENT);

            BufferedReader in = new BufferedReader( new InputStreamReader(con.getInputStream()));

            // Vamos leyendo por lineas.
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }


            return response.toString();

        }catch (Exception e){
            Log.d("Error conexion: ",e.getMessage());
            return e.getMessage();
        }

    }
}
