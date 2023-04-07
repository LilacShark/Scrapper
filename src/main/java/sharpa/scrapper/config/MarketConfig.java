package sharpa.scrapper.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sharpa.scrapper.Refresher;

@Configuration
public class MarketConfig {

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
        System.out.println("Refresher started..");
        return new Refresher();
    }

}
