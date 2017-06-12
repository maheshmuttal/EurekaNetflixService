package com.mahesh.endpoints;

import com.mahesh.entity.Employee;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeEndpoint {

    @RequestMapping(
            value = "/employee",
            method = RequestMethod.GET
    )
    public Employee get() {
        System.out.println("GET Employee called....");
        Employee emp = new Employee();
        emp.setName("emp1");
        emp.setDesignation("manager");
        emp.setEmpId("1");
        emp.setSalary(3000);

        return emp;
    }
}
