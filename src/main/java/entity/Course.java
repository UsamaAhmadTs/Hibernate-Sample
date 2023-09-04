package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "courses")
@Getter
@Setter
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "course_name")
    private String courseName;

    @OneToMany(mappedBy = "course", cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "student_id")
    private Set<Student> students;


    public Course() {
        this.students = new HashSet<>();
    }

    public Course(String courseName) {
        this.courseName = courseName;
        this.students = new HashSet<>();
    }
//    public void addStudent(Student student) {
//        students.add(student);
//        student.setCourse(this);
//    }
//
//    public void removeStudent(Student student) {
//        students.remove(student);
//        student.setCourse(null);
//    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                '}';
    }
}
