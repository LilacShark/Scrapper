package sharpa.scrapper.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sharpa.scrapper.model.Goods;


@Repository
public interface GoodsDAO extends JpaRepository<Goods, Long> {

//    Goods findFirstById(Long good_id);
    Goods findByGoodId(Long good_id);


    Goods findByMarketName(String name);
}
