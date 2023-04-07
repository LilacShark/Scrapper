package sharpa.scrapper.business;

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

    @Autowired
    GoodsDAO goodsDAO;
    @Autowired
    PricesDAO pricesDAO;

    public MarketResponse showPrice(Goods g) {

        Goods byGoodId = goodsDAO.findByGoodId(1L);
        Prices lastPriceForGood = pricesDAO.findTopByGoodOrderByPriceDateDesc(byGoodId);

        MarketResponse marketResponse = new MarketResponse(byGoodId.getMarketName(),
                lastPriceForGood.getPrice());

        return marketResponse;
    }

    public Double getPrice(Goods g) {

        Goods byGoodId = goodsDAO.findByGoodId(1L);
        Prices lastPriceForGood = pricesDAO.findTopByGoodOrderByPriceDateDesc(byGoodId);

        return lastPriceForGood.getPrice();
    }

    public Prices saveNewPrice(Goods good, Double doublePrice) {

        Prices price = new Prices();
        price.setPrice(doublePrice);
        price.setPriceDate(LocalDateTime.now());
        price.setCurrency(5);
        price.setGood(good);

        return pricesDAO.saveAndFlush(price);
    }

    public List<Goods> getAllGoods() {
        return goodsDAO.findAll();
    }
}
