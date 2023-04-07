package sharpa.scrapper.web;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import sharpa.scrapper.model.Goods;
import sharpa.scrapper.view.MarketGetServiceResponse;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
@PropertySource(value="classpath:application.properties")
public class GetService {


    @Value("${app.url}")
    private String url;
    @Value("${app.api}")
    private String api;
    @Value("${app.object}")
    private String object;

    public MarketGetServiceResponse getPriceForGood(Goods good) {

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(url + api + good.getAppId() + object + good.getMarketHashName()))
                    .GET()
                    .build();

            HttpResponse<String> response = HttpClient.newBuilder()
                    .build()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println(response.body());

            Gson gson = new GsonBuilder().create();
            MarketGetServiceResponse marketGetServiceResponse = gson.fromJson(response.body(), MarketGetServiceResponse.class);

            System.out.println(marketGetServiceResponse);

            return marketGetServiceResponse;

        } catch (URISyntaxException | IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }

    public MarketGetServiceResponse getCrystal() {

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://steamcommunity.com/market/priceoverview/?appid=753&currency=5&market_hash_name=753-Sack%20of%20Gems"))
                    .GET()
                    .build();

            HttpResponse<String> response = HttpClient.newBuilder()
                    .build()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println(response.body());

            Gson gson = new GsonBuilder().create();
            MarketGetServiceResponse marketGetServiceResponse = gson.fromJson(response.body(), MarketGetServiceResponse.class);

            System.out.println(marketGetServiceResponse);

            return marketGetServiceResponse;

        } catch (URISyntaxException | IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return null;

    }


}
