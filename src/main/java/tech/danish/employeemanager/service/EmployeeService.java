package tech.danish.employeemanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.danish.employeemanager.exception.UserNotFoundException;
import tech.danish.employeemanager.model.Employee;
import tech.danish.employeemanager.repo.EmployeeRepo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService{
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployee(){
        return employeeRepo.findAll();
    }

    public  Employee updateEmployee(Employee employee){
        return employeeRepo.save(employee);
    }

    public Employee findEmployeeById(Long id){
        return employeeRepo.findEmployeeById(id).orElseThrow(() -> new UserNotFoundException("User Not Found"));
    }
    @Transactional
    public void deleteEmployee(Long id) {
        employeeRepo.deleteEmployeeById(id);
    }
}
