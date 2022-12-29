import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagerCategory {
    Category category = new Category();
    public ArrayList<Category> listCategory;

    public ManagerCategory() {
        listCategory = new ArrayList<>();
    }
    public int checkId(){
        int maxId=0;
        for (Category a:listCategory) {
            if(a.getId()>maxId){
                maxId=a.getId();
            }
            return maxId;
        }
        return 0;
    }
    int id;
    public Category createCategory(Scanner scanner) {
        id=checkId();
        id++;
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
        if (listCategory.isEmpty()){
            System.out.println("Do not have any category in your shop!\nPlease press 1 to create new category");
        }
    }
    public Category deleteCategoryById(Scanner scanner){
        Category category1=null;
        System.out.println("Enter id of category you want to delete: ");
        int categoryId=Integer.parseInt(scanner.nextLine());
        for (Category a: listCategory) {
            if(categoryId==a.getId()){
                category1=a;
                break;
            }else{
                System.out.println("Id not found!!!");
            }
        }
        listCategory.remove(category1);
        System.out.println("Delete Successful!!");
        return category1;
    }
    public Category choiceCategory(Scanner scanner){
        String name= scanner.nextLine();
        Category choiceCategoryName;
        for (Category a:listCategory) {
            if (a.getName().equalsIgnoreCase(name)) {
                choiceCategoryName = a;
                return choiceCategoryName;
            }
        }
        System.out.println("There is no category in your shop! \nPlease create new category!!");
            choiceCategoryName = createCategory(scanner);
        listCategory.add(choiceCategoryName);
            return choiceCategoryName;
    }
    public void editCategoryById(Scanner scanner) {
        System.out.println("Enter id of category you want to edit: ");
        int categoryId = Integer.parseInt(scanner.nextLine());
        if (categoryId <= listCategory.size() && categoryId > 0) {
            for (Category a:listCategory) {
                if(a.getId()==categoryId){
            System.out.println("Enter new name of category:");
            String name = scanner.nextLine();
                    a.setName(name);
                }
            }
        } else {
            System.out.println("Can not find this id!!");
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
            if (fileInputStream.available() != 0) {
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                listCategory = (ArrayList<Category>) objectInputStream.readObject();
                fileInputStream.close();
                objectInputStream.close();
            }
        } catch (Exception a) {
            a.printStackTrace();
        }
        return listCategory;
    }
    public ArrayList<Category>inputStream(String path){
        ArrayList<Category> listClassRoom = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            listClassRoom = (ArrayList<Category>) ois.readObject();
            fis.close();
            ois.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return listClassRoom;
    }
    public Category checkCategory(String checkCategory){
        Category categoryCheck = null;
        for (Category a:listCategory) {
            if(a.getName().equalsIgnoreCase(checkCategory)){
                 categoryCheck=a;
                 return categoryCheck;
            } else {
                categoryCheck=new Category(id++, checkCategory);
            }
        }
        return categoryCheck;
    }
}
