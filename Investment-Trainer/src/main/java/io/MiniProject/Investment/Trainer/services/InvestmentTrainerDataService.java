package io.MiniProject.Investment.Trainer.services;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class InvestmentTrainerDataService {

    public static String STOCK_DATA_URL = "https://raw.githubusercontent.com/nikhilrana884/StocksData/master/StocksData.csv";

    @PostConstruct
    public void fetchStockData() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(STOCK_DATA_URL))
                .build();
        HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(httpResponse.body());
    }

}
