import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagerCategory {
    Category category = new Category();
    public ArrayList<Category> listCategory;

    public ManagerCategory() {
        listCategory = new ArrayList<>();
    }

    public Category createCategory(Scanner scanner) {
        System.out.println("Enter ID of category: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter name of category: ");
        String name = scanner.nextLine();
        return new Category(id, name);
    }

    public ArrayList<Category> addCategory(String path, Scanner scanner) {
        Category addCategory = createCategory(scanner);
        listCategory.add(addCategory);
        write(path, listCategory);
        return listCategory;
    }

    public void displayCategory() {
        for (Category a : listCategory) {
            System.out.println(a);
        }
    }

    public void write(String path, ArrayList<Category> listCategory) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(listCategory);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException a) {
            a.printStackTrace();
        }
    }

    public ArrayList<Category> read(String path) {
        ArrayList<Category> listCategory = new ArrayList<>();
        try {
//            File file = new File(path);
//            if (!file.exists()) {
//                file.createNewFile();
//            }
            FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            listCategory = (ArrayList<Category>) objectInputStream.readObject();
            fileInputStream.close();
            objectInputStream.close();
        } catch (Exception a) {
            a.printStackTrace();
        }
        return listCategory;
    }
}
