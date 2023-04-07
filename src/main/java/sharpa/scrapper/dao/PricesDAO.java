package sharpa.scrapper.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sharpa.scrapper.model.Goods;
import sharpa.scrapper.model.Prices;

@Repository
public interface PricesDAO extends JpaRepository<Prices, Long> {

    Prices findTopByGoodOrderByPriceDateDesc(Goods goods);

}
