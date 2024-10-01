import com.google.gson.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ConversorDeMonedas {
    public void buscador(String monedaBase, String monedaFinal, double monto ) throws IOException {
        List<Formato> formato = new ArrayList<>();
        String valor = (Double.toString(monto));
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        String apiKey = "ad6f2c0c973ff23574ba6d1e";
        String direccion = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/"
                + monedaBase + "/"
                + monedaFinal + "/"
                + monto;
        try {
            URL url = new URL(direccion);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();
            InputStreamReader reader = new InputStreamReader((InputStream) request.getContent());
            JsonElement root = JsonParser.parseReader(reader);
            JsonObject jsonobj = root.getAsJsonObject();
            String req_result = gson.toJson(jsonobj);
            Intercambio intercambio = gson.fromJson(req_result, Intercambio.class);
            Formato format = new Formato(intercambio);
            formato.add(format);
            System.out.println(formato);
            FileWriter escritura = new FileWriter(monedaBase+" a "+monedaFinal+" de "+valor+".json");
            escritura.write(req_result);
            escritura.close();
        } catch (NumberFormatException e) {
            System.out.println("Ocurrió un error: ");
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error en la URI, verifique la dirección");
            System.out.println(e.getMessage());
        }
    }
}
