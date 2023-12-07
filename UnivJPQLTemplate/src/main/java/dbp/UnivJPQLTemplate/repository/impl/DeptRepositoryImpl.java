package dbp.UnivJPQLTemplate.repository.impl;

import dbp.UnivJPQLTemplate.entity.Dept; // Dept.java 경로
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

import static dbp.UnivJPQLTemplate.entity.QDept.dept;
import static dbp.UnivJPQLTemplate.entity.QStudent.student;

@Repository
public class DeptRepositoryImpl extends QuerydslRepositorySupport {
    private final JPAQueryFactory jpaQueryFactory;

    public DeptRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        super(Dept.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public Dept findDeptByName(String name) { // name으로 조회
        return jpaQueryFactory
                .selectFrom(dept)
                .where(dept.name.eq(name))
                .fetchOne();
    }

    public List<Dept> findDeptByBuilding(String building) {
        return jpaQueryFactory
                .selectFrom(dept)
                .where(dept.building.eq(building))
                .fetch();
    }

    public void updateDeptBuilding(Long id, String building) {
        long execute = jpaQueryFactory
                .update(dept)
                .set(dept.building, building)
                .where(dept.id.eq(id))
                .execute();
    }

    public void deleteDeptById(Long id) {
        long execute = jpaQueryFactory
                .delete(dept)
                .where(dept.id.eq(id))
                .execute();
    }
}


