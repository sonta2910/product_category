public class Drink extends Product{
    private double volume;
    private String bottleType;

    public Drink(double volume, String bottleType) {
        this.volume = volume;
        this.bottleType = bottleType;
    }

    public Drink(int id, String name, double price, int quatity, Category category, double volume, String bottleType) {
        super(id, name, price, quatity, category);
        this.volume = volume;
        this.bottleType = bottleType;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public String getBottleType() {
        return bottleType;
    }

    public void setBottleType(String bottleType) {
        this.bottleType = bottleType;
    }

    @Override
    public String toString() {
        return super.toString()+
                "Drink{" +
                "volume=" + volume +
                ", bottleType='" + bottleType + '\'' +
                '}';
    }

    public Drink() {
    }
}
