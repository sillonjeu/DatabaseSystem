package dbp.UnivJPQLTemplate.service;

import dbp.UnivJPQLTemplate.entity.Dept; // Dept.java 경로
import dbp.UnivJPQLTemplate.entity.Student;
import dbp.UnivJPQLTemplate.repository.DeptRepository; // DeptRepository.java 경로
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class DeptService {
    @Autowired
    DeptRepository deptRepository;

    public Optional<Dept> findDeptByName(String name) {
        return deptRepository.findDeptByName(name);
    }
    public List<Dept> findDeptByBuilding(String building) {
        return deptRepository.findDeptByBuilding(building);
    }

    public void updateDeptBuilding(Long id, String building) {
        deptRepository.updateDeptBuilding(id, building);
    }
    public void deleteDeptById(Long id) {
        deptRepository.deleteDeptById(id);
    }
    public List<Dept> addDept(List<Dept> dept) {
        deptRepository.saveAll(dept);
        return dept;
    }
}