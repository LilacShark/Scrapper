package sharpa.scrapper.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "mts_storage")
@Entity
public class Storage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "storage_id")
    Long storageId;
    @Column(name = "good_id")
    @ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.LAZY)
    @JoinColumn(name = "good_id")
    Goods goodId;
    @Column(name = "buy_price")
    Double buyPrice;
    @Column(name = "buy_date")
    LocalDateTime buyDate;
    @Column(name = "selling_price")
    Double sellingPrice;
    @Column(name = "minimal_price")
    Double minimalPrice;
    @Column(name = "selling_date")
    LocalDateTime sellingDate;

    public Long getStorageId() {
        return storageId;
    }

    public void setStorageId(Long storageId) {
        this.storageId = storageId;
    }

    public Goods getGoodId() {
        return goodId;
    }

    public void setGoodId(Goods goodId) {
        this.goodId = goodId;
    }

    public Double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(Double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public LocalDateTime getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(LocalDateTime buyDate) {
        this.buyDate = buyDate;
    }

    public Double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public Double getMinimalPrice() {
        return minimalPrice;
    }

    public void setMinimalPrice(Double minimalPrice) {
        this.minimalPrice = minimalPrice;
    }

    public LocalDateTime getSellingDate() {
        return sellingDate;
    }

    public void setSellingDate(LocalDateTime sellingDate) {
        this.sellingDate = sellingDate;
    }
}
