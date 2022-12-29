public class Candy extends Product {
    private double weight;

    public Candy(double weight) {
        this.weight = weight;
    }

    public Candy(int id, String name, double price, int quatity, Category category, double weight) {
        super(id, name, price, quatity, category);
        this.weight = weight;
    }

    public Candy() {
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return super.toString()+
                "weight=" + weight ;
    }
}
