import java.util.Scanner;

public class TimeOfYear_If {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String timeOfYear = scanner.next();

        if (timeOfYear.equals("january") || timeOfYear.equals("february") || timeOfYear.equals("december"))  {
            System.out.println("winter");

        } else if (timeOfYear.equals("march") || timeOfYear.equals("april") || timeOfYear.equals("may")) {
            System.out.println("spring");

        } else if (timeOfYear.equals("june") || timeOfYear.equals("july") || timeOfYear.equals("august")) {
            System.out.println("summer");

        } else if (timeOfYear.equals("september") || timeOfYear.equals("october") || timeOfYear.equals("november")) {
            System.out.println("autumn");

        }
    }
}
