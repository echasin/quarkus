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
    public Department newDepartment(@Name("input") DepartmentInput departmentInput) {
        Organization organization = organizationRepository.findById(departmentInput.getOrganizationId());
        Department department = new Department(null, departmentInput.getName(), null, organization);
        departmentRepository.persist(department);
        return department;
    }

}