import java.util.List;
import java.util.Objects;

public class User implements Comparable<User> {

    private String name;
    private Integer workExp;
    private List<String> taskList;

    public User(String name, Integer workExp, List<String> taskList) {
        this.name = name;
        this.workExp = workExp;
        this.taskList = taskList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWorkExp() {
        return workExp;
    }

    public void setWorkExp(Integer workExp) {
        this.workExp = workExp;
    }

    public List<String> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<String> taskList) {
        this.taskList = taskList;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", workExp=" + workExp +
                ", taskList=" + taskList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(User o) {
        return o.getWorkExp() - this.workExp;
        }
    }

