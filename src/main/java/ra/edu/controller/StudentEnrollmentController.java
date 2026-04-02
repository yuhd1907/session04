package ra.edu.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ra.edu.dto.ApiResponse;
import ra.edu.dto.StudentEnrollmentRequest;
import ra.edu.entity.StudentEnrollment;
import ra.edu.service.StudentEnrollmentService;

@RestController
@RequestMapping("/api/v1/students/enrollments")
@RequiredArgsConstructor
public class StudentEnrollmentController {
    private final StudentEnrollmentService studentEnrollmentService;

    @PostMapping
    public ResponseEntity<ApiResponse<StudentEnrollment>> enrollStudent(@RequestBody @Valid StudentEnrollmentRequest req) {
        try {
            StudentEnrollment enrollStudent = studentEnrollmentService.enrollStudent(req.getStudentId(), req.getCourseId());
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse<>(true, "Student enrolled successfully", enrollStudent));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ApiResponse<>(false, e.getMessage(), null));
        }
    }
}
