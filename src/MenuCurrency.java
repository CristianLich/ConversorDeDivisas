import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class MenuCurrency {

    public void Menu(){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/ad4df9f789a737d305d7e55d/codes");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();


        HttpResponse<String> response;

        {
            try {
                response = client.send(request, HttpResponse.BodyHandlers.ofString());

                // Obtener el contenido de la respuesta
                String responseBody = response.body();

                // Parsear el JSON
                Gson gson = new Gson();
                JsonObject jsonObject = gson.fromJson(responseBody, JsonObject.class);

                // Obtener el objeto conversion_rates
                JsonArray supportedCodes = jsonObject.getAsJsonArray("supported_codes");

                // Crear un HashMap para almacenar los pares de código de moneda y nombre asociado
                Map<String, String> currencyMap = new HashMap<>();

                // Iterar sobre las entradas del arreglo y agregarlas al mapa
                for (int i = 0; i < supportedCodes.size(); i++) {
                    JsonArray currencyInfo = supportedCodes.get(i).getAsJsonArray();
                    String currencyCode = currencyInfo.get(0).getAsString();
                    String currencyName = currencyInfo.get(1).getAsString();
                    currencyMap.put(currencyCode, currencyName);
                }
                // Imprimir los pares de código de moneda y nombre asociado en tres columnas
                int count = 0;
                for (Map.Entry<String, String> entry : currencyMap.entrySet()) {
                    if (count % 3 == 0) {
                        System.out.println();
                    }
                    System.out.printf("%-4s : %-40s\t\t", entry.getKey(), entry.getValue());
                    count++;
                }


            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }



}
