package ra.edu.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ra.edu.dto.CourseCreateRequest;
import ra.edu.dto.CourseUpdateRequest;
import ra.edu.entity.Course;
import ra.edu.entity.Instructor;
import ra.edu.repository.CourseRepository;
import ra.edu.repository.InstructorRepository;
import ra.edu.repository.StudentEnrollmentRepository;
import ra.edu.repository.StudentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final InstructorRepository instructorRepository;
    private final StudentRepository studentRepository;
    private final StudentEnrollmentRepository studentEnrollmentRepository;

    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    public Course findById(Long id) {
        return courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Course not found with id: " + id));
    }

    public Course createCourse(CourseCreateRequest req) {
        Course course = new Course();
        course.setTitle(req.getTitle());
        course.setCourseStatus(req.getStatus());
        Instructor instructor = instructorRepository.findById(req.getInstructorId()).orElseThrow(() -> new RuntimeException("Instructor not found with id: " + req.getInstructorId()));
        course.setInstructor(instructor);
        return courseRepository.save(course);
    }

    public Course updateCourse(Long id, CourseUpdateRequest req) {
        Course course = findById(id);
        course.setTitle(req.getTitle());
        course.setCourseStatus(req.getStatus());
        Instructor instructor = instructorRepository.findById(req.getInstructorId()).orElseThrow(() -> new RuntimeException("Instructor not found with id: " + req.getInstructorId()));
        course.setInstructor(instructor);
        return courseRepository.save(course);
    }
}
