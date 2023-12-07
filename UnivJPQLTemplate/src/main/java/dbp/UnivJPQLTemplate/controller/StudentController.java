package dbp.UnivJPQLTemplate.controller;

import dbp.UnivJPQLTemplate.entity.Student; // Student.java 경로
import dbp.UnivJPQLTemplate.service.StudentService; // StudentService.java 경로
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/student/id/{id}") // id로 조회
    public Optional<Student> findByStudentId(@PathVariable Long id) {
        return studentService.findStudentById(id);
    }
    @GetMapping("/student/name/{name}")
    public List<Student> findStudentByName(@PathVariable String name) {
        return studentService.findStudentByName(name);
    }
    @PutMapping("/update/{id}/{address}")
    public String updateStudentAddress(@PathVariable Long id, @PathVariable String address) {
        studentService.updateStudentAddress(id, address);
        return "updated";
    }
    @DeleteMapping("/delete/{id}")
    public String deleteStudentById(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return "deleted";
    }
    @PostMapping("/student/add")
    public List<Student> addStudents(@RequestBody List<Student> students) {
        return studentService.addStudents(students);
    }
    @GetMapping("/student/all")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }
}
