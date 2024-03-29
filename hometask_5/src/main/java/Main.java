public class Main {

    public static void main(String[] args) {

        Cat cat1 = new Cat("Murlyka",2,"Russian blue cat");
        Cat cat2 = new Cat("Kity",2 );

        cat1.info();
        cat2.info();

        String newName = "Tom";

        System.out.println(cat1.newName(newName));
        System.out.println(cat2.newName(newName));
    }
}
