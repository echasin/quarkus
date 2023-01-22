package org.demo.resource;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.Query;
import org.demo.domain.Employee;
import org.demo.filter.EmployeeFilter;
import org.demo.repository.EmployeeRepository;

import java.util.List;

@GraphQLApi
public class EmployeeFetcher {

    private EmployeeRepository repository;

    public EmployeeFetcher(EmployeeRepository repository){
        this.repository = repository;
    }

    @Query("employees")
    public List<Employee> findAll() {
        return repository.listAll();
    }

    @Query("employee")
    public Employee findById(@Name("id") Long id) {
        return repository.findById(id);
    }

    @Query("employeesWithFilter")
    public List<Employee> findWithFilter(@Name("filter") EmployeeFilter filter) {
        return repository.findByCriteria(filter);
    }

}