package ra.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.edu.entity.StudentEnrollment;

@Repository
public interface StudentEnrollmentRepository extends JpaRepository<StudentEnrollment,Long> {
}
