import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.text.ParseException;

public class Menu {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ArrayList<Person> lista = new ArrayList<>();

        int option;

        do {
            System.out.println("\nChoose an operation:");
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
                String strBirthDay = entrada.next();
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                Date birthDay = Calendar.getInstance().getTime();
                try {
                    birthDay = formatter.parse(strBirthDay);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                Date creationDate = Calendar.getInstance().getTime();
                Date lastUpdateDate = Calendar.getInstance().getTime();
                System.out.println("Final course grade: ");
                String finalCourseGrade = entrada.next(); //entrada.nextLine();
                Person person1 = new Person();
                person1.createPerson(lista.size(), name, phoneNumber, birthDay, creationDate, lastUpdateDate, finalCourseGrade);
                lista.add(person1);
                System.out.println("Person created successfully");
            } else if (option == 2) {
                if (lista.size() > 0) {
                    System.out.println("Rec Num| Name                 | Phone         | Birth Day   | Creation Date | Last update date | Final course grade");
                    //for (Person p : lista) {
                    for (int index=0; index < lista.size(); index++){
                        System.out.print(String.format("%-" + 7 + "s", index) + "| ");
                        System.out.println(lista.get(index));
                    }
                } else {
                    System.out.println("There are no records to be listed");
                }
            } else if (option == 4) {
                if (lista.size() > 0) {
                    System.out.print("Rec Num to be deleted: ");
                    int idDelete = entrada.nextInt();
                    lista.remove(idDelete);
                    System.out.println("Record " + idDelete + " deleted successfully");
                } else {
                    System.out.println("There are no records to be deleted");
                }
            }
        } while (option != 5);

        System.out.println("Bye!");
        entrada.close();
    }
}
