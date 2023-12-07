package dbp.UnivJPQLTemplate.repository;

import dbp.UnivJPQLTemplate.entity.Dept; // Dept.java 경로
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface DeptRepository extends JpaRepository<Dept, Long> {
    public Optional<Dept> findDeptByName(String name);
    public List<Dept> findDeptByBuilding(String building);

    @Modifying
    @Transactional
    public void updateDeptBuilding(Long id, String building);

    @Modifying
    @Transactional
    public void deleteDeptById(Long id);
}


