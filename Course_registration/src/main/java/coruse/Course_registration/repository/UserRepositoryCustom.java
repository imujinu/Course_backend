package coruse.Course_registration.repository;

import coruse.Course_registration.domain.User;

import java.util.List;

public interface UserRepositoryCustom {
    List<User> findUsersWithCustomQuery(Long keyword);
}
