package ra.edu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ra.edu.entity.CourseStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseCreateRequest {
    private String title;
    private CourseStatus status;
    private Long instructorId;
}
