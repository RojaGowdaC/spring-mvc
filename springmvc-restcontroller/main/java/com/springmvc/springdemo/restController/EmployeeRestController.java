package com.luv2code.springdemo.restController;

import com.luv2code.springdemo.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/emp")
public class EmployeeRestController {

    private List<Employee> employeeList=new ArrayList<>();

    @PostConstruct
    public void loadData()
    {
        employeeList.add(new Employee(1,"xyz","PS"));
        employeeList.add(new Employee(2,"abc","FAWB"));
        employeeList.add(new Employee(3,"qwr","Mech"));
    }
    @GetMapping("/employee")
    public List<Employee> getEmployees()
    {
        return employeeList;
    }

    @GetMapping("/employee/{employeeId}")
    public Employee getEmployee(@PathVariable Integer employeeId)
    {
        return employeeList.get(employeeId);
    }
}
