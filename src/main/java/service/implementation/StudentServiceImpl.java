package service.implementation;

import entity.Student;
import repo.StudentRepo;
import service.StudentService;

import java.util.List;


public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepository;


    public StudentServiceImpl(StudentRepo studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    public Student getStudentById(int studentId) {
        return studentRepository.getStudentById(studentId);
    }

    public void addStudent(Student student) {
        studentRepository.addStudent(student);
    }

    public void updateStudent(Student student) {
        studentRepository.updateStudent(student);
    }

    public void deleteStudent(int studentId) {
        studentRepository.deleteStudent(studentId);
    }
}
