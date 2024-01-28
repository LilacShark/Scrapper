package sharpa.scrapper.rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import sharpa.scrapper.business.MarketManager;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc(printOnlyOnFailure = false) //для тестирования рест эндпоинтов
class MarketControllerIT {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    MarketManager marketManager;

    @Test
    void showMarketPrice() throws Exception {
    }

    @Test
    void handleGetAllGoods() throws Exception {
        //given
        var requestBuilder = get("/api/goods");

        //when
        this.mockMvc.perform(requestBuilder).andExpectAll(
                status().isOk(),
                content().contentType(MediaType.APPLICATION_JSON),
                content().json("""
                        [{},{}]
                        """)


        );

        //then
    }
}