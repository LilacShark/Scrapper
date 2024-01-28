package sharpa.scrapper.rest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import sharpa.scrapper.business.MarketManager;
import sharpa.scrapper.model.Goods;
import sharpa.scrapper.model.Prices;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class MarketControllerTest {

    @Mock
    private MarketManager marketManager;

    @InjectMocks
    MarketController controller;

    @Test
    void handleGetAllGoods_ReturnsValidResponse() {

        //given
        var goods = List.of(new Goods(1L, "MarketHashName_1",
                        "MarketName_1", 001),
                new Goods(2L, "MarketHashName_2",
                        "MarketName_2", 002));
        doReturn(goods).when(this.marketManager).getAllGoods();

        //when
        var responseEntity = this.controller.handleGetAllGoods();

        //then
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON, responseEntity.getHeaders().getContentType());
        assertEquals(goods, responseEntity.getBody());

    }


    @Test
    @DisplayName("POST /api/prices возвращает цену на объект")
    void showMarketPrice_ReturnsValidResponse() {
        //given
        var price = new Prices();
        doReturn(price).when(this.marketManager.showPrice(null));

        //when
        var marketPrice = this.marketManager.showPrice(null);

        //then
        assertNotNull(marketPrice);

    }



}