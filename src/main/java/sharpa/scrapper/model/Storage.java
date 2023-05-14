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



}
