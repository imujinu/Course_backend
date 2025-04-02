package coruse.Course_registration.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import coruse.Course_registration.domain.QUser;
import coruse.Course_registration.domain.User;
import org.springframework.data.jpa.repository.query.JpaQueryMethodFactory;
import java.util.List;


public class UserRepositoryImpl implements UserRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public UserRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    @Override
    public List<User> findUsersWithCustomQuery(Long keyword) {
        QUser qUser = QUser.user;
        return queryFactory
                .selectFrom(qUser)
                .where(qUser.name.contains(String.valueOf(keyword)))
                .fetch();
    }
}