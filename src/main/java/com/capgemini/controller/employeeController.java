package com.capgemini.controller;

import com.capgemini.entity.employee;
import com.capgemini.service.employeeServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class employeeController {

    @Autowired
    employeeServiceImp serviceImp;

    Logger logger = LoggerFactory.getLogger(employeeController.class);

    @GetMapping("/allEmployees")
    public List<employee> getAllEmployees(){
        logger.info("Getting all Employee Details");
        List<employee> emp= serviceImp.getAllEmployee();

        return emp;
    }

    @GetMapping("/getEmployee/{id}")
    public ResponseEntity<?> getEmployee(@PathVariable Long id){
        logger.info("Getting Employee Details By employee Id");
        ResponseEntity<?> responseEntity = null;
        Optional<employee> booking  = serviceImp.getEmployee(id);
        responseEntity = new ResponseEntity<>(booking, HttpStatus.OK);
        logger.info("Successful search of Employee details by Id");
        return responseEntity;

    }

    @PostMapping("/addEmployee")
    public ResponseEntity<employee> addEmployee(@RequestBody employee emp) {
        logger.info("Creating a New Booking");
        employee newEmployee = serviceImp.addEmployee(emp);
        ResponseEntity<employee> responseEntity = new ResponseEntity<employee>(newEmployee, HttpStatus.ACCEPTED);
        logger.info("Created a new Employee");
        return responseEntity;
    }

    @PutMapping("/updateEmployee/{id}")
    public ResponseEntity<Object> updateEmployee(@RequestBody employee emp, @PathVariable Long id) {
        logger.info("Updating Employee details by id");
        ResponseEntity<Object> responseEntity = null;
        serviceImp.updateEmployee(emp, id);
        responseEntity = new ResponseEntity<Object>("Employee Updated successfully", HttpStatus.OK);
        logger.info(" Employee Updated Successfully");
        return responseEntity;
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable Long id) {
        logger.info("Deleting Employee details by Id");
        ResponseEntity<Object> responseEntity = null;
        serviceImp.deleteEmployee(id);
        responseEntity = new ResponseEntity<Object>(" Deleted successfully", HttpStatus.OK);
        logger.info("Deleted Successfully");
        return responseEntity;
    }
}
