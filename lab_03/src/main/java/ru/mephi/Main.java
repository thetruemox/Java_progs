package ru.mephi;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Employee> pl = Employee.createShortList();

        //map
        System.out.println("================map================");

        pl.stream()
                .map(Employee::getGivenName)
                .forEach(System.out::println);

        System.out.println("===================================");

        pl.stream()
                .filter(p -> p.getRole().equals(Role.MANAGER))
                .map(Employee::getAge)
                .forEach(System.out::println);
        //peek
        System.out.println("================peek================");

        pl.stream()
                .filter(p -> p.getRole().equals(Role.EXECUTIVE))
                .map(Employee::getSalary)
                .forEach(System.out::println);
        System.out.println("-------------");
        pl.stream()
                .filter(p -> p.getRole().equals(Role.EXECUTIVE))
                .peek(p -> p.setSalary((int)(p.getSalary()*1.5)))
                .map(Employee::getSalary)
                .forEach(System.out::println);

        System.out.println("===================================");

        pl.stream()
                .filter(p -> p.getAge() < 30)
                .peek(p -> Employee.paySalary(p))
                .collect(Collectors.toList());

        System.out.println("================findFirst================");

        Optional<Employee> first = pl.stream()
                .filter(p -> p.getAge() > 30)
                .findFirst();
        System.out.println(first);

        System.out.println("===================================");

        first = pl.parallelStream()
                .filter(p -> p.getAge() > 30)
                .findFirst();
        System.out.println(first);

        System.out.println("================max================");

        Optional<Integer> num = pl.stream()
                .map(Employee::getSalary)
                .max(Integer::compare);
        System.out.println(num);

        System.out.println("-------------");

        num = pl.stream()
                .map(Employee::getAge)
                .max(Integer::compare);
        System.out.println(num);

        System.out.println("================min================");

        num = pl.stream()
                .map(Employee::getSalary)
                .min(Integer::compare);
        System.out.println(num);

        System.out.println("-------------");

        num = pl.stream()
                .map(Employee::getAge)
                .min(Integer::compare);
        System.out.println(num);

        System.out.println("================average================");

        OptionalDouble dbl_num = pl.stream()
                .mapToInt(Employee::getSalary)
                .average();
        System.out.println(dbl_num);

        System.out.println("-------------");

        dbl_num = pl.stream()
                .mapToInt(Employee::getAge)
                .average();
        System.out.println(dbl_num);

        System.out.println("================sum================");

        int sum = pl.stream()
                .mapToInt(Employee::getSalary)
                .sum();
        System.out.println(sum);

        System.out.println("-------------");

        sum = pl.stream()
                .mapToInt(Employee::getAge)
                .sum();
        System.out.println(sum);

        /*
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
        */
    }
}
