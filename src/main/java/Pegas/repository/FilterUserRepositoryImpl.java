package Pegas.repository;

import Pegas.dto.UserAgeFilterDto;
import Pegas.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class FilterUserRepositoryImpl implements FilterUserRepository{
    private final EntityManager entityManager;

    @Override
    public List<User> findAllByFilter(Integer age, UserAgeFilterDto filter) {
        var cb = entityManager.getCriteriaBuilder();
        var criteria = cb.createQuery(User.class);
        var user = criteria.from(User.class);
        criteria.select(user);

        List<Predicate> predicates = new ArrayList<>();
        if(filter.age() != null){
            predicates.add(cb.lessThan(user.get("age"), age));
        }
        criteria.where(predicates.toArray(jakarta.persistence.criteria.Predicate[]::new));
        return entityManager.createQuery(criteria).getResultList();
    }
}
