package com.capgemini.service;

import com.capgemini.entity.employee;
import com.capgemini.repository.employeeRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class employeeServiceImp {

    @Autowired
    employeeRepository repository;

    Logger logger = LoggerFactory.getLogger(employeeServiceImp.class);

    public List<employee> getAllEmployee(){
        logger.info("Getting all employee details");
        List<employee> allEmployeeList = repository.findAll();
        return allEmployeeList;
    }

    public Optional<employee> getEmployee(Long id){
        logger.info("Getting Employee by id");
        Optional<employee> empById = repository.findById(id);
        logger.info("Successful search of Booking by id");
        return empById;
    }

    public employee addEmployee(employee emp){
        logger.info("Adding a new Employee");
        employee newEmp = repository.save(emp);
        logger.info("Added Employee");
        return newEmp;
    }

    public String updateEmployee(employee emp, Long id ){
        logger.info("Updating Employee details");
        emp.setId(id);
        repository.save(emp);
        logger.info("Updated Successfully");
        return "employee updated with id = "+emp.getId();

    }

    public String deleteEmployee(Long id){
        logger.info("Deleting employee by id");
        repository.deleteById(id);
        logger.info("Employee Deleted");
        return "Employee deleted with Id = " + id;
    }

}
