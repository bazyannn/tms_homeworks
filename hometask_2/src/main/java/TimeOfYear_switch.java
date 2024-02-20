import java.util.Scanner;

public class TimeOfYear_switch {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        String TimeOfYear = scanner.next();

        switch (TimeOfYear) {
            case "january", "february", "december":
                 System.out.println("winter");
                 break;
            case "march", "april", "may":
                 System.out.println("spring");
                 break;
            case "june", "july", "august":
                 System.out.println("summer");
                 break;
            case "september", "october", "november":
                 System.out.println("autumn");

        }

    }
}


