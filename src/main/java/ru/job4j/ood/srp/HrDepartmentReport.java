package ru.job4j.ood.srp;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class HrDepartmentReport implements Report {

    private Store store;

    public HrDepartmentReport(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        List<Employee> employeeList = store.findBy(filter);
        employeeList.sort(Comparator.comparing(Employee::getSalary).reversed());
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;").append(System.lineSeparator());
        for (Employee worker : employeeList) {
            text.append(worker.getName()).append(";")
                    .append(worker.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}