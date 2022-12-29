import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagerProduct {
    ManagerCategory managerCategory;


    Product product = new Product();
    public ArrayList<Product> listProduct;

    public void setListProduct(ArrayList<Product> listProduct) {
        this.listProduct = listProduct;
    }

    public ManagerProduct(ManagerCategory managerCategory) {
        listProduct = new ArrayList<>();
        this.managerCategory = managerCategory;
    }
    public int checkId(){
        int maxId=0;
        for (Product a:listProduct) {
            if(a.getId()>maxId){
                maxId=a.getId();
            }
            return maxId;
        }
     return 0;
    }
    int id;
    public Product createPro(Scanner scanner) {
        id = checkId();
        id++;
        System.out.println("Enter name of product: ");
        String name = scanner.nextLine();
        System.out.println("Enter price of product: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter quatity of product: ");
        int quatity =Integer.parseInt(scanner.nextLine());
        System.out.println("Enter category of product: ");
        Category category = managerCategory.choiceCategory(scanner);
        System.out.println("Please enter type of product:");
        System.out.println("1.Candy");
        System.out.println("2.Drink");
        System.out.println("3.Others");
        int choice=Integer.parseInt(scanner.nextLine());
        switch (choice){
            case 1:
                System.out.println("Please enter weight of candy: ");
                double weight=Double.parseDouble(scanner.nextLine());
                Candy candy=new Candy(id,name,price,quatity,category,weight);
                product =  candy;
                System.out.println("Product has been added!!\nPress 6 to show all your product!");
                break;
            case 2:
                System.out.println("Please enter volume of drink:");
                double volume = Double.parseDouble(scanner.nextLine());
                System.out.println("Please enter type of bottle:");
                String typeBottle= scanner.nextLine();
                Drink drink=new Drink(id,name,price,quatity,category,volume,typeBottle);
                product = drink;
                System.out.println("Product has been added!!\nPress 6 to show all your product!");
                break;
            case 3:
                System.out.println("Please enter new category:");
                String checkCategory = scanner.nextLine();
                Category category1 = managerCategory.checkCategory(checkCategory);
                product = new Product(id,name,price,quatity,category1);
                break;
    }return product;
    }
    public ArrayList<Product> addProduct(String path, Scanner scanner) {
        Product addProduct = createPro(scanner);
        listProduct.add(addProduct);
        write(path, listProduct);
        return listProduct;
    }
    public Product deleteProById(Scanner scanner){
        Product product1=null;
        System.out.println("Enter id of product you want to delete: ");
        int classId=Integer.parseInt(scanner.nextLine());
        for (Product a: listProduct) {
            if(classId==a.getId()){
                product1=a;
                break;
            }else{
                System.out.println("Id not found!!!");
            }
        }
        listProduct.remove(product1);
        System.out.println("Delete Successful!!");
        return product1;
    }
    public void displayPro(){
        for (Product a : listProduct) {
            System.out.println(a);
        }
        if(listProduct.isEmpty()){
            System.out.println("There is no product in shop!!!\nCreate new product and comeback then!");
        }
    }
    public void editProductById(Scanner scanner) {
        Product product1= new Product();
        System.out.println("Enter id of product you want to edit:");
        int productId = Integer.parseInt(scanner.nextLine());
        productId = productId - 1 ;
        if (productId < listProduct.size() && productId > 0) {
            System.out.println("Enter new name of product:");
            String name = scanner.nextLine();
            System.out.println("Enter new price of product:");
            double price = Double.parseDouble(scanner.nextLine());
            System.out.println("Enter new quality of product:");
            int quatity =Integer.parseInt(scanner.nextLine());
            System.out.println("Enter new category of product:");
            Category category1 = managerCategory.choiceCategory(scanner);
            System.out.println("Enter new type of product:");
            System.out.println("1.Candy");
            System.out.println("2.Drink");
            System.out.println("3.Others");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Please enter weight of candy: ");
                    double weight = Double.parseDouble(scanner.nextLine());
                    Candy candy = new Candy(id, name, price, quatity, category1, weight);
                    product1 = candy;
                    System.out.println("Product has been added!!\nPress 6 to show all your product!");
                    break;
                case 2:
                    System.out.println("Please enter volume of drink:");
                    double volume = Double.parseDouble(scanner.nextLine());
                    System.out.println("Please enter type of bottle:");
                    String typeBottle = scanner.nextLine();
                    Drink drink = new Drink(id, name, price, quatity, category1, volume, typeBottle);
                    product1 = drink;
                    System.out.println("Product has been added!!\nPress 6 to show all your product!");
                    break;
                case 3:
                    System.out.println("Please enter new category:");
                    String checkCategory = scanner.nextLine();
                    Category category2 = managerCategory.checkCategory(checkCategory);
                    product1 = new Product(id, name, price,quatity, category2);
                    break;
            }
            listProduct.set(productId,product1);
        }else{
                System.out.println("Do not have this id in your product!!");
            }

        }
        public void displayProductByCandy(){
            for (Product a:listProduct) {
                if(a instanceof Candy){
                    System.out.println(a);
                }
                }
            }

        public void displayProductByDrink(){
            for (Product b: listProduct) {
                if(b instanceof Drink){
                    System.out.println(b);
                }
            }
        }
        public void findProductByName(Scanner scanner){
        String name = scanner.nextLine();
            for (Product a: listProduct) {
                if(name.contains(a.getName())){
                    System.out.println(a);
                }
            }
        }
        public void displayProductByMaxPrice(Scanner scanner){
        double maxPrice=listProduct.get(0).getPrice();
            for (Product b: listProduct) {
                if(b.getPrice()>maxPrice){
                    maxPrice= b.getPrice();
                }
            }
            for (Product c:listProduct) {
             if(c.getPrice()==maxPrice){
                 System.out.println(c);
             }
            }
        }
        public void displayProductByMinPrice(Scanner scanner){
        double minPrice=listProduct.get(0).getPrice();
            for (Product a:listProduct) {
                if(a.getPrice()<minPrice){
                    minPrice=a.getPrice();
                }
            }
            for (Product b:listProduct) {
                if(b.getPrice()==minPrice){
                    System.out.println(b);
                }
            }
        }
        public void findProductByPrice(Scanner scanner){
            System.out.println("Min price is:");
        double minPrice=Double.parseDouble(scanner.nextLine());
            System.out.println("Max price is: ");
        double maxPrice=Double.parseDouble(scanner.nextLine());
            System.out.println("All of product in a price range is:");
            for (Product a:listProduct) {
                if(a.getPrice()>=minPrice&&a.getPrice()<=maxPrice){
                    System.out.println(a);
                }
            }
        }
    public void write(String path, ArrayList<Product> listProduct) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(listProduct);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException a) {
            a.printStackTrace();
        }
    }
    public ArrayList<Product> read(String path) {
        ArrayList<Product> listProduct = new ArrayList<>();
        try {
            File file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileInputStream fileInputStream = new FileInputStream(path);
            if (fileInputStream.available() != 0) {
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                listProduct = (ArrayList<Product>) objectInputStream.readObject();
                fileInputStream.close();
                objectInputStream.close();
            }
        } catch (Exception a) {
            a.printStackTrace();
        }

        return listProduct;
    }
}
