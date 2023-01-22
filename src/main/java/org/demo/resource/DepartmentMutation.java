package org.demo.resource;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.Query;
import org.demo.domain.Department;
import org.demo.domain.DepartmentInput;
import org.demo.domain.Organization;
import org.demo.repository.DepartmentRepository;
import org.demo.repository.OrganizationRepository;

@GraphQLApi
public class DepartmentMutation {

    DepartmentRepository departmentRepository;
    OrganizationRepository organizationRepository;

    DepartmentMutation(DepartmentRepository departmentRepository, OrganizationRepository organizationRepository) {
        this.departmentRepository = departmentRepository;
        this.organizationRepository = organizationRepository;
    }

    @Mutation("newDepartment")
    public Department newDepartment(@Name("data") DepartmentInput departmentInput) {
        Organization organization = organizationRepository.findById(departmentInput.getOrganizationId());
        Department department = new Department(null, departmentInput.getName(), null, organization);
        departmentRepository.persist(department);
        return department;
    }

    //Ali addd update record
    //return int number of updated records
    @Mutation("updateDepartment")
    public int updateDepartment(@Name("data") DepartmentInput departmentInput) {
       return departmentRepository.update("name = ?2 where id = ?1", departmentInput.getId(), departmentInput.getName());
    }

    //Ali add delete record with id
    //return boolen true if success, otherwise return false
    @Mutation("deleteDepartment")
    public boolean deleteDepartment(long departmentId) {
       return  departmentRepository.deleteById(departmentId);
    }

}