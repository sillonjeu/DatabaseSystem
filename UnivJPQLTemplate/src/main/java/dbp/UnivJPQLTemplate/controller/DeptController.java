package dbp.UnivJPQLTemplate.controller;

import dbp.UnivJPQLTemplate.entity.Dept; // Dept.java 경로
import dbp.UnivJPQLTemplate.entity.Student;
import dbp.UnivJPQLTemplate.service.DeptService; // DeptService.java 경로
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dbp")
public class DeptController {
    @Autowired
    DeptService deptService;

    @GetMapping("/dept/name/{name}") // name으로 조회
    public Optional<Dept> findByDeptName(@PathVariable String name) {
        return deptService.findDeptByName(name);
    }
    @GetMapping("/dept/building/{building}")
    public List<Dept> findByDeptBuilding(@PathVariable String building) {
        return deptService.findDeptByBuilding(building);
    }

    @PutMapping("/update/{id}/{building}")
    public String updateDeptBuilding(@PathVariable Long id, @PathVariable String building) {
        deptService.updateDeptBuilding(id, building);
        return "updated";
    }

    @DeleteMapping("/dept/{id}")
    public String deleteDeptById(@PathVariable Long id) {
        deptService.deleteDeptById(id);
        return "deleted";
    }
    @PostMapping("/dept/add")
    public List<Dept> addDept(@RequestBody List<Dept> dept) {
        return deptService.addDept(dept);
    }
}