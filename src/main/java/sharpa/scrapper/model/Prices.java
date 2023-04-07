package sharpa.scrapper.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "mts_prices")
@Entity
public class Prices {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "price_id")
    private long priceId;
    @ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.LAZY)
    @JoinColumn(name = "good_id")
    private Goods good;
    @Column(name = "price")
    private double price;
    @Column(name = "currency")
    private int currency;
    @Column(name = "price_date")
    LocalDateTime priceDate;


    public long getPriceId() {
        return priceId;
    }

    public void setPriceId(long priceId) {
        this.priceId = priceId;
    }

    public Goods getGood() {
        return good;
    }

    public void setGood(Goods good) {
        this.good = good;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCurrency() {
        return currency;
    }

    public void setCurrency(int currency) {
        this.currency = currency;
    }

    public LocalDateTime getPriceDate() {
        return priceDate;
    }

    public void setPriceDate(LocalDateTime priceDate) {
        this.priceDate = priceDate;
    }
}
