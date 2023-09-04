package repo.implementation;

import entity.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import repo.CourseRepo;

import java.util.List;


public class CourseRepoImpl implements CourseRepo {

    private final SessionFactory sessionFactory;

    public CourseRepoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Course> getAllCourses() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Course", Course.class).list();
        }
    }

    @Override
    public Course getCourseById(int courseId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Course.class, courseId);
        }
    }

    @Override
    public void addCourse(Course course) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.save(course);
            tx.commit();
        }
    }

    @Override
    public void updateCourse(Course course) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.update(course);
            tx.commit();
        }
    }

    @Override
    public void deleteCourse(int courseId) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            Course course = session.get(Course.class, courseId);
            if (course != null) {
                session.delete(course);
            }
            tx.commit();
        }
    }
}
