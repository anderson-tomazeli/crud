import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int option;

        System.out.println("Choose an operation related to Person/Student:");
        System.out.println("[1] - Create");
        System.out.println("[2] - Show");
        System.out.println("[3] - Update");
        System.out.println("[4] - Delete");
        System.out.println("[5] - Exit");

        do {
            option = entrada.nextInt();
        } while (option != 5);

        System.out.println("Bye!");
        entrada.close();
    }
}
