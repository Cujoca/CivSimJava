
/**
 * Created by timbuchalka on 1/09/2016.
 */
public class Employee implements Comparable<Employee> {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Employee o) {
        if (name.compareTo(o.name) == 0) {
            return (Integer.compare(age, o.age));
        }
        else {
            return name.compareTo(o.name);
        }
    }
}