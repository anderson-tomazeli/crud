import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        List<Person> people = new ArrayList<>();

        int option;

        do {
            System.out.println("Choose an operation related to Person/Student:");
            System.out.println("[1] - Create");
            System.out.println("[2] - List");
            System.out.println("[3] - Update");
            System.out.println("[4] - Delete");
            System.out.println("[5] - Exit");

            option = entrada.nextInt();
            if (option == 1){
                System.out.println("Name: ");
                String name = entrada.next();
                System.out.println("Phone Number: ");
                String phoneNumber = entrada.next();
                System.out.println("Birth day [dd-mon-yyyy]: ");
                String birthDay = entrada.next();
                System.out.println("Creation date [dd-mon-yyyy]: ");
                String creationDate = entrada.next();
                System.out.println("Last update date [dd-mon-yyyy]: ");
                String lastUpdateDate = entrada.next();
                System.out.println("Final course grade: ");
                double finalCourseGrade = entrada.nextDouble();
                Person person1 = new Person();
                person1.createPerson(name, phoneNumber, birthDay, creationDate, lastUpdateDate, finalCourseGrade);
                //person1.addPerson(person1);
                people.add(person1);
                System.out.println("Person created successfully");
            } else if (option == 2) {
                System.out.println("Listing...");
                for (int a = 0; a < people.size(); a++) {
                    System.out.println("name " + people.get(a).name);
                }

            }
        } while (option != 5);

        System.out.println("Bye!");
        entrada.close();
    }
}
