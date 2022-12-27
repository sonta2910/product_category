public class Product {
    private int id;
    private String name;
    private double price;
    private String quanlity;
    private Category category;

    public Product() {
    }

    public Product(int id, String name, double price, String quanlity, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quanlity = quanlity;
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

    public String getQuanlity() {
        return quanlity;
    }

    public void setQuanlity(String quanlity) {
        this.quanlity = quanlity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quanlity='" + quanlity + '\'' +
                ", category=" + category +
                '}';
    }
}
