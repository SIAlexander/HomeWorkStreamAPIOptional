package pro.sky.streamapiandoptional.service;

import org.springframework.stereotype.Service;
import pro.sky.streamapiandoptional.exceptions.EmployeeAlreadyAddedException;
import pro.sky.streamapiandoptional.exceptions.EmployeeNotFoundException;
import pro.sky.streamapiandoptional.model.Employee;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeBookServiceImpl implements EmployeeBookServiceInterface {
    private final Map<String, Employee> employeeMap;

    public EmployeeBookServiceImpl() {
        this.employeeMap = new HashMap<>();
    }

    public Map<String, Employee> getEmployeeMap() {
        return employeeMap;
    }

    @Override
    public Employee addEmployee(String name, String surname, double salary, int department) {
        Employee employee = new Employee(name, surname, salary, department);
        if (employeeMap.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        employeeMap.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String name, String surname, double salary, int department) {
        Employee employee = new Employee(name, surname, salary, department);
        if (!employeeMap.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundException();
        }
        return employeeMap.remove(employee.getFullName());
    }

    @Override
    public Employee findEmployee(String name, String surname, double salary, int department) {
        Employee employee = new Employee(name, surname, salary, department);
        if (!employeeMap.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundException();
        }
        return employeeMap.get(employee.getFullName());

    }

    @Override
    public Collection<Employee> printAll() {
        return Collections.unmodifiableCollection(employeeMap.values());
    }
}
