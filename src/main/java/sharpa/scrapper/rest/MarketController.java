package sharpa.scrapper.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sharpa.scrapper.business.MarketManager;
import sharpa.scrapper.model.Goods;
import sharpa.scrapper.view.MarketRequest;
import sharpa.scrapper.view.MarketResponse;

import java.util.List;

@RestController
@RequestMapping("api")
public class MarketController {


    @Autowired
    @Qualifier("marketService")
    private MarketManager marketManager;

    @RequestMapping(value = "/prices", method = RequestMethod.POST,
            consumes="application/json", produces = "application/json")
    public MarketResponse showMarketPrice(@RequestBody MarketRequest marketRequest) {

        System.out.println("showMarketPrice..");
        return marketManager.showPrice(marketRequest.getGoodName());

    }

    @GetMapping(value = "/goods")
    public ResponseEntity<List<String>> handleGetAllGoods() {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(marketManager.getAllGoodsNames());
    }

    @GetMapping(value = "/goodsObj")
    public ResponseEntity<List<Object>> handleGetAllGoodsObj() {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(marketManager.getAllGoodsNamesObject());
    }

//    http://localhost:8080/api/goods
//    curl -i -X GET http://localhost:8080/api/goods

}
