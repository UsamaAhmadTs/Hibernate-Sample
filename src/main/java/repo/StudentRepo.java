package repo;

import entity.Student;

import java.util.List;

public interface StudentRepo {
    List<Student> getAllStudents();
    Student getStudentById(int studentId);
    void addStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(int studentId);
}
