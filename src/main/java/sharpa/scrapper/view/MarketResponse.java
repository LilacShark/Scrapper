package sharpa.scrapper.view;

public class MarketResponse {

    private String goodName;
    private double price;

    public MarketResponse(String goodName, double price) {
        this.goodName = goodName;
        this.price = price;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
