package pro.sky.streamapiandoptional.service;

import org.springframework.stereotype.Service;
import pro.sky.streamapiandoptional.exceptions.EmployeeNotFoundException;
import pro.sky.streamapiandoptional.model.Employee;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentServiceInterface {

    private final EmployeeBookServiceImpl service;

    public DepartmentServiceImpl(EmployeeBookServiceImpl service) {
        this.service = service;
    }

    @Override
    public Employee findMaxSalaryDepartment(Integer department) {
        return service.getEmployeeMap().values().stream()
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparingDouble(e -> e.getSalary()))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Employee findMinSalaryDepartment(Integer department) {
        return service.getEmployeeMap().values().stream()
                .filter(e -> e.getDepartment() == department)
                .min(Comparator.comparingDouble(e -> e.getSalary()))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public List<Employee> getDepartmentAll(Integer department) {
        return service.getEmployeeMap().values().stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> getDepartmentEmployees() {
        return service.getEmployeeMap().values().stream()
                .collect(Collectors.groupingBy(e -> e.getDepartment()));
    }
}
