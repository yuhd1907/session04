package ra.edu.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentEnrollmentRequest {
    @NotNull(message = "Student ID is required")
    private Long studentId;
    @NotNull(message = "Course ID is required")
    private Long courseId;
}
