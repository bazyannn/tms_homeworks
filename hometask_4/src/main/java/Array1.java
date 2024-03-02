import java.util.Arrays;
import java.util.Scanner;

public class Array1 {

    public static void main(String[] args) {

        // создание массива целых чисел
        int n;
        Scanner console = new Scanner(System.in);
        System.out.print("Enter numbers of array: ");
        n = console.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * 10);
        }
        System.out.println(Arrays.toString(arr));

        // среднее арифметическое всех чисел
        double sum = 0;
        for (int x : arr) {
            sum += x;
        }
        double average = sum / arr.length;

        System.out.print("Average: " + average);

        System.out.println();

        // найти любое число которое повторяется

        System.out.println("Enter number for find: ");

        Scanner scanner = new Scanner(System.in);
        int toFind = scanner.nextInt();
        int[] indexArr = new int[arr.length];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == toFind) {
                indexArr[j] = i;
                j++;
            }
        }
        System.out.println("Index: ");

        System.out.println(Arrays.toString(indexArr));

        // сортировка массива min-max

        int buf;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int k = 0; k < arr.length - 1 - i; k++) {
                buf = arr[k];
                if (arr[k] > arr[k + 1]) {
                    arr[k] = arr[k + 1];
                    arr[k + 1] = buf;
                }
            }
        }

        System.out.println("Sort min-max: ");

        System.out.println(Arrays.toString(arr));

        // сортировка массива max-min

        int z = arr.length;
        for (int i = 0; i < z / 2; i++) {
            int temp = arr[z - i - 1];
            arr[z - i - 1] = arr[i];
            arr[i] = temp;
        }

        System.out.println("Sort max-min: ");

        // скопировать в новый массив, но в обратном порядке(получилось преобразовать)

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " " );
        }

        int[] arrD;
        arrD = arr;

        System.arraycopy(arr, 0, arrD, 0, arr.length);

        System.out.println();

        System.out.println("New array: ");

        System.out.println(Arrays.toString(arrD));


    }
}






