package sharpa.scrapper.model;


import javax.persistence.*;
import java.util.List;

@Table(name = "mts_goods")
@Entity
public class Goods {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "good_id")
    private long goodId;
    @Column(name = "market_hash_name")
    private String marketHashName;
    @Column(name = "market_name")
    private String marketName;
    @Column(name = "app_id")
    private int appId;
    @OneToMany(cascade = {CascadeType.REFRESH},
            fetch = FetchType.LAZY, mappedBy = "good") // отношение между таблицами
    private List<Prices> prices;
    @OneToMany(cascade = {CascadeType.REFRESH},
            fetch = FetchType.LAZY, mappedBy = "goodId") // отношение между таблицами
    private List<Storage> store;


    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public long getGoodId() {
        return goodId;
    }

    public void setGoodId(long goodId) {
        this.goodId = goodId;
    }

    public String getMarketHashName() {
        return marketHashName;
    }

    public void setMarketHashName(String marketHashName) {
        this.marketHashName = marketHashName;
    }

    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }

    public List<Prices> getPrices() {
        return prices;
    }

    public void setPrices(List<Prices> prices) {
        this.prices = prices;
    }
}
