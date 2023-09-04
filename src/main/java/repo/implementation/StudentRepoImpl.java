package repo.implementation;

import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import repo.StudentRepo;

import java.util.List;

public class StudentRepoImpl implements StudentRepo {

    private final SessionFactory sessionFactory;

    public StudentRepoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Student> getAllStudents() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Student", Student.class).list();

        }
    }

    @Override
    public Student getStudentById(int studentId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Student.class, studentId);

        }
    }

    @Override
    public void addStudent(Student student) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.save(student);
            tx.commit();
        }
    }

    @Override
    public void updateStudent(Student student) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.update(student);
            tx.commit();
        }
    }

    @Override
    public void deleteStudent(int studentId) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            Student student = session.get(Student.class, studentId);
            if (student != null) {
                session.delete(student);
            }
            tx.commit();
        }
    }
}
