package pro.sky.streamapiandoptional.service;

import pro.sky.streamapiandoptional.model.Employee;

import java.util.Collection;

public interface EmployeeBookServiceInterface {

    Employee addEmployee(String name, String surname, double salary, int department);

    Employee removeEmployee(String name, String surname, double salary, int department);

    Employee findEmployee(String name, String surname, double salary, int department);

    Collection<Employee> printAll();
}
