package ru.mephi;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        List<Employee> pl = Employee.createShortList();

        Supplier<Employee> newEmpSupplier =
                () -> new Employee.Builder()
                        .setGivenName("Saplai")
                        .setSurName("Saplaivovich")
                        .setAge(54)
                        .setGender(Gender.MALE)
                        .setRole(Role.STAFF)
                        .setDept("Cher")
                        .build();
        pl.add(newEmpSupplier.get());

        pl.stream()
                .filter(p -> p.getGender().equals(Gender.FEMALE))
                .forEach(p -> Employee.payPremium(p));

        System.out.println("-------------------------------");

        pl.stream()
                .filter(p -> p.getDept().equals("Ain"))
                .forEach(p -> Employee.paySalary(p));

        System.out.println("-------------------------------");

        BiPredicate<Integer, Integer> bi = (x, y) -> x > y;

        pl.stream()
                .filter(p -> p.getDept().equals("Aisne"))
                .filter(p -> bi.test(p.getAge(), 30))
                .forEach(p -> Employee.payPremium(p));

        System.out.println("-------------------------------");

        pl.stream()
                .filter(p -> p.getRole().equals(Role.MANAGER))
                .forEach(p -> Employee.paySalary(p));

        System.out.println("-------------------------------");

        pl.stream()
                .filter(p -> p.getRole().equals(Role.STAFF))
                .forEach(p -> Employee.payPremium(p));

        System.out.println("-------------------------------");

        Function<Employee, String> employeeFunction = t -> (t.getGivenName() + " " + t.getSurName());
        System.out.println("Full name of first worker:");
        System.out.println(employeeFunction.apply(pl.get(0)));

    }
}
