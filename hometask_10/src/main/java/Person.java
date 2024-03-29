import java.util.Objects;

public class Person implements Cloneable {

    private String name;
    private int age;
    private int salary;
    private Cat cat;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Person(String name, int age, int salary, Cat cat) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.cat = cat;
    }

    @Override
    public String toString() {
        return "Person "
                + "name: " + name + " "
                + "age: " + age + " "
                + "salary: " + salary + " "
                + "cat: " + cat.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && salary == person.salary && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary);
    }
}
