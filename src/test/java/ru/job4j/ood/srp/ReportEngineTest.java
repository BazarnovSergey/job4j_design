package ru.job4j.ood.srp;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import static ru.job4j.ood.srp.AccountingDepartmentReport.convertUsdToRub;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ReportEngineTest {

    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenGeneratedForAccountingDepartmentReport() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new AccountingDepartmentReport(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary(Rub);")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(convertUsdToRub(worker.getSalary())).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenGeneratedForHrDepartmentReport() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 70);
        Employee worker2 = new Employee("Vladimir", now, now, 85);
        Employee worker3 = new Employee("Dmitriy", now, now, 90);
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(worker1);
        employeeList.add(worker2);
        employeeList.add(worker3);
        store.add(worker1);
        store.add(worker2);
        store.add(worker3);
        Report engine = new HrDepartmentReport(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(worker3.getName()).append(";")
                .append(worker3.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker2.getName()).append(";")
                .append(worker2.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker1.getName()).append(";")
                .append(worker1.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenGeneratedForProgrammerDepartmentReport() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ProgrammerDepartmentReport(store);
        String ls = System.lineSeparator();
        StringBuilder expect = new StringBuilder()
                .append("<html>").append(ls)
                .append("<head>").append(ls)
                .append("/<head>").append(ls)
                .append("<body>").append(ls)
                .append("Name; Hired; Fired; Salary;").append(ls)
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(ls)
                .append("/<body>").append(ls)
                .append("</html>")
                .append(ls);
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenReportFormatJson() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, null, 100);
        store.add(worker);
        Report engine = new JSONReport(store);
        StringBuilder expected = new StringBuilder()
                .append("[")
                .append("{")
                .append("\"name\":")
                .append("\"")
                .append(worker.getName())
                .append("\",")
                .append("\"hired\":")
                .append("{")
                .append("\"year\":")
                .append(worker.getHired().get(Calendar.YEAR))
                .append(",")
                .append("\"month\":")
                .append(worker.getHired().get(Calendar.MONTH))
                .append(",")
                .append("\"dayOfMonth\":")
                .append(worker.getHired().get(Calendar.DAY_OF_MONTH))
                .append(",")
                .append("\"hourOfDay\":")
                .append(worker.getHired().get(Calendar.HOUR_OF_DAY))
                .append(",")
                .append("\"minute\":")
                .append(worker.getHired().get(Calendar.MINUTE))
                .append(",")
                .append("\"second\":")
                .append(worker.getHired().get(Calendar.SECOND))
                .append("},")
                .append("\"salary\":")
                .append(worker.getSalary())
                .append("}")
                .append("]");
        assertThat(engine.generate(em -> true), is(expected.toString()));
    }

    @Test
    public void whenReportFormatXML() {
        MemStore store = new MemStore();
        Calendar calendar = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        String date = dateFormat.format(calendar.getTime());
        Employee worker = new Employee("Ivan", calendar, calendar, 100);
        store.add(worker);
        Report engine = new XMLReport(store);
        StringBuilder expected = new StringBuilder()
                .append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>")
                .append("\n<employees>\n")
                .append("    <employee>\n")
                .append("        <fired>")
                .append(date)
                .append("</fired>\n")
                .append("        <hired>")
                .append(date)
                .append("</hired>\n")
                .append("        <name>")
                .append(worker.getName())
                .append("</name>\n")
                .append("        <salary>")
                .append(worker.getSalary())
                .append("</salary>\n")
                .append("    </employee>")
                .append("\n</employees>\n");
        assertThat(engine.generate(em -> true), is(expected.toString()));
    }
}
