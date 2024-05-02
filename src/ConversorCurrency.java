import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorCurrency {

    public Moneda ConvertirMonedas(String moneda1 , String moneda2, Double monto) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/ad4df9f789a737d305d7e55d/pair/" + moneda1 + "/" + moneda2 + "/" + monto);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();


        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (Exception e) {
            throw new RuntimeException("Algo salio re mal");
        }
    }
}
