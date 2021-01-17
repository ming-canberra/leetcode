package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
}

public class EmployeeImportance690 {
    public static void main(String[] args) {
        EmployeeImportance690 thisClass = new EmployeeImportance690();
        Employee e1 = new Employee();
        e1.id = 1;
        e1.importance = 5;

        List<Integer> e1List = new ArrayList<Integer>();
        e1List.add(2);
        e1List.add(3);

        Employee e2 = new Employee();
        e2.id = 2;
        e2.importance = 3;

        Employee e3 = new Employee();
        e3.id = 3;
        e3.importance = 3;


        System.out.println(thisClass.getImportance(null, 1));
    }

    HashMap<Integer,Employee> _map;
    public int getImportance(List<Employee> employees, int id) {
        _map = new HashMap<Integer, Employee>();

        if (employees != null){
            for (Employee e: employees){
                _map.put(e.id, e);
            }

            Employee parent = _map.get(id);

            return fun(parent);
        }

        return 0;
    }

    private int fun(Employee e){
        if (e != null){
            int sum = e.importance;

            if (e.subordinates != null){
                for (Integer i : e.subordinates){
                    sum+=fun(_map.get(i));
                }
            }

            return sum;
        }

        return 0;
    }


}
