import java.util.Scanner;

public class Console_In3 {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        int number = console.nextInt();

        for (int i = 0; i < number; i++) {
            if (i % 3 == 0 && i % 2 == 1) {
                System.out.print(i + " ");
            }
        }
    }
}