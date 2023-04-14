package sharpa.scrapper.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sharpa.scrapper.business.MarketManager;
import sharpa.scrapper.view.MarketRequest;
import sharpa.scrapper.view.MarketResponse;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//@Service("controller")
//@Path("/in")
//@RequestMapping("/rest/userAccount")
//@Path("/price")
//@Component
@Service("controller")
@Path("/in")
public class MarketController {

    private static final Logger logger = LoggerFactory.getLogger(MarketController.class);

    @Autowired
    @Qualifier("marketService")
    private MarketManager marketManager;

//    @Path("/price")
//    @Consumes(MediaType.APPLICATION_JSON)

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public MarketResponse showMarketPrice(MarketRequest marketRequest) {

        logger.info("showMarketPrice.. ");

        return marketManager.showPrice(marketRequest.getGoodName());

    }



}
