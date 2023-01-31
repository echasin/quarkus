package org.demo.resource;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.Query;
import org.demo.domain.Student;
import org.demo.domain.StudentInput;
import org.demo.domain.Organization;
import org.demo.repository.StudentRepository;
import org.demo.repository.OrganizationRepository;

@GraphQLApi
public class StudentMutation {

    StudentRepository studentRepository;
    OrganizationRepository organizationRepository;

    StudentMutation(StudentRepository studentRepository, OrganizationRepository organizationRepository) {
        this.studentRepository = studentRepository;
        this.organizationRepository = organizationRepository;
    }

    @Mutation("newStudent")
    public Student newStudent(@Name("values") StudentInput studentInput) {
        Student student = new Student(null, studentInput.getStudentIdentifier(), studentInput.getStudentJson());
        studentRepository.persist(student);
        return student;
    }

    //return int number of updated records
    @Mutation("updateStudent")
    public int updateStudent(@Name("data") StudentInput studentInput) {
       return studentRepository.update("studentJson = ?1 where id = ?2", studentInput.getStudentJson(), studentInput.getId());
    }

  
    //return boolen true if success, otherwise return false
    @Mutation("deleteStudent")
    public boolean deleteStudent(@Name("id")long id) {
       return  studentRepository.deleteById(id);
    }

}