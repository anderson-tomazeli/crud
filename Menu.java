import javax.swing.text.Utilities;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class Menu {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        //List<Person> people = new ArrayList<>();
        ArrayList<Person> lista = new ArrayList<>();

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
                String strBirthDay = entrada.next();
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                //Date birthDay = formatter.parse(strBirthDay);;
                Date birthDay = Calendar.getInstance().getTime();
                try {
                    birthDay = formatter.parse(strBirthDay);
                    //System.out.println(date);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                //System.out.println("Creation date [dd-mon-yyyy]: ");
                //String creationDate = entrada.next();
                Date creationDate = Calendar.getInstance().getTime();
                //System.out.println("Last update date [dd-mon-yyyy]: ");
                //String lastUpdateDate = entrada.next();
                Date lastUpdateDate = Calendar.getInstance().getTime();
                System.out.println("Final course grade: ");
                double finalCourseGrade = entrada.nextDouble();
                Person person1 = new Person();
                person1.createPerson(lista.size(), name, phoneNumber, birthDay, creationDate, lastUpdateDate, finalCourseGrade);
                //person1.addPerson(person1);
                lista.add(person1);
                System.out.println("Person created successfully");
            } else if (option == 2) {
                System.out.println("Listing...");
                System.out.println("Id     | Name                 | Phone         | Birth Day   | Creation Date | Last update date | Final course grade");
                for (Person p: lista){
                    System.out.println(p);
                }
                System.out.println();
            } else if (option == 4) {
                System.out.println("Choose the Id you wish to delete: ");
                int idDelete = entrada.nextInt();
                lista.remove(idDelete);
                System.out.println("Id " + idDelete + " deleted successfully");

                //System.out.println();
            }
        } while (option != 5);

        System.out.println("Bye!");
        entrada.close();
    }
}
