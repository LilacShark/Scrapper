package sharpa.scrapper.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sharpa.scrapper.model.Goods;

import java.util.List;

@Repository
public interface GoodsDAO extends JpaRepository<Goods, Long> {

//    Goods findFirstById(Long good_id);
    Goods findByGoodId(Long good_id);


    Goods findByMarketName(String name);

    @Query(value = "SELECT g.marketName FROM Goods g", nativeQuery = false) //    https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
    List<String> findAllGoodsNamesNativeAsString();


    @Query(value = "SELECT g.market_name, g.market_hash_name FROM mts_goods g", nativeQuery = true) //надо переписать на JPQL
    List<Object> findAllGoodsNamesNativeAsObject();

}
