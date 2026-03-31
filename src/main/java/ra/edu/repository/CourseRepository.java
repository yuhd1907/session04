package ra.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.edu.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
