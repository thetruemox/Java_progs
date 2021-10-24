package ru.mephi;
import java.util.List;
import java.util.ArrayList;

enum Gender {
    MALE, FEMALE;
}

enum Role {
    STAFF(1.1), MANAGER(1.2), EXECUTIVE(1.3);

    private double percent;

    Role(double percent) {
        this.percent = percent;
    }

    public double getPercent() {
        return percent;
    }
}

public class Employee {
    private String givenName;
    private String surName;
    private int age;
    private Gender gender;
    private Role role;
    private String dept;
    private String eMail;
    private String phone;
    private String adress;
    private String city;
    private String state;
    private String code;

    public String getGivenName() {
        return this.givenName;
    }
    public String getSurName() {
        return this.surName;
    }
    public int getAge() {
        return this.age;
    }
    public Gender getGender() {
        return this.gender;
    }
    public Role getRole() {
        return this.role;
    }
    public String getDept() {
        return this.dept;
    }
    public String getEMail() {
        return this.eMail;
    }
    public String getPhone() {
        return this.phone;
    }
    public String getAdress() {
        return this.adress;
    }
    public String getCity() {
        return this.city;
    }
    public String getState() {
        return this.state;
    }
    public String getCode() {
        return this.code;
    }

    private Employee(){
    }

    @Override
    public String toString() {
        return "Employee{" +
                " givenName = " + givenName + "," +
                " surName = " + surName + "," +
                " age = " + age + "," +
                " gender = " + gender + "," +
                " role = " + role + "," +
                " dept = " + dept +
                " }";
    }

    public static class Builder {
        private String givenName;
        private String surName;
        private int age;
        private Gender gender;
        private Role role;
        private String dept;
        private String eMail;
        private String phone;
        private String adress;
        private String city;
        private String state;
        private String code;

        public Builder setGivenName(String givenName) {
            this.givenName = givenName;
            return this;
        }
        public Builder setSurName(String surName) {
            this.surName = surName;
            return this;
        }
        public Builder setAge(int age) {
            this.age = age;
            return this;
        }
        public Builder setGender(Gender gender) {
            this.gender = gender;
            return this;
        }
        public Builder setRole(Role role) {
            this.role = role;
            return this;
        }
        public Builder setDept(String dept) {
            this.dept = dept;
            return this;
        }
        public Builder setEMail(String eMail) {
            this.eMail = eMail;
            return this;
        }
        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }
        public Builder setAdress(String adress) {
            this.adress = adress;
            return this;
        }
        public Builder setCity(String city) {
            this.city = city;
            return this;
        }
        public Builder setState(String state) {
            this.state = state;
            return this;
        }
        public Builder setCode(String code) {
            this.code = code;
            return this;
        }

        public Employee build() {
            Employee employee = new Employee();
            employee.givenName = this.givenName;
            employee.surName = this.surName;
            employee.age = this.age;
            employee.gender = this.gender;
            employee.role = this.role;
            employee.dept = this.dept;
            employee.eMail = this.eMail;
            employee.phone = this.phone;
            employee.adress = this.adress;
            employee.city = this.city;
            employee.state = this.state;
            employee.code = this.code;
            return employee;
        }

    }

    public static List<Employee> createShortList() {
        List<Employee> list = new ArrayList<>();

        list.add(new Builder()
                .setGivenName("Anna")
                .setSurName("Henrietta")
                .setAge(25)
                .setGender(Gender.FEMALE)
                .setRole(Role.MANAGER)
                .setDept("Ain")
                .build());
        list.add(new Builder()
                .setGivenName("Gustav")
                .setSurName("Adolf")
                .setAge(48)
                .setGender(Gender.MALE)
                .setRole(Role.EXECUTIVE)
                .setDept("Aisne")
                .build());
        list.add(new Builder()
                .setGivenName("Ivan")
                .setSurName("Ryurikovich")
                .setAge(36)
                .setGender(Gender.MALE)
                .setRole(Role.STAFF)
                .setDept("Aisne")
                .build());
        list.add(new Builder()
                .setGivenName("Olga")
                .setSurName("Ryurikovna")
                .setAge(30)
                .setGender(Gender.FEMALE)
                .setRole(Role.STAFF)
                .setDept("Allier")
                .build());
        list.add(new Builder()
                .setGivenName("Alexander")
                .setSurName("Romanov")
                .setAge(18)
                .setGender(Gender.MALE)
                .setRole(Role.EXECUTIVE)
                .setDept("Ain")
                .build());
        list.add(new Builder()
                .setGivenName("Wilhelm")
                .setSurName("Hohenzollern")
                .setAge(54)
                .setGender(Gender.MALE)
                .setRole(Role.MANAGER)
                .setDept("Cher")
                .build());
        list.add(new Builder()
                .setGivenName("Siemowit")
                .setSurName("Piast")
                .setAge(21)
                .setGender(Gender.MALE)
                .setRole(Role.STAFF)
                .setDept("Cher")
                .build());

        return list;
    }

    public static void paySalary(Employee emp) {
        double money = 300;
        System.out.println(money + " $ paid to " + emp.surName + " " + emp.givenName);
    }
    public static void payPremium(Employee emp) {
        double money = 300 * emp.role.getPercent();
        System.out.println(money + " $ paid to " + emp.surName + " " + emp.givenName);
    }
}
