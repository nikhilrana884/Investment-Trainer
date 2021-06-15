package io.MiniProject.Investment.Trainer.services;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.StringReader;
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

        StringReader csvBodyReader = new StringReader((httpResponse.body()));
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvBodyReader);

        for (CSVRecord record : records) {

            String  Company = record.get("Company");
            System.out.println(Company);

            String Last_Traded_Price = record.get("LTP");
            System.out.println(Last_Traded_Price);

            String Last_Buy_Price = record.get("Buy Price");
            System.out.println(Last_Buy_Price);

            String Last_Sell_Price = record.get("Sell Price");
            System.out.println(Last_Sell_Price);

            // String  Volume = record.get("Volume");
            // System.out.println(Volume);

            // String Percent_Change = record.get("%Change");
            // System.out.println(Percent_Change);



       }
    }

}
