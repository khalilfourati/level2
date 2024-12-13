package edu.esprit.game.levels;

import edu.esprit.game.models.Employee;
import edu.esprit.game.utils.Data;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Level2 {
	public static void main(String[] args) {
		List<Employee> employees = Data.employees();

		// TO DO 1: Retourner le nombre des employés dont le nom commence avec "n"
		long nbr = employees.stream()
				.filter(employee -> employee.getName().toLowerCase().startsWith("n"))
				.count();
		System.out.println("Number of employees whose names start with 'n': " + nbr);

		// TO DO 2: Retourner la somme des salaires de tous les employés
		long sum = employees.stream()
				.mapToInt(Employee::getSalary)
				.sum();
		System.out.println("Sum of all employees' salaries: " + sum);

		// TO DO 3: Retourner la moyenne des salaires des employés dont le nom commence avec "s"
		double average = employees.stream()
				.filter(employee -> employee.getName().toLowerCase().startsWith("s"))
				.mapToInt(Employee::getSalary)
				.average()
				.orElse(0.0);
		System.out.println("Average salary of employees whose names start with 's': " + average);

		// TO DO 4: Retourner la liste de tous les employés
		List<Employee> emps = employees.stream()
				.collect(Collectors.toList());
		System.out.println("List of all employees: " + emps);

		// TO DO 5: Retourner la liste des employés dont le nom commence par "s"
		List<Employee> emps2 = employees.stream()
				.filter(employee -> employee.getName().toLowerCase().startsWith("s"))
				.collect(Collectors.toList());
		System.out.println("Employees whose names start with 's': " + emps2);

		// TO DO 6: Retourner true si il y a au moins un employé dont le salaire > 1000, false sinon
		boolean test = employees.stream()
				.anyMatch(employee -> employee.getSalary() > 1000);
		System.out.println("Is there any employee with a salary greater than 1000? " + test);

		// TO DO 7: Afficher le premier employé dont le nom commence avec "s" avec deux manières différentes
		// First way
		Optional<Employee> firstWay = employees.stream()
				.filter(employee -> employee.getName().toLowerCase().startsWith("s"))
				.findFirst();
		firstWay.ifPresent(employee -> System.out.println("First way: " + employee));

		// Second way
		employees.stream()
				.filter(employee -> employee.getName().toLowerCase().startsWith("s"))
				.limit(1)
				.forEach(employee -> System.out.println("Second way: " + employee));

		// TO DO 8: Afficher le second employé dont le nom commence avec "s"
		employees.stream()
				.filter(employee -> employee.getName().toLowerCase().startsWith("s"))
				.skip(1)
				.findFirst()
				.ifPresent(employee -> System.out.println("Second employee whose name starts with 's': " + employee));
	}
}
