package io.MiniProject.Investment.Trainer.services;

import io.MiniProject.Investment.Trainer.models.StocksStats;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class InvestmentTrainerDataService {

    public static String STOCK_DATA_URL = "https://raw.githubusercontent.com/nikhilrana884/StocksData/master/StocksData.csv";

    public List<StocksStats> getCompanyStats() {
        return CompanyStats;
    }

    private List<StocksStats> CompanyStats = new ArrayList<>();

    @PostConstruct
    @Scheduled(cron = "* * * * * *")
    public void fetchStockData() throws IOException, InterruptedException {

        List<StocksStats> TempStats = new ArrayList<>();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(STOCK_DATA_URL))
                .build();

        HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
        //System.out.println(httpResponse.body());

        StringReader csvBodyReader = new StringReader((httpResponse.body()));
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvBodyReader);

        for (CSVRecord record : records) {
            StocksStats CompanyStat = new StocksStats();

            CompanyStat.setCompany(record.get("Company"));
            CompanyStat.setLast_Traded_Price(record.get("LTP"));
            CompanyStat.setLast_Buy_Price(record.get("Buy Price"));
            CompanyStat.setLast_Sell_Price(record.get("Sell Price"));

          //  System.out.println(CompanyStat);
            TempStats.add(CompanyStat);

            // String  Volume = record.get("Volume");
            // System.out.println(Volume);

            // String Percent_Change = record.get("%Change");
            // System.out.println(Percent_Change);



       }
        this.CompanyStats = TempStats;
    }

}
