package ra.edu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ra.edu.model.Instructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InstructorCreateRequest {
    private String name;
    private String email;
}
