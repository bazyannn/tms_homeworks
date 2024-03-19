import java.util.Arrays;
import java.util.Scanner;

public class Array2 {

    public static void main(String[] args) {

        int n;
        Scanner console = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array( < 47): ");  //т.к. int
        n = console.nextInt();
        int[] arr = new int[n];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i < n; i++) {
            arr[i] = arr[i - 2] + arr[i - 1];
        }
        System.out.println(Arrays.toString(arr));


        }
    }
