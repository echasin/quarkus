package org.demo.resource;


import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Name;
import org.demo.domain.Organization;
import org.demo.domain.OrganizationInput;
import org.demo.repository.OrganizationRepository;

@GraphQLApi
public class OrganizationMutation {

    OrganizationRepository organizationRepository;

    OrganizationMutation(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    @Mutation("newOrganization")
    public Organization newOrganization(@Name("data")  OrganizationInput organizationInput) {
        Organization organization = (new Organization(null, organizationInput.getName(), null, null));
        organizationRepository.persist(organization);
        return organization;
    }

}