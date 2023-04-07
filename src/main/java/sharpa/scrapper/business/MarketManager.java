package sharpa.scrapper.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import sharpa.scrapper.dao.GoodsDAO;
import sharpa.scrapper.dao.PricesDAO;
import sharpa.scrapper.model.Goods;
import sharpa.scrapper.model.Prices;
import sharpa.scrapper.view.MarketResponse;

import java.time.LocalDateTime;
import java.util.List;

@Service("marketService")
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class MarketManager {

    private static final Logger logger = LoggerFactory.getLogger(MarketManager.class);

    @Autowired
    GoodsDAO goodsDAO;
    @Autowired
    PricesDAO pricesDAO;

    public MarketResponse showPrice(String name) {

        logger.info("showPrice.. ");

        Goods good = goodsDAO.findByMarketName(name);
        Prices lastPriceForGood = pricesDAO.findTopByGoodOrderByPriceDateDesc(good);

        MarketResponse marketResponse = new MarketResponse(good.getMarketName(),
                lastPriceForGood.getPrice());

        return marketResponse;
    }

    public Double getPrice(Goods g) {

        logger.info("getPrice.. ");

        Goods byGoodId = goodsDAO.findByGoodId(1L);
        Prices lastPriceForGood = pricesDAO.findTopByGoodOrderByPriceDateDesc(byGoodId);

        return lastPriceForGood.getPrice();
    }

    public Prices saveNewPrice(Goods good, Double doublePrice) {

        logger.info("saveNewPrice.. ");

        Prices price = new Prices();
        price.setPrice(doublePrice);
        price.setPriceDate(LocalDateTime.now());
        price.setCurrency(5);
        price.setGood(good);

        return pricesDAO.saveAndFlush(price);
    }

    public List<Goods> getAllGoods() {
        logger.info("getAllGoods.. ");
        return goodsDAO.findAll();
    }
}
