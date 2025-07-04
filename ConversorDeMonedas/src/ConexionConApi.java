import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConexionConApi {
    //aqui colocas tu APIKEY propia
    private static final String API_KEY = "aqui coloca  tu  apikey";
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/";
    private final HttpClient client;
    private final Gson gson;

    public ConexionConApi(){
        this.client = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    //metodo para obtener el tipo de cambio de la moneda
    public double convertirTipoDeMoneda(String EntradaDeMoneda, String SalidaDeMoneda){
        try {
            URI uri = new URI(API_URL + EntradaDeMoneda +"/" + SalidaDeMoneda);
            HttpRequest request  = HttpRequest.newBuilder()
                    .uri(uri)
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
            ResultadoTipoCambio resultadoTipoCambio = gson.fromJson(response.body(),ResultadoTipoCambio.class);
            return resultadoTipoCambio.getConversion_rate();



        }catch (Exception e){
            e.printStackTrace();
            System.out.println("no hay internet o la API falla");
            return 0;
        }
    }


}
