package ru.job4j.ood.srp;

import java.util.function.Predicate;

public class AccountingDepartmentReport implements Report {

    private final static double COURSE_USD = 60;

    private Store store;

    public AccountingDepartmentReport(Store store) {
        this.store = store;
    }

    public static double convertUsdToRub(double salary) {
        return salary * COURSE_USD;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary(Rub);");
        for (Employee employee : store.findBy(filter)) {
            text.append(System.lineSeparator())
                    .append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(convertUsdToRub(employee.getSalary())).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}