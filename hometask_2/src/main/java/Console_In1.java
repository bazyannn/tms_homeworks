import java.util.Scanner;

public class Console_In1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число < 10000");
        int number = sc.nextInt();

        int x , y , z, j;

//        int numDigits = (int) Math.log10(number) + 1;  ( если ввести ноль будет мин значение инта, как я понял)
        int numDigits = String.valueOf(number).length();
        System.out.println("Всего " + numDigits + " знака");


        x = number % 10;
        number /= 10;
        System.out.println( x + " единиц");

        y = number % 10;
        number /= 10;
        System.out.println( y + " десятка");

        z = number % 10;
        number /= 10;
        System.out.println( z + " сотни");

        j = number % 10;
        System.out.println( j + " тысяч");

    }
}










