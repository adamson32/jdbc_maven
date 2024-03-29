package com.mycompany.zadanie1_jdbc.maven;

import java.sql.SQLException;
import java.util.List;

public class zadanie1_jdbc {

    public static void main(String[] args) throws SQLException {
//        EmployeeDAO dao = new EmployeeDAO();
//        Employee p1 = new Employee("Kasia", "Kowalska", 28, "123456987", "jan.kowalski@op.pl");
//        dao.add(p1);
//        getAllEmployees(dao);
//        Employee p2 = dao.getByID(1);
//        System.out.println(p1.getPracImie() + " " + p1.getPracEmail());
//        dao.deleteByID(3);
//        dao.update(1, "Adam", "Kowalski", 23, "798576243", "adam@op.pl");
//        findEmployeeByEmailEndsWith(dao);
    }

    private static void getAllEmployees(EmployeeDAO employeeDAO) throws SQLException {
        List<Employee> empList = employeeDAO.getAll();
        for (Employee employee : empList) {
            displayEmployee(employee);
        }
    }

    private static void displayEmployee(Employee p) {
        System.out.println("prac_id:" + p.getPracId());
        System.out.println("prac_imie:" + p.getPracImie());
        System.out.println("prac_nazwisko:" + p.getPracNazwisko());
        System.out.println("prac_wiek:" + p.getPracWiek());
        System.out.println("prac_nr_telefonu:" + p.getPracNrTelefonu());
        System.out.println("prac_email:" + p.getPracEmail());
        System.out.println();
    }

    private static void findEmployeeByEmailEndsWith(EmployeeDAO employeeDAO) throws SQLException {
        String s = "outlook.com";
        List<Employee> empList = employeeDAO.findByEmailEndsWith(s);
        for (Employee employee : empList) {
            displayEmployee(employee);
        }
    }
}
