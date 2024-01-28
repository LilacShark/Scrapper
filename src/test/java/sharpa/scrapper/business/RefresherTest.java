package sharpa.scrapper.business;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import sharpa.scrapper.web.GetService;

import static org.junit.jupiter.api.Assertions.*;

class RefresherTest {

    @Mock
    GetService getService;
    @Mock
    MarketManager marketManager;

    @InjectMocks
    Refresher refresher;

    @Test
    void refreshMarketData_Refresh() {

    }

}