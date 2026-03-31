package ra.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.edu.entity.Instructor;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor,Long> {
}
