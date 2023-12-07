package dbp.UnivJPQLTemplate.repository;

import dbp.UnivJPQLTemplate.entity.Student; // Student.java 경로
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    public Optional<Student> findStudentById(Long id);
    public List<Student> findStudentByName(String name);

    @Modifying
    @Transactional
    public void updateStudentAddress(Long id, String address);

    @Modifying
    @Transactional
    public void deleteStudentById(Long id);

    public List<Student> getAllStudents();
}

