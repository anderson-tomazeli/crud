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
            System.out.println("Choose an operation:");
            System.out.println("[1] - Create");
            System.out.println("[2] - List");
            System.out.println("[3] - Update");
            System.out.println("[4] - Delete");
            System.out.println("[5] - Exit");

            option = entrada.nextInt();
            entrada.nextLine();
            if (option == 1){
                System.out.print("Name: ");
                String name = entrada.nextLine();
                System.out.print("Phone Number: ");
                String phoneNumber = entrada.nextLine();
                System.out.print("Birth day [dd-mon-yyyy]: ");
                String strBirthDay = entrada.nextLine();
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                Date birthDay = Calendar.getInstance().getTime();
                try {
                    birthDay = formatter.parse(strBirthDay);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                Date creationDate = Calendar.getInstance().getTime();
                Date lastUpdateDate = Calendar.getInstance().getTime();
                System.out.print("Final course grade: ");
                String finalCourseGrade = entrada.nextLine(); //entrada.nextLine();
                Person person1 = new Person();
                person1.createPerson(lista.size(), name, phoneNumber, birthDay, creationDate, lastUpdateDate, finalCourseGrade);
                lista.add(person1);
                System.out.println("\nPerson created successfully");
            } else if (option == 2) {
                if (lista.size() > 0) {
                    System.out.println("Rec Num| Name                 | Phone         | Birth Day   | Creation Date | Last update date | Final course grade | Type");
                    //for (Person p : lista) {
                    for (int index=0; index < lista.size(); index++){
                        System.out.print(String.format("%-" + 7 + "s", index) + "| ");
                        System.out.println(lista.get(index));
                    }
                } else {
                    System.out.println("There are no records to be listed");
                }
            } else if (option == 3) {
                if (lista.size() > 0){
                    System.out.print("Rec Num to be updated: ");
                    int index = entrada.nextInt();
                    entrada.nextLine();
                    System.out.print("Enter the new values for...\nName: ");
                    String newName = entrada.nextLine();
                    System.out.print("Phone: ");
                    String newPhone = entrada.nextLine();
                    System.out.print("Birth Day: ");
                    String newBirthDay = entrada.nextLine();
                    System.out.print("Creation Date: ");
                    String newCreationDate = entrada.nextLine();
                    System.out.print("Last Update Date: ");
                    String newLastUpdateDate = entrada.nextLine();
                    System.out.print("Final course grade: ");
                    String newFinalCourseGrade = entrada.nextLine();
                } else {
                    System.out.println("There are no records to be updated");
                }
            }
            else if (option == 4) {
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

    /*private static String checkNewValue(String fieldFrom, String fieldTo) {
        if ((!newName.equals(lista.get(index).name)) && (!newName.isBlank())) {
            lista.get(index).name = newName;
        }
    }*/

}
