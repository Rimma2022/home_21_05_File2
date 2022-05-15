import java.io.Serializable;
import java.util.ArrayList;

public class Employees implements Serializable{
    private ArrayList<Employee> array;

    public ArrayList<Employee> getArray() {
        return array;
    }

    public void setArray(ArrayList<Employee> array) {
        this.array = array;
    }

    public Employees(ArrayList<Employee> array) {
        this.array = array;
    }

    @Override
    public String toString() {
        return "Employees: \n" + array;

    }
}
