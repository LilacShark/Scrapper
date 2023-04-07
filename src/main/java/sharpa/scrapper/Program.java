package sharpa.scrapper;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Program {

    public static void main(String[] args) {

        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("springContext.xml");

        Refresher refresher = applicationContext.getBean(Refresher.class);

        while(true) {

            refresher.refreshMarketData();

            try {
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }


}
