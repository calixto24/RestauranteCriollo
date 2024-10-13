package utp.restaurant.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.cdimascio.dotenv.Dotenv;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import utp.restaurant.service.model.ReniecCustomer;
import utp.restaurant.service.model.SunatCustomer;

public class CustomerService {
    private static HttpClient client;
    private static HttpRequest request;
    private static String token;
    private static final String URL = "https://api.apis.net.pe/v2/";
    
    public static ReniecCustomer getCustomer(int dni) throws Exception {
        System.out.println("peticion");
        token = getToken();
        
        client = HttpClient.newHttpClient();
        
        request = HttpRequest.newBuilder()
                .uri(URI.create(URL + "/reniec/dni?numero=" + dni))
                .header("accept", "application/json")
                .header("Authorization", "Bearer " + token)
                .GET()
                .build();
        
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        
        ReniecCustomer customer = new ObjectMapper().readValue(response.body(), ReniecCustomer.class);
        
        return customer;
    }
    
    public static SunatCustomer getCustomer(long ruc) throws Exception {
        token = getToken();
        
        client = HttpClient.newHttpClient();
        
        request = HttpRequest.newBuilder()
                .uri(URI.create(URL + "/sunat/ruc/full?numero=" + ruc))
                .header("accept", "application/json")
                .header("Authorization", "Bearer " + token)
                .GET()
                .build();
        
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        
        String body = response.body().replace("EsAgenteRetencion", "esAgenteRetencion");
        
        SunatCustomer customer = new ObjectMapper().readValue(body, SunatCustomer.class);
        
        return customer;
    }
    
    private static String getToken() {
        Dotenv dotenv = Dotenv.load();
        
        return dotenv.get("API_TOKEN");
    }
}
