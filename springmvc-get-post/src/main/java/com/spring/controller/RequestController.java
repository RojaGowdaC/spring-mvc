package com.spring.controller;
import com.spring.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@RestController
public class RequestController {

    List<Employee>employeeList= new ArrayList<Employee>();
    @GetMapping("/employee")
    public List<Employee> get() {
        return employeeList;
    }
    @PostMapping("/employee")
    public Employee post(@RequestBody Employee employee)
    {
        employeeList.add(employee);
        return employee;
    }

    @DeleteMapping(value = "/employee/{empId}")
    public List<Employee> delete(@PathVariable String empId) {
        ListIterator<Employee>
                iterator = employeeList.listIterator();
        while (iterator.hasNext()) {

               if(iterator.next().getEmpId().equals(empId))
               {
                   iterator.remove();
                   break;
               }
        }
        return employeeList;
    }
    @PutMapping(value = "/employee/{empId}")
    public List<Employee> put(@PathVariable String empId,@RequestBody Employee employee) {

        ListIterator<Employee>
                iterator = employeeList.listIterator();
        while (iterator.hasNext()) {

            Employee tempEmp = iterator.next();
            if(tempEmp.getEmpId().equals(empId))
            {
                tempEmp.setEmpName(employee.getEmpName());
                break;
            }
        }
        return employeeList;
    }

}
