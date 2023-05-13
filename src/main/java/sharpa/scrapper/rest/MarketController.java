package sharpa.scrapper.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sharpa.scrapper.business.MarketManager;
import sharpa.scrapper.view.MarketRequest;
import sharpa.scrapper.view.MarketResponse;

@RestController
@RequestMapping("api")
public class MarketController {


    @Autowired
    @Qualifier("marketService")
    private MarketManager marketManager;

    @RequestMapping(value = "/prices", method = RequestMethod.POST, consumes="application/json", produces = "application/json")
    public MarketResponse showMarketPrice(@RequestBody MarketRequest marketRequest) {

        System.out.println("showMarketPrice..");
        return marketManager.showPrice(marketRequest.getGoodName());

    }

}
