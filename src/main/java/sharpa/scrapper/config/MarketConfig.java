package sharpa.scrapper.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sharpa.scrapper.Refresher;

@Configuration
public class MarketConfig {

    private static final Logger logger = LoggerFactory.getLogger(MarketConfig.class);


//    @Bean
//    public Timer buildTimer() {
//
//        System.out.println("Timer dao cerated!");
//
//        return new Timer();
//
//    }

    @Bean
    public Refresher buildRefresher() {
        logger.info("Refresher started..");

        return new Refresher();
    }

}
