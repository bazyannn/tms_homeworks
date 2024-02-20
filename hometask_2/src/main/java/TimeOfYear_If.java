import java.util.Scanner;

public class TimeOfYear_If {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String TimeOfYear = scanner.next();

        if (TimeOfYear.equals("january") || TimeOfYear.equals("february") || TimeOfYear.equals("december"))  {
            System.out.println("winter");

        } else if (TimeOfYear.equals("march") || TimeOfYear.equals("april") || TimeOfYear.equals("may")) {
            System.out.println("spring");

        } else if (TimeOfYear.equals("june") || TimeOfYear.equals("july") || TimeOfYear.equals("august")) {
            System.out.println("summer");

        } else if (TimeOfYear.equals("september") || TimeOfYear.equals("october") || TimeOfYear.equals("november")) {
            System.out.println("autumn");

        }
    }
}
