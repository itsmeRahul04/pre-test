package com.capgemini;

import com.capgemini.entity.employee;
import com.capgemini.repository.employeeRepository;
import com.capgemini.service.employeeServiceImp;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;



@SpringBootTest(classes = {ServiceMockitoTest.class})
@ExtendWith(SpringExtension.class)
public class ServiceMockitoTest {

    @Mock
    employeeRepository repository;

    @InjectMocks
    employeeServiceImp serviceImp;

    @Test
    @Order(1)
    public void test_getBooking() {
        List<employee> emp=new ArrayList<>();
        emp.add(new employee(001,"Rahul","Rahul@gmail.com","testing"));
        emp.add(new employee(002,"Krishna","Krishna@gmail.com","development"));

        when(repository.findAll()).thenReturn(emp);
        assertEquals(2,serviceImp.getAllEmployee().size());
    }

    @Test
    @Order(2)
    public void test_addBooking() {
        employee emp=new employee(001,"Rahul","Rahul@gmail.com","testing");
        when(repository.save(emp)).thenReturn(emp);
        assertEquals(emp, serviceImp.addEmployee(emp));
    }

    @Test
    @Order(3)
    public void test_deleteBooking() {
        employee emp=new employee(001,"Rahul","Rahul@gmail.com","testing");
        serviceImp.deleteEmployee(emp.getId());
        verify(repository,times(1)).deleteById(emp.getId());
    }



    @Test
    @Order(4)
    public void test_updateBooking() {
        employee emp=new employee(001,"Rahul","Rahul@gmail.com","testing");
        when(repository.save(emp)).thenReturn(emp);
        assertEquals(emp, serviceImp.addEmployee(emp));
    }


}
