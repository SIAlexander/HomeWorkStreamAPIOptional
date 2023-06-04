package pro.sky.streamapiandoptional.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.streamapiandoptional.model.Employee;
import pro.sky.streamapiandoptional.service.DepartmentServiceInterface;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentServiceInterface service;

    public DepartmentController(DepartmentServiceInterface service) {
        this.service = service;
    }

    @GetMapping(path = "/all")
    public Map<Integer, List<Employee>> getDepartmentEmployees() {
        return service.getDepartmentEmployees();
    }

    @GetMapping(path = "/all", params = "/departmentId")
    public List<Employee> getDepartmentAll(@RequestParam("departmentId") Integer department) {
        return service.getDepartmentAll(department);
    }

    @GetMapping(path = "/min-salary")
    public Employee findMinSalaryDepartment(@RequestParam("departmentId") Integer department) {
        return service.findMinSalaryDepartment(department);
    }

    @GetMapping(path = "/max-salary")
    public Employee findMaxSalaryDepartment(@RequestParam("departmentId") Integer department) {
        return service.findMaxSalaryDepartment(department);
    }
}
