package org.tinder.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.tinder.model.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
}
