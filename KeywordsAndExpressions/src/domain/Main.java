package domain;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        List<Employee> employees = new ArrayList<>(List.of(
                new Employee(10001, "Ralph",2015),
                new Employee(10005, "Carole", 2021),
                new Employee(10022, "Jane" , 2013),
                new Employee(13151, "Laura", 2020),
                new Employee(10050, "Jim", 2018) ));

        employees.sort(new Employee.EmployeeComparator<>("yearStarted").reversed());


        for (Employee e : employees){

            System.out.println(e);
        }

        System.out.println("Store member");

        List<StoreEmployee> storeEmployees = new ArrayList<>(List.of(
                new StoreEmployee(10015, "Meg", 219,"Target"),
                new StoreEmployee(10515, "Joe", 219,"Walmart"),
                new StoreEmployee(10105, "Tom", 219,"Macys"),
                new StoreEmployee(10215, "Marty", 219,"Walmart"),
                new StoreEmployee(10322, "Bud", 219,"Target")
        ));

//        storeEmployees.sort();

        for (var storeMember: storeEmployees){

            System.out.println(storeMember);

        }
    }
}
