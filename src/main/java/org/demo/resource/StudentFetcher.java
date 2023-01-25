package org.demo.resource;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.Query;
import org.demo.domain.Student;
import org.demo.repository.StudentRepository;

import java.util.List;

import javax.transaction.Transactional;

@GraphQLApi
@Transactional
public class StudentFetcher {

    private StudentRepository repository;

    public StudentFetcher(StudentRepository repository){
        this.repository = repository;
    }

    @Query("students")
    public List<Student> findAll() {
        return repository.listAll();
    }

    @Query("student")
    public Student findById(@Name("id") Long id) {
        return repository.findById(id);
    }
}