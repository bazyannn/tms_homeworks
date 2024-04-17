import java.util.List;
import java.util.Objects;

public class Student {

    private String name;
    private boolean isMan;
    private Integer age;
    private List<String> classes;

    public Student(String name, boolean isMan, Integer age, List<String> classes) {
        this.name = name;
        this.isMan = isMan;
        this.age = age;
        this.classes = classes;
    }


    public boolean isMan() {
        return isMan;
    }

    public void setMan(boolean man) {
        isMan = man;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<String> getClasses() {
        return classes;
    }

    public void setClasses(List<String> classes) {
        this.classes = classes;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", isMan=" + isMan +
                ", age=" + age +
                ", classes=" + classes +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(classes, student.classes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(classes);
    }
}
