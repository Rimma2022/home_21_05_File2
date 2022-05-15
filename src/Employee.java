import java.io.Serializable;

public class Employee implements Serializable {
    private String surname;
    private String name;
    private int age;
    private String position;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Employee(String surname, String name, int age, String position) {
        this.surname = surname;
        this.name = name;
        this.age = age;
        this.position = position;
    }

    @Override
    public String toString() {
        return "Surname: " + surname + ", name: " + name + ", age: " + age + ", position: " + position + "\n";

    }
}
