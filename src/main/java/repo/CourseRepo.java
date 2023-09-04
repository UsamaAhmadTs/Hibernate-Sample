package repo;

import entity.Course;

import java.util.List;

public interface CourseRepo{

    List<Course> getAllCourses();

    Course getCourseById(int courseId);

    void addCourse(Course course);

    void updateCourse(Course course);

    void deleteCourse(int courseId);
}
