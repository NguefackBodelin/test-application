package com.simple.test.testapplication.search;

import com.simple.test.testapplication.entity.Users;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UsersSpecification {

  public Specification<Users> getUsers(Users users) {
    return (root, query, criteriaBuilder) -> {
      List<Predicate> predicates = new ArrayList<>();

      if (StringUtils.hasLength(users.getIdentity())) {
        predicates.add(criteriaBuilder.equal(root.get("identity"), users.getIdentity()));
      }

      if (StringUtils.hasLength(users.getName())) {
        predicates.add(criteriaBuilder.like(root.get("name"), "%" + users.getName() + "%"));
      }

      if (StringUtils.hasLength(users.getSurname())) {
        predicates.add(criteriaBuilder.like(root.get("surname"), "%" + users.getSurname() + "%"));
      }

      /*  if (orderDirection.equalsIgnoreCase("DESC")) {
              query.orderBy(criteriaBuilder.desc(root.get(orderBy)));
            } else if (orderDirection.equalsIgnoreCase("ASC")) {
              query.orderBy(criteriaBuilder.asc(root.get(orderBy)));
            }
      */
      return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    };
  }
}
