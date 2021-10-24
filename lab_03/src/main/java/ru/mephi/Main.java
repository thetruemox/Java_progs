package ru.mephi;

import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        List<Employee> pl = Employee.createShortList();

        pl.stream()
                .filter(p -> p.getGender().equals(Gender.FEMALE))
                .forEach(p -> Employee.payPremium(p));

        System.out.println("-------------------------------");

        pl.stream()
                .filter(p -> p.getDept().equals("Ain"))
                .forEach(p -> Employee.paySalary(p));

        System.out.println("-------------------------------");

        pl.stream()
                .filter(p -> p.getDept().equals("Aisne"))
                .filter(p -> p.getAge() > 30)
                .forEach(p -> Employee.payPremium(p));

        System.out.println("-------------------------------");

        pl.stream()
                .filter(p -> p.getRole().equals(Role.MANAGER))
                .forEach(p -> Employee.paySalary(p));

        System.out.println("-------------------------------");

        pl.stream()
                .filter(p -> p.getRole().equals(Role.STAFF))
                .forEach(p -> Employee.payPremium(p));
    }
}
