import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        String path="/Users/HieuHip/IdeaProjects/Product_Category/src/category.txt";
        String pathProduct="/Users/HieuHip/IdeaProjects/Product_Category/src/product.txt";
        ManagerCategory managerCategory=new ManagerCategory();
        managerCategory.listCategory=managerCategory.read(path);
        ManagerProduct managerProduct=new ManagerProduct(managerCategory);
        managerProduct.listProduct =(managerProduct.read(pathProduct));
        int choice=-1;
        do {
            System.out.println("Welcome to shop management!!");
            System.out.println("M-E-N-U");
            System.out.println("Press 1 to create new category");
            System.out.println("Press 2 to show category");
            System.out.println("Press 3 to delete category by ID");
            System.out.println("Press 4 to edit category by ID");
            System.out.println("-*-*-*-*-*-*-*-*-*-*-");
            System.out.println("Press 5 to create new product: ");
            System.out.println("Press 6 to show all product: ");
            System.out.println("Press 7 to delete product by id:");
            System.out.println("Press 8 to edit product by id: ");
            System.out.println("Press 9 to show all product of candy");
            System.out.println("Press 10 to show all product of drink");
            System.out.println("Press 11 to find product by their name");
            System.out.println("Press 12 to show all of Product have the highest price and lowest price!");
            System.out.println("Press 13 to show all of Product in a price range!");
            System.out.println("Press 0 to exit");
            System.out.println("Enter your choice:");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 0:
                    System.out.println("Bye~");
                    break;
                case 1:
                    System.out.println("Please enter information of category: ");
                    managerCategory.addCategory(path,scanner);
                    System.out.println("Successful!");
                    break;
                case 2:
                    System.out.println("All of category is: ");
                    managerCategory.displayCategory();
                    break;
                case 3:
                    managerCategory.deleteCategoryById(scanner);
                    break;
                case 4:
                    managerCategory.editCategoryById(scanner);
                    System.out.println("Edit successful! Press 2 to check back your category!");
                    break;
                case 5:
                    System.out.println("Please enter information of product: ");
                    managerProduct.addProduct(pathProduct,scanner);
                    break;
                case 6:
                    System.out.println("All of product: ");
                    managerProduct.displayPro();
                    break;
                case 7:
                    managerProduct.deleteProById(scanner);
                    break;
                case 8:
                    managerProduct.editProductById(scanner);
                    System.out.println("Edit successful! Please check again your product list!!");
                    break;
                case 9:
                    System.out.println("All of product of candy is:");
                    managerProduct.displayProductByCandy();
                    break;
                case 10:
                    System.out.println("All of product of drink is:");
                    managerProduct.displayProductByDrink();
                    break;
                case 11:
                    managerProduct.findProductByName(scanner);
                    break;
                case 12:
                    System.out.println("Highest price: ");
                    managerProduct.displayProductByMaxPrice(scanner);
                    System.out.println("Lowest price: ");
                    managerProduct.displayProductByMinPrice(scanner);
                    break;
                case 13:
                    managerProduct.findProductByPrice(scanner);
                    break;
            }
        }while (choice!=0);
    }
}