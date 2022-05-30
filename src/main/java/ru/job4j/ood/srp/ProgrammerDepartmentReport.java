package ru.job4j.ood.srp;

import java.util.function.Predicate;

public class ProgrammerDepartmentReport implements Report {

    private Store store;

    public ProgrammerDepartmentReport(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        String ls = System.lineSeparator();
        for (Employee employee : store.findBy(filter)) {
            text.append("<html>").append(ls)
                    .append("<head>").append(ls)
                    .append("/<head>").append(ls)
                    .append("<body>").append(ls)
                    .append("Name; Hired; Fired; Salary;").append(ls)
                    .append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(ls)
                    .append("/<body>").append(ls)
                    .append("</html>")
                    .append(ls);
        }
        return text.toString();
    }
}