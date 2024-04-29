package Pegas.repository;

import Pegas.dto.UserAgeFilterDto;
import Pegas.entity.User;

import java.util.List;

public interface FilterUserRepository {
    List<User> findAllByFilter(Integer age, UserAgeFilterDto filter);
}
