public class Cat {
    public String name;
    public int age;
    public String breed;


    public Cat (String name, int age, String breed) {
        this.name = name;
        this.age = age;
        this.breed = breed;

    }
    public Cat (String name, int age) {
        this(name,age,"No breed");
        this.breed = "No breed";

    }

    public void info () {
        System.out.println(name);
        System.out.println(age);
        System.out.println(breed);
    }

    public String newName(String newName) {
        this.name = newName;
        return name;

    }



}
