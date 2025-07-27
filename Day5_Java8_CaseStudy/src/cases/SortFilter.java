package cases;

import java.util.Arrays;
import java.util.List;

public class SortFilter {

	public class EmployeeLambda {
	    static class Employee {
	        String name;
	        double salary;

	        Employee(String name, double salary) {
	            this.name = name;
	            this.salary = salary;
	        }

	        public String toString() {
	            return name + " - $" + salary;
	        }
	    }

	    public static void main(String[] args) {
	        List<Employee> employees = Arrays.asList(
	            new Employee("Alice", 50000),
	            new Employee("Bob", 70000),
	            new Employee("Charlie", 60000)
	        );

	        // Sort by name
	        employees.sort((e1, e2) -> e1.name.compareTo(e2.name));
	        System.out.println("Sorted by Name: " + employees);

	        // Sort by salary
	        employees.sort((e1, e2) -> Double.compare(e1.salary, e2.salary));
	        System.out.println("Sorted by Salary: " + employees);

	        // Filter salary > 55000
	        employees.stream()
	            .filter(e -> e.salary > 55000)
	            .forEach(System.out::println);
	    }
	}

}
