package org.demo.repository;

import graphql.schema.DataFetchingEnvironment;
import graphql.schema.DataFetchingFieldSelectionSet;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.smallrye.graphql.api.Context;
import org.demo.domain.Student;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import javax.transaction.Transactional;

import java.util.List;

@ApplicationScoped
@Transactional
public class StudentRepository implements PanacheRepository<Student> {

    private EntityManager em;
    private Context context;

    public StudentRepository(EntityManager em, Context context) {
        this.em = em;
        this.context = context;
    }

    
    public Student findById(Long id) {
        Student student = em.find(Student.class, id);
        return student;
    }
    
 
}
