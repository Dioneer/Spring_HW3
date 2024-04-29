package Pegas.repository;

import Pegas.dto.UserAgeFilterDto;
import Pegas.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>, FilterUserRepository {
    List<User> findAllByOrderByAgeDesc();

    Page<User> findAllByOrderByAgeDesc(Pageable pageable);

    @Query("select avg(u.age) from User u ")
    Double avgOfAge();

    List<User> findAllByFilter(Integer age, UserAgeFilterDto filter);
}
