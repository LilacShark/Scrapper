package sharpa.scrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import sharpa.scrapper.business.MarketManager;
import sharpa.scrapper.model.Goods;
import sharpa.scrapper.view.MarketGetServiceResponse;
import sharpa.scrapper.web.GetService;

import java.time.LocalDateTime;
import java.util.List;

public class Refresher {

    @Autowired
    GetService getService;
    @Autowired
    @Qualifier("marketService")
    MarketManager marketManager;

    public void refreshMarketData() {

        System.out.println("refreshMarketData.. ");


         List<Goods> goodsList = marketManager.getAllGoods();

         for (Goods g : goodsList) {

             MarketGetServiceResponse priceForGood = getService.getPriceForGood(g);

             Double doublePrice = Double.valueOf(priceForGood.
                     getLowest_price().
                     substring(0,priceForGood.getLowest_price().length()-5).
                     replace(",",".")
                    );

             System.out.println("Time: " + LocalDateTime.now() +
                     "   Old price: " + marketManager.getPrice(g) +
                     "   New price: " + doublePrice);

             marketManager.saveNewPrice(g, doublePrice);


         }
    }


    public Refresher() {
        System.out.println("Refreshing.. ");

    }


    public GetService getInfoService() {
        return getService;
    }

    public void setInfoService(GetService getService) {
        this.getService = getService;
    }


}
