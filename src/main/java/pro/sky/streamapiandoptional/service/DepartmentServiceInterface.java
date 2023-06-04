package pro.sky.streamapiandoptional.service;

import pro.sky.streamapiandoptional.model.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentServiceInterface {

    Employee findMaxSalaryDepartment(Integer department);

    Employee findMinSalaryDepartment(Integer department);

    List<Employee> getDepartmentAll(Integer department);

    Map<Integer, List<Employee>> getDepartmentEmployees();
}
