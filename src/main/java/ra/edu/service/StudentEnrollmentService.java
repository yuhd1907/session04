package ra.edu.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ra.edu.entity.Course;
import ra.edu.entity.Student;
import ra.edu.entity.StudentEnrollment;
import ra.edu.repository.CourseRepository;
import ra.edu.repository.StudentEnrollmentRepository;
import ra.edu.repository.StudentRepository;

@Service
@RequiredArgsConstructor
public class StudentEnrollmentService {
    private final StudentEnrollmentRepository studentEnrollmentRepository;
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    public StudentEnrollment enrollStudent(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new RuntimeException("Student not found with id: " + studentId));
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new RuntimeException("Course not found with id: " + courseId));
        StudentEnrollment enrollment = new StudentEnrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);
        return studentEnrollmentRepository.save(enrollment);
    }
}
