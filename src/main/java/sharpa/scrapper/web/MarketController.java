package sharpa.scrapper.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import sharpa.scrapper.business.MarketManager;
import sharpa.scrapper.view.MarketRequest;
import sharpa.scrapper.view.MarketResponse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Service("controller")
@Path("/crystalprice")
public class MarketController {

    private static final Logger logger = LoggerFactory.getLogger(MarketController.class);

    @Autowired
    @Qualifier("marketService")
    private MarketManager marketManager;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public MarketResponse showMarketPrice(MarketRequest marketRequest) {

        logger.info("showMarketPrice.. ");

//        return marketManager.showPrice(marketRequest.get);

        return null;
    }



}
