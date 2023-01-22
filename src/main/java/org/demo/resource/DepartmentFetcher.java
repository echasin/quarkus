package org.demo.resource;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.Query;
import org.demo.domain.Department;
import org.demo.repository.DepartmentRepository;

import java.util.List;

@GraphQLApi
public class DepartmentFetcher {

    private DepartmentRepository repository;

    DepartmentFetcher(DepartmentRepository repository) {
        this.repository = repository;
    }

    @Query("departments")
    public List<Department> findAll() {
        return repository.findAllByCriteria();
    }

    @Query("department")
    public Department findByIdW(@Name("id") Long id) {
        return repository.findById(id);
    }

}