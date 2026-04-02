package ra.edu.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.edu.dto.ApiResponse;
import ra.edu.dto.CourseCreateRequest;
import ra.edu.dto.CourseUpdateRequest;
import ra.edu.entity.Course;
import ra.edu.service.CourseService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Course>>> getAllCourses() {
        return ResponseEntity.ok(
                new ApiResponse<>(true, "Fetched courses successfully", courseService.findAll())
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Course>> getCourseById(@PathVariable Long id) {
        try {
            Course course = courseService.findById(id);
            return ResponseEntity.ok(
                    new ApiResponse<>(true, "Fetched course successfully", course)
            );
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse<>(false, e.getMessage(), null));
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Course>> addCourse(@RequestBody CourseCreateRequest req) {
        Course created = courseService.createCourse(req);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>(true, "Created course successfully", created));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Course>> updateCourse(@RequestBody CourseUpdateRequest req, @PathVariable Long id) {
        try {
            Course updatedCourse = courseService.updateCourse(id, req);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse<>(true, "Course updated", updatedCourse)
            );
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse<>(false, e.getMessage(), null));
        }
    }
}
