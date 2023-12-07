package dbp.UnivJPQLTemplate.repository.impl;

import dbp.UnivJPQLTemplate.entity.Student; // Student.java 경로
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static dbp.UnivJPQLTemplate.entity.QDept.dept;
import static dbp.UnivJPQLTemplate.entity.QStudent.student;

@Repository
public class StudentRepositoryImpl extends QuerydslRepositorySupport {
    private final JPAQueryFactory jpaQueryFactory;

    public StudentRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        super(Student.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public Student findStudentById(Long id) { // id로 조회
        return jpaQueryFactory
                .selectFrom(student)
                .where(student.id.eq(id))
                .fetchOne();
    }

    public List<Student> findStudentByName(String name) {
        return jpaQueryFactory
                .selectFrom(student)
                .where(student.name.eq(name))
                .fetch();
    }

    public void updateStudentAddress(Long id, String address) {
        long execute = jpaQueryFactory
                .update(student)
                .set(student.address, address)
                .where(student.id.eq(id))
                .execute();
    }

    public void deleteStudentById(Long id) {
        long execute = jpaQueryFactory
                .delete(student)
                .where(student.id.eq(id))
                .execute();
    }

    public List<Student> getAllStudents() {
        return jpaQueryFactory
                .select(student)
                .distinct()
                .from(student)
                .innerJoin(student.dept,dept)
                .fetchJoin().fetch();
    }
}



