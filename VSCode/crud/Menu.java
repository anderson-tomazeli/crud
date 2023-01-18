package crud;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    static Person p1;
    static ArrayList<Person> personList;
    
    public static void main(String[] args) {
        
        personList = new ArrayList<>();
        
        Scanner inputData = new Scanner(System.in);
        int option = 0;

        do{
            showOptions();
            option = inputData.nextInt();
            inputData.nextLine();

            switch (option){
                case 1:
                    p1 = new Person();
                    p1.AddPerson();
                    break;
                case 2:
                    System.out.println("Read [list]");
                    p1 = new Person();
                    p1.ListPeople();
                    break;
                case 3:
                    System.out.println("Update");
                    p1.UpdatePerson();
                    break;
                case 4:
                    System.out.println("Delete");
                    p1 = new Person();
                    p1.DeletePerson();
                    break;
                case 5:
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }

        } while (option != 5);

        inputData.close();
    }

    static void showOptions(){
        System.out.println("Choose an operation:");
        System.out.println("[1] - Create");
        System.out.println("[2] - List");
        System.out.println("[3] - Update");
        System.out.println("[4] - Delete");
        System.out.println("[5] - Exit");
    }

}
