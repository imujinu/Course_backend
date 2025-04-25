package coruse.Course_registration.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import coruse.Course_registration.domain.Course;
import coruse.Course_registration.domain.QCourse;

import java.util.List;
import java.util.Optional;

public class CourseRepositoryImpl implements CourseRepositoryCustom{
    JPAQueryFactory jpaQueryFactory;

    public CourseRepositoryImpl(JPAQueryFactory jpaQueryFactory){
        this.jpaQueryFactory= jpaQueryFactory;
    }

    @Override
    public Optional<List<Course>> findByCourseNumber(List<Long> coursesNumber) {
        QCourse course = QCourse.course1;
        List<Course> result= jpaQueryFactory
               .selectFrom(course)
               .where(course.id.in(coursesNumber))
               .fetch();
        return Optional.of(result);
    }
}
