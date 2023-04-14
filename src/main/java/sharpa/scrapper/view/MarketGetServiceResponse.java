package sharpa.scrapper.view;

public class MarketGetServiceResponse {

    private boolean success;
    private String lowest_price;
    private String volume;
    private String medianPrice;

    public MarketGetServiceResponse() {
    }

    public MarketGetServiceResponse(boolean success, String lowest_price, String volume, String medianPrice) {
        this.success = success;
        this.lowest_price = lowest_price;
        this.volume = volume;
        this.medianPrice = medianPrice;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getLowest_price() {
        return lowest_price;
    }

    public void setLowest_price(String lowest_price) {
        this.lowest_price = lowest_price;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getMedianPrice() {
        return medianPrice;
    }

    public void setMedianPrice(String medianPrice) {
        this.medianPrice = medianPrice;
    }

    @Override
    public String toString() {
        return "MarketResponse{" +
                "success=" + success +
                ", lowestPrice=" + lowest_price +
                ", volume=" + volume +
                ", medianPrice=" + medianPrice +
                '}';
    }
}
