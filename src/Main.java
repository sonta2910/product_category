import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        String path="/Users/HieuHip/IdeaProjects/Product_Category/src/ca";
        ManagerCategory managerCategory=new ManagerCategory();
        managerCategory.listCategory=managerCategory.read(path);
        int choice=-1;
        do {
            System.out.println("Welcome to shop management!!");
            System.out.println("Press 1 to create new category");
            System.out.println("Press 2 to show category");
            System.out.println("Enter your choice:");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    System.out.println("Please enter information of category: ");
                    managerCategory.addCategory(path,scanner);
                    System.out.println("Successful!");
                    break;
                case 3:
                    System.out.println("All of category is: ");
                    managerCategory.displayCategory();
                    break;
            }
        }while (choice!=0);
    }
}