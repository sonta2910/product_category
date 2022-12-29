import java.io.Serializable;

public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private double price;
    private int quatity;
    private Category category;

    public Product() {
    }

    public Product(int id, String name, double price, int quatity, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quatity = quatity;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuatity() {
        return quatity;
    }

    public void setQuatity(int quatity) {
        this.quatity = quatity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product = " +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quanlity='" + quatity + '\'' +
                ", category=" + category;

    }
}
