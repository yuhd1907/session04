package ra.edu.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ra.edu.dto.StudentCreateRequest;
import ra.edu.entity.Student;
import ra.edu.repository.StudentRepository;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public Student save(StudentCreateRequest req){
        Student student = new Student();
        student.setName(req.getName());
        return studentRepository.save(student);
    }
}
