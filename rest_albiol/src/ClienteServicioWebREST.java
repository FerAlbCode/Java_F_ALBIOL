import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;

public class ClienteServicioWebREST {
    public static void main(String[] args) {

        final String URL_API="https://pokeapi.co/api/v2/pokemon-form/pikachu/";

        try {

            // Inicio de la conexión:
            URL url = new URL(URL_API);
            URLConnection conexion = url.openConnection();

            //Lectura del contenido de la respuesta:
            Reader r = new InputStreamReader(conexion.getInputStream());
            BufferedReader br = new BufferedReader(r);

            String linea;

            while ((linea = br.readLine()) != null){
                System.out.println(linea);
            }

        } catch (Exception e){
            System.err.println("Error de I/O: " + e.getMessage());
        }

    }
}
