package service.implementation;

import repo.CourseRepo;
import entity.Course;
import service.CourseService;

import java.util.List;

public class CourseServiceImpl implements CourseService {

    private final CourseRepo courseRepository;

    public CourseServiceImpl(CourseRepo courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.getAllCourses();
    }

    @Override
    public Course getCourseById(int courseId) {
        return courseRepository.getCourseById(courseId);
    }

    @Override
    public void addCourse(Course course) {
        courseRepository.addCourse(course);
    }

    @Override
    public void updateCourse(Course course) {
        courseRepository.updateCourse(course);
    }

    @Override
    public void deleteCourse(int courseId) {
        courseRepository.deleteCourse(courseId);
    }
}
