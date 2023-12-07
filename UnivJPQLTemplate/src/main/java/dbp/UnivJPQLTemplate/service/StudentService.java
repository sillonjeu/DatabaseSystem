package dbp.UnivJPQLTemplate.service;

import dbp.UnivJPQLTemplate.entity.Student; // Student.java 경로
import dbp.UnivJPQLTemplate.repository.StudentRepository; // StudentRepository.java 경로
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public Optional<Student> findStudentById(Long id) {
        return studentRepository.findStudentById(id);
    }
    public List<Student> findStudentByName(String name) {
        return studentRepository.findStudentByName(name);
    }
    public void updateStudentAddress(Long id, String address) {
        studentRepository.updateStudentAddress(id, address);
    }
    public void deleteStudentById(Long id) {
        studentRepository.deleteStudentById(id);
    }
    public List<Student> addStudents(List<Student> students) {
        studentRepository.saveAll(students);
        return students;
    }
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}