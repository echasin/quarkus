package org.demo.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.demo.domain.Organization;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@Transactional
public class OrganizationRepository implements PanacheRepository<Organization> {

    private EntityManager em;

    public OrganizationRepository(EntityManager em) {
        this.em = em;
    }
}
